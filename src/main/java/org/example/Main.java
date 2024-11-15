package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExcelFile controller = new ExcelFile("Data.xlsx");
        String[] firstRowValues = controller.getFirstRowValues().toArray(new String[0]);
        SearchFrame searchFrame = new SearchFrame(firstRowValues);
        searchFrame.setVisible(true);
        controller.test("Data.xlsx");
        for (String value : firstRowValues) {
            System.out.println(value);
        }
        System.out.println(controller.getcell(1,1));
    }
}