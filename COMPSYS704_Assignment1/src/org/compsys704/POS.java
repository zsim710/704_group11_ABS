package org.compsys704;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.systemj.netapi.SimpleClient;
import java.io.Serializable;


/*
 * Product Order System (POS) GUI
 *
 * Features a Login windows and a Order Window
 * Basic authentication, selection of liquids 1-4 and bottle quantity
 * Communication signals not set up yet
 *
 * Version 2.0 - Tested
 *
 * */




public class POS implements Serializable {

static final String IP = "127.0.0.1";
SimpleClient BottleSend, LiquidAmount1, LiquidAmount2,systemEnable;


    // Main Window Components
    JFrame mainFrame;
    JTextField[] liquidFields = new JTextField[2];
    JTextField bottleQuantityField;
    JTextArea displayArea;
    JButton submitButton;

    public POS() {
   
        try {
        BottleSend = new SimpleClient(IP, Ports.MainControllerCD_port, "MainControllerCD", "BottleQuantity");
        LiquidAmount1 = new SimpleClient(IP, Ports.MainControllerCD_port, "MainControllerCD", "LiquidAmount1");
        LiquidAmount2 = new SimpleClient(IP, Ports.MainControllerCD_port, "MainControllerCD", "LiquidAmount2");
        systemEnable = null; // Not using this signal
        System.out.println("Successfully connected to SystemJ server");
        } catch (Exception e) {
            System.err.println("Failed to connect to SystemJ server: " + e.getMessage());
            e.printStackTrace();
            // Set all to null if connection fails
            BottleSend = null;
            LiquidAmount1 = null;
            LiquidAmount2 = null;
            systemEnable = null;
        }
 
        // Setup Main Window directly
        openMainWindow();
    }

    private void openMainWindow() {
            mainFrame = new JFrame("[group 11] Personal Order System");
            mainFrame.setSize(500, 400);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLayout(new BorderLayout());

            // Left Section (Liquid Specification)
            JPanel leftPanel = new JPanel(new GridBagLayout());
            leftPanel.setBorder(BorderFactory.createTitledBorder("Liquid Specification"));
            GridBagConstraints lc = new GridBagConstraints();
            lc.insets = new Insets(5, 5, 5, 5);
            for (int i = 0; i < 2; i++) {
                lc.gridy = i;
                lc.gridx = 0;
                lc.anchor = GridBagConstraints.EAST;
                leftPanel.add(new JLabel("Liquid " + (i + 1) + " (" + (i + 1) + " mol/dm3):"), lc);
                lc.gridx = 1;
                liquidFields[i] = new JTextField(15);
                leftPanel.add(liquidFields[i], lc);
            }   
            lc.gridy = 2;
            lc.gridx = 0;    
            lc.gridwidth = 2;
            lc.fill = GridBagConstraints.HORIZONTAL;
            lc.insets = new Insets(20, 5, 5, 5);
            JButton setLiquidButton = new JButton("Set Liquid mixture");
            setLiquidButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (validateLiquidInputs()) {
                        displaySelectedInfo();
                    }
                }
            });
            leftPanel.add(setLiquidButton, lc);
            lc.gridy = 3;
            JButton resetLiquidButton = new JButton("Reset Liquid mixture");
            resetLiquidButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JTextField field : liquidFields) {
                        field.setText("");
                    }
                    displaySelectedInfo();
                }
            });
            leftPanel.add(resetLiquidButton, lc);

            // Bottle Selection Section
            JPanel bottlePanel = new JPanel(new GridBagLayout());
            bottlePanel.setBorder(BorderFactory.createTitledBorder("Bottle Selection"));
            GridBagConstraints brc = new GridBagConstraints();
            brc.insets = new Insets(5, 5, 5, 5);
            brc.anchor = GridBagConstraints.EAST;
            brc.gridx = 0;
            brc.gridy = 0;
            bottlePanel.add(new JLabel("Bottle Quantity:"), brc);
            brc.gridy = 1;
            brc.anchor = GridBagConstraints.CENTER;
            bottleQuantityField = new JTextField(15);
            bottlePanel.add(bottleQuantityField, brc);

            brc.gridy = 2;
            brc.gridx = 0;
            brc.gridwidth = 2;
            brc.fill = GridBagConstraints.HORIZONTAL;
            brc.insets = new Insets(20, 5, 5, 5);
            JButton setBottleButton = new JButton("Set Bottles");
            setBottleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (validateBottleInput()) {
                        displaySelectedInfo();
                    }
                }
            });
            bottlePanel.add(setBottleButton, brc);
            brc.gridy = 3;
            JButton resetBottleButton = new JButton("Reset Bottles");
            resetBottleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bottleQuantityField.setText("");
                    displaySelectedInfo();
                }
            });
            bottlePanel.add(resetBottleButton, brc);

            // Submit Information Section
            JPanel submitPanel = new JPanel(new GridBagLayout());
            submitPanel.setBorder(BorderFactory.createTitledBorder("Submit Information"));
            GridBagConstraints sc = new GridBagConstraints();
            sc.insets = new Insets(5, 5, 5, 5);
            sc.gridx = 0;
            sc.gridy = 0;
            displayArea = new JTextArea(3, 20);
            displayArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(displayArea);
            submitPanel.add(scrollPane, sc);
            sc.gridy = 1;
//            sc.anchor = GridBagConstraints.CENTER;
            submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                if (BottleSend == null || LiquidAmount1 == null || LiquidAmount2 == null) {
                JOptionPane.showMessageDialog(mainFrame, "Error: SystemJ connection not established.");
                return;
                }
               
                // transmit verified input data
                try {
                // Skip systemEnable since it's set to null
                // if (systemEnable != null) systemEnable.emit("val", 1000);
                
                BottleSend.sustain(Integer.parseInt(bottleQuantityField.getText()));
                LiquidAmount1.sustain(Integer.parseInt(liquidFields[0].getText()));
                LiquidAmount2.sustain(Integer.parseInt(liquidFields[1].getText()));
                } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(mainFrame, "Invalid number format in inputs");
                e1.printStackTrace();
                } catch (IOException e1) { 
                JOptionPane.showMessageDialog(mainFrame, "Communication error with SystemJ");
                e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(mainFrame, "Successfully submitted");
                }
            });

           
           
            submitPanel.add(submitButton, sc);

            // Combining the bottle and submit sections
            JPanel combinedRightPanel = new JPanel(new BorderLayout());
            combinedRightPanel.add(bottlePanel, BorderLayout.NORTH);
            combinedRightPanel.add(submitPanel, BorderLayout.CENTER);

            // Main content panel with some padding
            JPanel contentPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            contentPanel.add(leftPanel);
            contentPanel.add(combinedRightPanel);

            mainFrame.add(contentPanel, BorderLayout.CENTER);

            // Remove logout functionality since there's no login
            mainFrame.setVisible(true);
    }

    private boolean validateLiquidInputs() {
        float total = 0;
        for (JTextField field : liquidFields) {
            String text = field.getText();
            try {
                float value = Float.parseFloat(text);
                if (value < 0) {
                    JOptionPane.showMessageDialog(mainFrame, "Inputs are invalid");
                    return false;
                }
                total += value;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(mainFrame, "Inputs are invalid");
                return false;
            }
        }

        if ((total > 100) || (total < 100)) {
            JOptionPane.showMessageDialog(mainFrame, "Liquid distribution should add up to 100");
            return false;
        }
       
        // check liquid information to be sent
        for (int i = 0; i < 2; i++) {
        System.out.println("Validated liquid: "+liquidFields[i].getText());
        }
        
        return true;
    }

    private boolean validateBottleInput() {
        String text = bottleQuantityField.getText();
        try {
            float value = Float.parseFloat(text);
            if (value < 0 || value > 10000) {
                JOptionPane.showMessageDialog(mainFrame, "Bottle quantity must not exceed 10000");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Inputs are invalid");
            return false;
        }
       
        // check bottle information to be sent
        System.out.println("Validated bottle: "+ text);
        return true;
    }

    private void displaySelectedInfo() {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            info.append("Liquid ").append(i + 1).append(": ").append(liquidFields[i].getText()).append("\n");
        }
        info.append("Bottle Quantity: ").append(bottleQuantityField.getText());
        displayArea.setText(info.toString());
    }

    public static void main(String[] args) {
        new POS();
    }
}
