package org.example;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SearchFrame searchFrame = new SearchFrame();
        searchFrame.setVisible(true);
        ExelController controller = new ExelController();
        controller.test("src/main/resources/Data.xlsx");
        List<String> firstRowValues = controller.getFirstRowValues("src/main/resources/Data.xlsx");

        for (String value : firstRowValues) {
            System.out.println(value);
        }
        System.out.println(controller.getcell(1,1,"src/main/resources/Data.xlsx"));
    }
}