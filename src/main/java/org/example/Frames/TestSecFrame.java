package org.example.Frames;

import javax.swing.*;
import java.awt.*;

public class TestSecFrame extends JFrame {
    int indexkey;
    String value;
    public TestSecFrame(int key, String value) {

        this.indexkey=key;
        this.value=value;
//        HomeProperties.load();
//        for (int i=0;i<HomeProperties.properties.size();i++){
//            if(HomeProperties.properties.get(i).senKeyString(key).equals(value)){
//                System.out.println(HomeProperties.properties.get(i).senKeyString(key));
//            }
//        }
        setTitle("Result Frame");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel resultLabel = new JLabel("Key: " + key + ", Value: " + value);
        add(resultLabel);
    }
}