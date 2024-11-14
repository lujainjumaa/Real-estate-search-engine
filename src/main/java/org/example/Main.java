package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SearchFrame searchFrame = new SearchFrame();
        searchFrame.setVisible(true);
        ExelController controller = new ExelController();
        controller.test("src/main/resources/Data.xlsx");
    }
}