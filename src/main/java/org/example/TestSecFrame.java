package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestSecFrame extends JFrame {
    int indexkey;
    String value;
    List<HomeProperties> properties = new ArrayList<HomeProperties>();

    public TestSecFrame(int key, String value) {

        this.indexkey=key;
        this.value=value;
        this.properties=properties;
        setTitle("Result Frame");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Display the key and value passed from SearchFrame
        JLabel resultLabel = new JLabel("Key: " + key + ", Value: " + value);
        add(resultLabel);
    }



}