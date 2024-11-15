package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelFile {

    FileInputStream fileInputStream;
    private Sheet sheet;
    String[] firstRowValues;

    public ExcelFile(String filepath) {
        sheet = open(filepath);
        firstRowValues = getFirstRowValues().toArray(new String[0]);

    }

    public Sheet open(String filepath) {
        filepath = "src/main/resources/" + filepath;
        try {
            fileInputStream = new FileInputStream(new File(filepath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            return workbook.getSheetAt(0);

        } catch (IOException e) {
            System.out.println("Error opening the file: " + e.getMessage());

        }

        return null;
    }

    public void test(String filepath) {
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);
    }

    public List<String> getFirstRowValues() {
        List<String> rowValues = new ArrayList<>();
        Row row = sheet.getRow(0);
        for (Cell cell : row) {
            switch (cell.getCellType()) {
                case STRING:
                    rowValues.add(cell.getStringCellValue());
                    break;
                case NUMERIC:
                    rowValues.add(String.valueOf(cell.getNumericCellValue()));
                    break;
                default:
                    rowValues.add("");
                    break;
            }
        }
        return rowValues;
    }

    public Cell getcell(int rowIndex, int columnIndex) {
        Row row = sheet.getRow(rowIndex);
        return row.getCell(columnIndex);
    }

    public String removeInvisibleCharacters(String input) {
        return input.replaceAll("[\\p{C}\\p{Z}\\u00A0\\u200E\\u200F\\u202A\\u202B\\u202C\\u202D\\u202E\\uFEFF]", "").trim();
    }

    public List<HomeProperty> getPropertiesFromSheet() {
        List<HomeProperty> properties = new ArrayList<>();

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

        return properties;
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return "";
        }
    }

    private double getCellValueAsNumeric(Cell cell) {
        if (cell == null) return 0;
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return 0;
        }
    }
}