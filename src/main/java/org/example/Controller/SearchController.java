package org.example;

import org.example.Models.HomeProperties;
import org.example.Models.HomeProperty;

import java.util.ArrayList;
import java.util.List;

public class SearchController {

    static List<HomeProperty> matches=new ArrayList<>();

    public static List<HomeProperty> matchesHomeProperty(int key,String value){
        HomeProperties.load();
        for (int i=0;i<HomeProperties.properties.size();i++){
            if(HomeProperties.properties.get(i).senKeyString(key).equals(value)){
                matches.add(HomeProperties.properties.get(i));
                System.out.println(HomeProperties.properties.get(i).senKeyString(key));
            }
        }
        return matches;
    }

    public int turnValueInt( String value){
            return Utils.turnToInt(value);
    }
    public Long turnValueLong(String value){
        return Utils.turnToLong(value);
    }
    public void turnValue(String value,int key){
        if(key==5)
            turnValueLong(value);
        else if (key==0 || key==3 || key==6)
            turnValueInt(value);
    }
}
