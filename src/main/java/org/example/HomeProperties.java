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
        sheet=getsheet.open("Data.xlsx");
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);

            String theOwner = getCellValueAsString(row.getCell(1));
            int id = (int) getCellValueAsNumeric(row.getCell(0)); // Updated to handle numeric safely
            String moreInfo = getCellValueAsString(row.getCell(4));
            String governorate = getCellValueAsString(row.getCell(2));
            long price = (long) getCellValueAsNumeric(row.getCell(5)); // Updated
            int propertyArea = (int) getCellValueAsNumeric(row.getCell(3)); // Updated
            String realStateArea = getCellValueAsString(row.getCell(7));
            int a = (int) getCellValueAsNumeric(row.getCell(6)); // Updated

            HomeProperty property = new HomeProperty(theOwner, id, moreInfo, governorate, price, propertyArea, realStateArea, a);
            properties.add(property);
        }
    }
    public static String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return "";
        }
    }

    public static double getCellValueAsNumeric(Cell cell) {
        if (cell == null) return 0;
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return 0;
        }
    }
}
