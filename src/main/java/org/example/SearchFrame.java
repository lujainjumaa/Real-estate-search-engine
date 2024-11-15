package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchFrame extends JFrame {
    private JTextField valueTextField;
    private JComboBox<String> keyDropdown;
    private JButton searchButton;
    List<HomeProperty> properties = new ArrayList<>();

    public SearchFrame() {
        ExcelFile file=new ExcelFile("Data.xlsx");
        properties=file.getPropertiesFromSheet();
        System.out.println(properties.get(0).getTheOwner());
        System.out.println(properties.get(0).getPrice());
        setTitle("Search Frame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        valueTextField = new JTextField(15);
        add(new JLabel("Value:"));
        add(valueTextField);

        String[] keys =  file.getFirstRowValues().toArray(new String[0]);
        keyDropdown = new JComboBox<>(keys);
        add(new JLabel("Key:"));
        add(keyDropdown);

        searchButton = new JButton("Search");
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKey = (String) keyDropdown.getSelectedItem();
                String enteredValue = valueTextField.getText();

                TestSecFrame testSecFrame = new TestSecFrame(selectedKey, enteredValue);
                testSecFrame.setVisible(true);
            }
        });
    }
}
