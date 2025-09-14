package org.compsys704;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    // Order history storage
    private List<OrderDetails> orderHistory = new ArrayList<>();
    private List<OrderDetails> orderQueue = new ArrayList<>();
    private boolean isProcessingOrder = false;
    private int currentOrderIndex = 0;

    // Main Window Components
    JFrame mainFrame;
    JTabbedPane tabbedPane;
    JTextField[] liquidFields = new JTextField[2];
    JTextField bottleQuantityField;
    JTextArea displayArea;
    JButton submitButton;
    
    // Batch Details Components
    JTable batchTable;
    DefaultTableModel tableModel;
    
    // Signal server for receiving completion signals from SystemJ
    private SignalServer<OrderCompletionWorker> completionSignalServer;

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
 
        // Setup completion signal server to listen for SystemJ completion signals
        try {
            completionSignalServer = new SignalServer<OrderCompletionWorker>(Ports.PORT_ORDER_COMPLETION, OrderCompletionWorker.class);
            OrderCompletionWorker.setPOSInstance(this); // Set reference for callbacks
            new Thread(completionSignalServer).start();
            System.out.println("Order completion signal server started on port " + Ports.PORT_ORDER_COMPLETION);
        } catch (Exception e) {
            System.err.println("Failed to start completion signal server: " + e.getMessage());
            e.printStackTrace();
        }
 
        // Setup Main Window directly
        openMainWindow();
    }

    private void openMainWindow() {
        mainFrame = new JFrame("[group 11] Personal Order System");
        mainFrame.setSize(600, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        
        // Create and add the Order Entry tab
        JPanel orderEntryPanel = createOrderEntryPanel();
        tabbedPane.addTab("Order Entry", orderEntryPanel);
        
        // Create and add the Batch Details tab
        JPanel batchDetailsPanel = createBatchDetailsPanel();
        tabbedPane.addTab("Batch Details", batchDetailsPanel);
        
        mainFrame.add(tabbedPane, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    private JPanel createOrderEntryPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

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
        submitButton = new JButton("Submit Order");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitOrder();
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

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        return mainPanel;
    }

    private JPanel createBatchDetailsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        JLabel titleLabel = new JLabel("Batch Details - Order History", SwingConstants.CENTER);
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Create table for displaying orders
        String[] columnNames = {"Order ID", "Liquid 1", "Liquid 2", "Bottles", "Timestamp", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        batchTable = new JTable(tableModel);
        batchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Set column widths
        batchTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        batchTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        batchTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        batchTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        batchTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        batchTable.getColumnModel().getColumn(5).setPreferredWidth(100);

        JScrollPane tableScrollPane = new JScrollPane(batchTable);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        // Summary and control panel
        JPanel summaryPanel = new JPanel(new FlowLayout());
        JLabel summaryLabel = new JLabel("Total Orders: 0");
        summaryLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        
        JButton clearBatchesButton = new JButton("Clear Batches");
        clearBatchesButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        clearBatchesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllBatches();
            }
        });
        
        summaryPanel.add(summaryLabel);
        summaryPanel.add(Box.createHorizontalStrut(20)); // Add some spacing
        summaryPanel.add(clearBatchesButton);
        panel.add(summaryPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void submitOrder() {
        if (BottleSend == null || LiquidAmount1 == null || LiquidAmount2 == null) {
            JOptionPane.showMessageDialog(mainFrame, "Error: SystemJ connection not established.");
            return;
        }
       
        // Create OrderDetails instance with current form data
        try {
            int liquidAmt1 = Integer.parseInt(liquidFields[0].getText());
            int liquidAmt2 = Integer.parseInt(liquidFields[1].getText());
            int bottleQty = Integer.parseInt(bottleQuantityField.getText());
            
            OrderDetails order = new OrderDetails(liquidAmt1, liquidAmt2, bottleQty);
            
            // Validate the order
            if (!order.isValid()) {
                JOptionPane.showMessageDialog(mainFrame, "Invalid order details. Please check your inputs.");
                return;
            }
            
            // Add order to history and queue
            orderHistory.add(order);
            orderQueue.add(order);
            
            System.out.println("Order queued: " + order.toString());
            
            // Update batch details table
            updateBatchDetailsTable();
            
            // Start processing if not already processing
            if (!isProcessingOrder) {
                processNextOrder();
            }
            
            JOptionPane.showMessageDialog(mainFrame, "Order " + order.getOrderId() + " queued successfully! Position in queue: " + orderQueue.size());
            
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid number format in inputs");
            e1.printStackTrace();
        }
    }

    private void updateBatchDetailsTable() {
        // Clear existing rows
        tableModel.setRowCount(0);
        
        // Add all orders to the table with status information
        for (int i = 0; i < orderHistory.size(); i++) {
            OrderDetails order = orderHistory.get(i);
            String status;
            
            // Determine order status
            if (orderQueue.contains(order)) {
                if (orderQueue.indexOf(order) == 0 && isProcessingOrder) {
                    status = "Processing";
                } else {
                    status = "Queued (" + (orderQueue.indexOf(order) + 1) + ")";
                }
            } else {
                status = "Completed";
            }
            
            Object[] rowData = {
                order.getOrderId(),
                order.getLiquidAmount1(),
                order.getLiquidAmount2(),
                order.getBottleQuantity(),
                order.getOrderTimestamp(),
                status
            };
            tableModel.addRow(rowData);
        }
        
        // Update summary
        JPanel batchPanel = (JPanel) tabbedPane.getComponentAt(1);
        JPanel summaryPanel = (JPanel) batchPanel.getComponent(2);
        JLabel summaryLabel = (JLabel) summaryPanel.getComponent(0);
        summaryLabel.setText("Total Orders: " + orderHistory.size() + " | Queued: " + orderQueue.size() + 
                            " | Processing: " + (isProcessingOrder ? "Yes" : "No"));
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

    private void processNextOrder() {
        if (orderQueue.isEmpty() || isProcessingOrder) {
            return;
        }
        
        isProcessingOrder = true;
        OrderDetails currentOrder = orderQueue.get(0);
        
        System.out.println("Processing order: " + currentOrder.toString());
        
        try {
            // Send current order to SystemJ
            BottleSend.sustain(currentOrder.getBottleQuantity());
            LiquidAmount1.sustain(currentOrder.getLiquidAmount1());
            LiquidAmount2.sustain(currentOrder.getLiquidAmount2());
            
            System.out.println("Order sent to SystemJ: " + currentOrder.getOrderId());
            
            // Remove processed order from queue (it's now being processed)
            orderQueue.remove(0);
            
            // Update the batch details display to show processing status
            updateBatchDetailsTable();
            
            // Note: Order completion will be handled by onOrderCompleted() callback
            // when SystemJ sends the completion signal
            
        } catch (IOException e) {
            System.err.println("Error sending order to SystemJ: " + e.getMessage());
            isProcessingOrder = false;
            
            // Put the order back in the queue on error
            orderQueue.add(0, currentOrder);
            
            JOptionPane.showMessageDialog(mainFrame, "Error processing order " + currentOrder.getOrderId() + ": " + e.getMessage());
        }
    }
    
    private void clearAllBatches() {
        int result = JOptionPane.showConfirmDialog(
            mainFrame,
            "Are you sure you want to clear all batches?\nThis will stop any ongoing processing and clear all order history.",
            "Clear All Batches",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (result == JOptionPane.YES_OPTION) {
            // Clear all orders and reset state
            orderHistory.clear();
            orderQueue.clear();
            isProcessingOrder = false;
            currentOrderIndex = 0;
            
            // Update the display
            updateBatchDetailsTable();
            
            System.out.println("All batches cleared");
            JOptionPane.showMessageDialog(mainFrame, "All batches have been cleared successfully.");
        }
    }
    
    /**
     * Called by OrderCompletionWorker when SystemJ sends order completion signal
     */
    public void onOrderCompleted() {
        System.out.println("Order completion signal received from SystemJ");
        
        // Reset processing flag
        isProcessingOrder = false;
        
        // Update the batch details display
        updateBatchDetailsTable();
        
        // Process next order if any are queued
        if (!orderQueue.isEmpty()) {
            processNextOrder();
        } else {
            System.out.println("No more orders in queue");
        }
    }
    
    /**
     * Called by OrderCompletionWorker when SystemJ sends batch finished signal
     */
    public void onBatchFinished() {
        System.out.println("Batch finished signal received from SystemJ");
        
        // Reset processing flag
        isProcessingOrder = false;
        
        // Update the batch details display
        updateBatchDetailsTable();
        
        // Optionally show notification to user
        JOptionPane.showMessageDialog(mainFrame, "Batch processing completed successfully!");
    }

    public static void main(String[] args) {
        new POS();
    }
}
