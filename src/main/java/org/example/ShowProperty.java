package org.example;

import javax.swing.*;
import java.awt.*;

public class ShowProperty extends JFrame {
    public ShowProperty(HomeProperty property){
        JFrame moreInfo=new JFrame("More Info");
        moreInfo.setSize(500, 500);
        moreInfo.setVisible(true);
        moreInfo.setLayout(new FlowLayout());
        JPanel ShowProperty =new JPanel();
        ShowProperty.setLayout(new GridLayout(0, 2, 10, 10));
        ShowProperty.add(new JLabel("Owner"));
        ShowProperty.add(new JLabel(property.getTheOwner()));
        ShowProperty.add(new JLabel("Governorate"));
        ShowProperty.add(new JLabel(property.getGovernorate()));
        ShowProperty.add(new JLabel("more info"));
        ShowProperty.add(new JLabel(property.getMoreInfo()));
        ShowProperty.add(new JLabel("real state"));
        ShowProperty.add(new JLabel(property.getRealStateArea()));
        ShowProperty.add(new JLabel("getRealStateArea"));
        ShowProperty.add(new JLabel(property.getRealStateArea()));
        ShowProperty.add(new JLabel("Real State Area"));
        ShowProperty.add(new JLabel(String.valueOf(property.getRealStateArea())));
        ShowProperty.add(new JLabel("A"));
        ShowProperty.add(new JLabel(String.valueOf(property.getRealEstateYield())));
        ShowProperty.add(new JLabel("Price"));
        ShowProperty.add(new JLabel(String.valueOf(property.getPrice())));
        moreInfo.add(ShowProperty);
    }
}
