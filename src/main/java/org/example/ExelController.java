package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExelController {

    FileInputStream fileInputStream = null;

    public Sheet open(String filepath) throws FileNotFoundException {
        fileInputStream = new FileInputStream(new File(filepath));
        try {
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            return workbook.getSheetAt(0);

        } catch (IOException e) {
            System.out.println("Error opening the file: " + e.getMessage());

        }
        return null;
    }

    public void test(String filepath) throws FileNotFoundException {
        Row row = open(filepath).getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);
    }

    public List<String> getFirstRowValues(String filepath) throws FileNotFoundException {
        List<String> rowValues = new ArrayList<>();
        Row row = open(filepath).getRow(0);
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
    public Cell getcell(int rowIndex ,int columnIndex,String filepath) throws FileNotFoundException {
        Row row = open(filepath).getRow(rowIndex);
        return row.getCell(columnIndex);
    }
    public String removeInvisibleCharacters(String input) {
        return input.replaceAll("[\\p{C}\\p{Z}\\u00A0\\u200E\\u200F\\u202A\\u202B\\u202C\\u202D\\u202E\\uFEFF]", "").trim();
    }
}