package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class HomeProperties {

    static List<HomeProperty> properties=new ArrayList<>();
    static private Sheet sheet;

    public static void load() {
        ExcelFile getsheet=new ExcelFile("Data.xlsx");
        Utils turn=new Utils();
        sheet=getsheet.open("Data.xlsx");
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);

            String theOwner = getsheet.getRowAsStrings(rowIndex).get(1);
            int id =  turn.turnToInt(getsheet.getRowAsStrings(rowIndex).get(0));
            String moreInfo = getsheet.getRowAsStrings(rowIndex).get(4);
            String governorate = getsheet.getRowAsStrings(rowIndex).get(2);
            long price = turn.turnToLong(getsheet.getRowAsStrings(rowIndex).get(5));
            int propertyArea =turn.turnToInt(getsheet.getRowAsStrings(rowIndex).get(3));
            String realStateArea = getsheet.getRowAsStrings(rowIndex).get(7);
            int RealEstateYield = turn.turnToInt(getsheet.getRowAsStrings(rowIndex).get(6));

            HomeProperty property = new HomeProperty(theOwner, id, moreInfo, governorate, price, propertyArea, realStateArea, RealEstateYield);
            properties.add(property);
        }
    }
}
