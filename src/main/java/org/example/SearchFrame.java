package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchFrame extends JFrame {
    private JTextField valueTextField;
    private JComboBox<String> keyDropdown;
    private JButton searchButton;

    public SearchFrame() {
        setTitle("Search Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        valueTextField = new JTextField(15);
        add(new JLabel("Value:"));
        add(valueTextField);

        String[] keys = { "Name", "Age" };
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
