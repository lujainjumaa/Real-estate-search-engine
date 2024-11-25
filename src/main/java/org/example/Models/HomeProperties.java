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
            List<String> rowValues = getsheet.getRowAsStrings(rowIndex);
            String id = (rowValues.size() > 0 && rowValues.get(0) != null && !rowValues.get(0).isEmpty()) ? rowValues.get(0).replaceAll("\\.0$", "") : "";
            String theOwner = (rowValues.size() > 1 && rowValues.get(1) != null && !rowValues.get(1).isEmpty()) ? rowValues.get(1) : "";
            String governorate = (rowValues.size() > 2 && rowValues.get(2) != null && !rowValues.get(2).isEmpty()) ? rowValues.get(2) : "";
            int propertyArea = (rowValues.size() > 3 && rowValues.get(3) != null && !rowValues.get(3).isEmpty()) ? Utils.turnToInt(rowValues.get(3)) : 0;
            String moreInfo = (rowValues.size() > 4 && rowValues.get(4) != null && !rowValues.get(4).isEmpty()) ? rowValues.get(4) : "";
            long price = (rowValues.size() > 5 && rowValues.get(5) != null && !rowValues.get(5).isEmpty()) ? Utils.turnToLong(rowValues.get(5)) : 0L;
            String RealEstateYield = (rowValues.size() > 6 && rowValues.get(6) != null && !rowValues.get(6).isEmpty()) ? rowValues.get(6) : "";
            String realStateArea = (rowValues.size() > 7 && rowValues.get(7) != null && !rowValues.get(7).isEmpty()) ? rowValues.get(7) : "";
            HomeProperty property = new HomeProperty(theOwner, id, moreInfo, governorate, price, propertyArea, realStateArea, RealEstateYield);
            properties.add(property);
        }
    }
}
