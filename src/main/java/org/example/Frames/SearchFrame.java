package org.example.Frames;

import org.example.Models.ExcelFile;
import org.example.Controller.SearchController;
import org.example.Models.HomeProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchFrame extends JFrame {
    private JTextField valueTextField;
    private JComboBox<String> keyDropdown;
    private JButton searchButton;

    public SearchFrame() {
        ExcelFile file=new ExcelFile("TestData.xlsx");

        setTitle("Search Frame");
        setSize(300, 200);
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
        HomeProperties.load();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKey = (String) keyDropdown.getSelectedItem();
                String enteredValue = valueTextField.getText();
                ResultFrame testSecFrame = new ResultFrame(selectedKey, enteredValue);
                testSecFrame.setVisible(true);
                System.out.println(SearchController.matchesHomeProperty(selectedKey,enteredValue));
            }
        });
    }
}
