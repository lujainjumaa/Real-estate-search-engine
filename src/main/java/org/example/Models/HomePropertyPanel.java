package org.example.Models;

import javax.swing.*;
import java.awt.*;

public class HomePropertyPanel {

    private JPanel ShowProperty;

    public HomePropertyPanel(HomeProperty HomeProperty){
        ShowProperty =new JPanel();
        ShowProperty.setLayout(new GridLayout(0, 2, 10, 10));
        ShowProperty.add(new JLabel("Owner"));
        ShowProperty.add(new JLabel(HomeProperty.getTheOwner()));
        ShowProperty.add(new JLabel("Governorate"));
        ShowProperty.add(new JLabel(HomeProperty.getGovernorate()));
        ShowProperty.add(new JLabel("more info"));
        ShowProperty.add(new JLabel(HomeProperty.getMoreInfo()));
        ShowProperty.add(new JLabel("real state"));
        ShowProperty.add(new JLabel(HomeProperty.getRealStateArea()));
        ShowProperty.add(new JLabel("getRealStateArea"));
        ShowProperty.add(new JLabel(HomeProperty.getRealStateArea()));
        ShowProperty.add(new JLabel("Real State Area"));
        ShowProperty.add(new JLabel(String.valueOf(HomeProperty.getRealStateArea())));
        ShowProperty.add(new JLabel("A"));
        ShowProperty.add(new JLabel(String.valueOf(HomeProperty.getRealEstateYield())));
        ShowProperty.add(new JLabel("Price"));
        ShowProperty.add(new JLabel(String.valueOf(HomeProperty.getPrice())));
    }
    public JPanel getShowProperty(){
        return ShowProperty;
    }
}
