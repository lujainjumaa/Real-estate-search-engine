package org.example.Models;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelFile {

    private Sheet sheet;

    public ExcelFile(String filepath) {
        sheet = open(filepath);
    }

    public Sheet open(String filepath) {
        FileInputStream fileInputStream;

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

    public List<String> getRowAsStrings(int index) {
        List<String> rowValuesAsString = new ArrayList<>();
        Row row = sheet.getRow(index);
        for (Cell cell : row) {
            String out = Utils.removeInvisibleCharacters(cell.toString());
            rowValuesAsString.add(out);
        }
        return rowValuesAsString;
    }

}