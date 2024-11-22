package org.example.Models;

import org.apache.poi.ss.usermodel.Sheet;
import org.example.Utils;

import java.util.ArrayList;
import java.util.List;

public class HomeProperties {

    public static List<HomeProperty> properties=new ArrayList<>();
    static private Sheet sheet;

    public static void load() {
        ExcelFile getsheet=new ExcelFile("TestData.xlsx");
        sheet=getsheet.open("TestData.xlsx");
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

            String theOwner = getsheet.getRowAsStrings(rowIndex).get(1);
            int id =  Utils.turnToInt(getsheet.getRowAsStrings(rowIndex).get(0));
            String moreInfo = getsheet.getRowAsStrings(rowIndex).get(4);
            String governorate = getsheet.getRowAsStrings(rowIndex).get(2);
            long price = Utils.turnToLong(getsheet.getRowAsStrings(rowIndex).get(5));
            int propertyArea =Utils.turnToInt(getsheet.getRowAsStrings(rowIndex).get(3));
            String realStateArea = getsheet.getRowAsStrings(rowIndex).get(7);
            int RealEstateYield = Utils.turnToInt(getsheet.getRowAsStrings(rowIndex).get(6));

            HomeProperty property = new HomeProperty(theOwner, id, moreInfo, governorate, price, propertyArea, realStateArea, RealEstateYield);
            properties.add(property);
        }
    }
}
