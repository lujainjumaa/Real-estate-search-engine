package org.example;

public class Utils {

    static public int turnToInt(String value){
        String strValue =  value;
        double doubleValue = Double.parseDouble(strValue);
        int intValue = (int) doubleValue;
        return intValue;
    }
    static public long turnToLong(String value){
        String strValue =  value;
        double doubleValue = Double.parseDouble(strValue);
        long intValue = (long) doubleValue;
        return intValue;
    }

}
