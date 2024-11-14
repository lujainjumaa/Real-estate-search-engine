package org.example;

import javax.swing.*;
import java.awt.*;

public class TestSecFrame extends JFrame {
    public TestSecFrame(String key, String value) {
        setTitle("Result Frame");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        // Display the key and value passed from SearchFrame
        JLabel resultLabel = new JLabel("Key: " + key + ", Value: " + value);
        add(resultLabel);
    }
}