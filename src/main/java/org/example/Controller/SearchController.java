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
                if(HomeProperties.properties.get(i).getId().replace("\n", " ").contains(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "اسم المالك":
                if(HomeProperties.properties.get(i).getTheOwner().replace("\n", " ").contains(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "المحافظة":
                if(HomeProperties.properties.get(i).getGovernorate().replace("\n", " ").equals(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "المساحة":
                if(String.valueOf(HomeProperties.properties.get(i).getPropertyArea()).replace("\n", " ").equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "الملاحظات":
                if(HomeProperties.properties.get(i).getMoreInfo().replace("\n", " ").contains(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "السعر الرائج":
                if(String.valueOf(HomeProperties.properties.get(i).getPrice()).replace("\n", " ").equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "العائدية":
                if(HomeProperties.properties.get(i).getRealEstateYield().replace("\n", " ").contains(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case "المنطقة":
                if(HomeProperties.properties.get(i).getRealStateArea().replace("\n", " ").contains(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
        }
        }

        return matches;
    }
}
