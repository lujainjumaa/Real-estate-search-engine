package org.example;


public class Main {
    public static void main(String[] args) {
        SearchFrame searchFrame = new SearchFrame();
        searchFrame.setVisible(true);
        HomeProperty a=new HomeProperty("L",2,"L","L",2,2,"L",2);
        ShowProperty b=new ShowProperty(a);
    }

}