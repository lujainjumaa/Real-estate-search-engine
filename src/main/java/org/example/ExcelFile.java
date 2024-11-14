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

    FileInputStream fileInputStream ;
    private Sheet sheet;

    public ExcelFile(String filepath){
        sheet=open(filepath);
    }

    public Sheet open(String filepath){
        filepath="src/main/resources/"+filepath;
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
    public Cell getcell(int rowIndex ,int columnIndex) {
        Row row = sheet.getRow(rowIndex);
        return row.getCell(columnIndex);
    }
    public String removeInvisibleCharacters(String input) {
        return input.replaceAll("[\\p{C}\\p{Z}\\u00A0\\u200E\\u200F\\u202A\\u202B\\u202C\\u202D\\u202E\\uFEFF]", "").trim();
    }
}