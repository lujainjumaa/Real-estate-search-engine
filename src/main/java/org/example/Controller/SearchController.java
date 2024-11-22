package org.example.Controller;
import org.example.Models.HomeProperties;
import org.example.Models.HomeProperty;

import java.util.ArrayList;
import java.util.List;

public class SearchController {

    static List<HomeProperty> matches=new ArrayList<>();

    public static List<HomeProperty> matchesHomeProperty(String key,String value){
        matches.clear();
        for (int i=0;i<HomeProperties.properties.size();i++){
            switch (key){
            case "رقم العقار":
                if(String.valueOf(HomeProperties.properties.get(i).getId()).equals(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "اسم المالك":
                if(HomeProperties.properties.get(i).getTheOwner().equals(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "المحافظة":
                if(String.valueOf(HomeProperties.properties.get(i).getGovernorate()).equals(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "المساحة":
                if(String.valueOf(HomeProperties.properties.get(i).getPropertyArea()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "الملاحظات":
                if(String.valueOf(HomeProperties.properties.get(i).getMoreInfo()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "السعر الرائج":
                if(String.valueOf(HomeProperties.properties.get(i).getPrice()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "العائدة":
                if(String.valueOf(HomeProperties.properties.get(i).getRealEstateYield()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "المنطقة":
                if(String.valueOf(HomeProperties.properties.get(i).getRealStateArea()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
        }
        }

        return matches;
    }
}
