package org.example.Controller;
import org.example.Models.HomeProperties;
import org.example.Models.HomeProperty;

import java.util.ArrayList;
import java.util.List;

public class SearchController {

    static List<HomeProperty> matches=new ArrayList<>();

    public static List<HomeProperty> matchesHomeProperty(int key,String value){
        matches.clear();
        for (int i=0;i<HomeProperties.properties.size();i++){
            switch (key){
            case 0:
                if(String.valueOf(HomeProperties.properties.get(i).getId()).equals(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case 1:
                if(HomeProperties.properties.get(i).getTheOwner().equals(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case 2:
                if(String.valueOf(HomeProperties.properties.get(i).getGovernorate()).equals(value)) {
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case 3:
                if(String.valueOf(HomeProperties.properties.get(i).getPropertyArea()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case 4:
                if(String.valueOf(HomeProperties.properties.get(i).getMoreInfo()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case 5:
                if(String.valueOf(HomeProperties.properties.get(i).getPrice()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case 6:
                if(String.valueOf(HomeProperties.properties.get(i).getRealEstateYield()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
                break;
            case 7:
                if(String.valueOf(HomeProperties.properties.get(i).getRealStateArea()).equals(value)){
                    matches.add(HomeProperties.properties.get(i));
                }
        }
        }

        return matches;
    }
}
