package org.example.Frames;

import org.example.Controller.SearchController;
import org.example.Models.HomeProperty;
import org.example.Models.HomePropertyPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestSecFrame extends JFrame {
    int indexkey;
    String value;
    List<HomeProperty> matches=new ArrayList<>();
    public TestSecFrame(int key, String value) {

        this.indexkey=key;
        this.value=value;
        setTitle("Result Frame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        matches=SearchController.matchesHomeProperty(key,value);
        for (HomeProperty match : matches) {
            HomePropertyPanel propertyPanel = new HomePropertyPanel(match);
            add(propertyPanel.getShowProperty());
        }
    }
}