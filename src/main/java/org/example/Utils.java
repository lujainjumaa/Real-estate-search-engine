package org.example;

import javax.swing.*;
import java.awt.*;

public class Utils {

    static public int turnToInt(String value){
        String strValue =  value;
        double doubleValue = Double.parseDouble(strValue);
        int intValue = (int) doubleValue;
        return intValue;
    }
    static public long turnToLong(String value){
        String strValue =  value;
        double doubleValue = Double.parseDouble(strValue);
        long intValue = (long) doubleValue;
        return intValue;
    }
    static public String removeInvisibleCharacters(String input) {
        return input.replaceAll("[\\p{C}\\p{Z}\\u00A0\\u200E\\u200F\\u202A\\u202B\\u202C\\u202D\\u202E\\uFEFF]", "").trim();
    }

    public static JLabel createFixedLabel(String text, boolean isHeader) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setPreferredSize(new Dimension(200, 40));
        label.setMaximumSize(new Dimension(200, 40));
        label.setMinimumSize(new Dimension(200, 40));
        if (isHeader) {
            label.setFont(new Font("Arial", Font.BOLD, 18));
        } else {
            label.setFont(new Font("Arial", Font.PLAIN, 16));
        }
        return label;
    }

    public static JPanel createRowPanel(boolean isHeader) {
        JPanel panel = new JPanel(new GridLayout(1, 6));
        panel.setPreferredSize(new Dimension(1280, 40));
        panel.setMaximumSize(new Dimension(1280, 40));
        panel.setMinimumSize(new Dimension(1280, 40));
        if (isHeader) {
            panel.setBackground(Color.LIGHT_GRAY);
        } else {
            panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        }
        return panel;
    }
}
