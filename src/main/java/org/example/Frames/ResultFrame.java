package org.example.Frames;

import org.example.Controller.SearchController;
import org.example.Models.HomeProperty;
import org.example.Models.HomePropertyPanel;
import org.example.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestSecFrame extends JFrame {
    int indexkey;
    String value;
    List<HomeProperty> matches = new ArrayList<>();

    public TestSecFrame(int key, String value) {
        this.indexkey = key;
        this.value = value;
        value=Utils.removeInvisibleCharacters(value);
        setTitle("Result Frame");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a panel to hold all HomePropertyPanel components
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Vertical layout

        // Get matching properties
        matches = SearchController.matchesHomeProperty(key, value);

        // Add each HomePropertyPanel to the content panel
        for (HomeProperty match : matches) {
            HomePropertyPanel propertyPanel = new HomePropertyPanel(match);
            contentPanel.add(propertyPanel.getShowProperty());
//            contentPanel.add(Box.createVerticalStrut(10)); // Add spacing between panels
        }

        // Wrap the content panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to the frame
        add(scrollPane);

        // Make the frame visible
        setVisible(true);
    }
}
