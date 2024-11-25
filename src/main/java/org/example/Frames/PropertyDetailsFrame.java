package org.example.Frames;

import org.example.Models.HomeProperty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;

public class PropertyDetailsFrame extends JFrame implements Printable {
    public JPanel ShowProperty;

    public PropertyDetailsFrame(HomeProperty property) {
        JFrame moreInfo = new JFrame("More Info");
        moreInfo.setSize(800, 600);
        moreInfo.setLayout(null);
        moreInfo.setVisible(true);

        ShowProperty = new JPanel();
        ShowProperty.setLayout(null);
        ShowProperty.setBounds(20, 20, 760, 440);
        ShowProperty.setBackground(Color.white);

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
        ShowProperty.add(createRow(String.valueOf(property.getPropertyArea() + "m²"), "المساحة:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getMoreInfo()), "ملاحظات:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getRealStateArea()), "المنطقة:", y, labelWidth, valueWidth, rowHeight));
        y += rowHeight + 10;
        ShowProperty.add(createRow(String.valueOf(property.getRealEstateYield()), "العائدية:", y, labelWidth, valueWidth, rowHeight));

        moreInfo.add(ShowProperty);

        JButton print = new JButton("Print");
        print.setBounds(350, 470, 100, 30);
        moreInfo.add(print);

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(PropertyDetailsFrame.this);

                if (job.printDialog()) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        JOptionPane.showMessageDialog(null, "Printing Failed: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
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

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.scale(0.8, 0.8);

        ShowProperty.printAll(g);

        return PAGE_EXISTS;
    }
}
