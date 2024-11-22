package org.example.Frames;

import org.example.Controller.SearchController;
import org.example.Models.HomeProperty;
import org.example.Models.HomePropertyPanel;
import org.example.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultFrame extends JFrame {
    String key;
    String value;
    List<HomeProperty> matches = new ArrayList<>();

    public ResultFrame(String key, String value) {
        this.key = key;
        this.value = value;
        value= Utils.removeInvisibleCharacters(value);
        setTitle("Properties");
        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1280, 50));
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel title = new JLabel("Properties");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(title);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JPanel headerPanel =Utils.createRowPanel(true);
        headerPanel.add(Utils.createFixedLabel("رقم العقار", true));
        headerPanel.add(Utils.createFixedLabel("المالك", true));
        headerPanel.add(Utils.createFixedLabel("المحافظة", true));
        headerPanel.add(Utils.createFixedLabel("السعر الرائج", true));
        headerPanel.add(Utils.createFixedLabel("المساحة", true));
        headerPanel.add(Utils.createFixedLabel("خيارات", true));
        contentPanel.add(headerPanel);

        matches = SearchController.matchesHomeProperty(key, value);

        if (matches.isEmpty()) {
            JLabel noResultsLabel = new JLabel("No results found.", JLabel.CENTER);
            noResultsLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            contentPanel.add(noResultsLabel);
        } else {
            for (HomeProperty match : matches) {
                HomePropertyPanel A=new HomePropertyPanel(match);

                contentPanel.add(A.getShowProperty());
            }
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

}
