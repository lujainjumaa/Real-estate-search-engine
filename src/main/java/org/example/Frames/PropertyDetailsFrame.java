package org.example.Frames;

import org.example.Models.HomeProperty;

import javax.swing.*;
import java.awt.*;

public class PropertyDetailsFrame extends JFrame {
    public JPanel ShowProperty;

    public PropertyDetailsFrame(HomeProperty property) {
        JFrame moreInfo = new JFrame("More Info");
        moreInfo.setSize(800, 500);
        moreInfo.setLayout(null);
        moreInfo.setVisible(true);

        ShowProperty = new JPanel();
        ShowProperty.setLayout(null);
        ShowProperty.setBounds(20, 20, 760, 440);
        ShowProperty.setBackground(Color.LIGHT_GRAY);

        int y = 10;
        int rowHeight = 40;
        int labelWidth = 200;
        int valueWidth = 500;

        ShowProperty.add(createRow(String.valueOf(property.getId()), "رقم العقار:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(property.getTheOwner(), "المالك:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(property.getGovernorate(), "المحافظة:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getPrice()), "السعر:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getPropertyArea()), "المساحة:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getMoreInfo()), "ملاحظات:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getRealStateArea()), "المنطقة:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getRealEstateYield()), "العائدية:", y, labelWidth, valueWidth, rowHeight));
        moreInfo.add(ShowProperty);
    }

    private JPanel createRow(String valueText, String labelText, int y, int labelWidth, int valueWidth, int rowHeight) {
        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(null);
        rowPanel.setBounds(0, y, labelWidth + valueWidth + 20, rowHeight);

        JLabel value = new JLabel(valueText);
        value.setBounds(10, 0, valueWidth, rowHeight);
        value.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel label = new JLabel(labelText);
        label.setBounds(valueWidth + 20, 0, labelWidth, rowHeight);
        label.setHorizontalAlignment(SwingConstants.RIGHT);

        rowPanel.add(value);
        rowPanel.add(label);

        return rowPanel;
    }
}
