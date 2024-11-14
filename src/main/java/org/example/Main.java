package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchFrame searchFrame = new SearchFrame();
        searchFrame.setVisible(true);
        ExcelFile controller = new ExcelFile("src/main/resources/"+"Data.xlsx");
        controller.test("src/main/resources/"+"Data.xlsx");
        List<String> firstRowValues = controller.getFirstRowValues();

        for (String value : firstRowValues) {
            System.out.println(value);
        }
        System.out.println(controller.getcell(1,1));
    }
}