package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

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
        open(filepath);
        Row row = open(filepath).getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell);
    }
}