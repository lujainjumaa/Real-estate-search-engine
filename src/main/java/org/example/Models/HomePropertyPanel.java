package org.example.Models;

import org.example.Frames.PropertyDetailsFrame;
import org.example.Utils;

import javax.swing.*;
import java.awt.*;


public class HomePropertyPanel {
    public JPanel rowPanel;
    public HomePropertyPanel(HomeProperty match){
        rowPanel=Utils.createRowPanel(false);
        rowPanel.add(Utils.createFixedLabel(String.valueOf(match.getId()), false));
        rowPanel.add(Utils.createFixedLabel(match.getTheOwner(), false));
        rowPanel.add(Utils.createFixedLabel(match.getGovernorate(), false));
        rowPanel.add(Utils.createFixedLabel(String.valueOf(match.getPrice()), false));
        rowPanel.add(Utils.createFixedLabel(String.valueOf(match.getRealStateArea()), false));


        JButton detailsButton = new JButton("معلومات إضافية");
        detailsButton.setPreferredSize(new Dimension(200, 40));
        detailsButton.addActionListener(e -> new PropertyDetailsFrame(match));
        rowPanel.add(detailsButton);

    }
    public JPanel getShowProperty(){
        return rowPanel;
    }

}
