package org.compsys704;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents the details of an order submitted through the POS system
 */
public class OrderDetails implements Serializable {
    private static int orderCounter = 1; // Static counter for order IDs
    
    private int liquidAmount1;
    private int liquidAmount2;
    private int bottleQuantity;
    private Date orderTimestamp;
    private String orderId;
    
    // Digital twin - list of workpieces for this order
    private List<Workpiece> workpieces;
    
    /**
     * Constructor to create an OrderDetails instance
     * @param liquidAmount1 Amount of liquid 1
     * @param liquidAmount2 Amount of liquid 2
     * @param bottleQuantity Number of bottles requested
     */
    public OrderDetails(int liquidAmount1, int liquidAmount2, int bottleQuantity) {
        this.liquidAmount1 = liquidAmount1;
        this.liquidAmount2 = liquidAmount2;
        this.bottleQuantity = bottleQuantity;
        this.orderTimestamp = new Date();
        this.orderId = "ORDER_" + orderCounter++;
        
        // Create workpieces for this order (digital twins)
        this.workpieces = new ArrayList<>();
        createWorkpieces();
    }
    
    /**
     * Create individual workpiece instances for each bottle in this order
     */
    private void createWorkpieces() {
        for (int i = 1; i <= bottleQuantity; i++) {
            Workpiece workpiece = new Workpiece(this, i);
            workpieces.add(workpiece);
            System.out.println("Created " + workpiece.getWorkpieceId() + " for " + orderId);
        }
    }
    
    // Getters
    public int getLiquidAmount1() {
        return liquidAmount1;
    }
    
    public int getLiquidAmount2() {
        return liquidAmount2;
    }
    
    public int getBottleQuantity() {
        return bottleQuantity;
    }
    
    public Date getOrderTimestamp() {
        return orderTimestamp;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public List<Workpiece> getWorkpieces() {
        return workpieces;
    }
    
    public int getWorkpieceCount() {
        return workpieces != null ? workpieces.size() : 0;
    }
    
    // Setters
    public void setLiquidAmount1(int liquidAmount1) {
        this.liquidAmount1 = liquidAmount1;
    }
    
    public void setLiquidAmount2(int liquidAmount2) {
        this.liquidAmount2 = liquidAmount2;
    }
    
    public void setBottleQuantity(int bottleQuantity) {
        this.bottleQuantity = bottleQuantity;
    }
    
    /**
     * Returns a string representation of the order details
     */
    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId='" + orderId + '\'' +
                ", liquidAmount1=" + liquidAmount1 +
                ", liquidAmount2=" + liquidAmount2 +
                ", bottleQuantity=" + bottleQuantity +
                ", orderTimestamp=" + orderTimestamp +
                '}';
    }
    
    /**
     * Validates if the order has valid liquid distribution (should add up to 100)
     * @return true if valid, false otherwise
     */
    public boolean isValidLiquidDistribution() {
        return (liquidAmount1 + liquidAmount2) == 100;
    }
    
    /**
     * Checks if the order is valid (positive values and valid liquid distribution)
     * @return true if valid, false otherwise
     */
    public boolean isValid() {
        return liquidAmount1 >= 0 && liquidAmount2 >= 0 && 
               bottleQuantity > 0 && bottleQuantity <= 10000 &&
               isValidLiquidDistribution();
    }
    
    /**
     * Reset order counter (call from POS when clearing batches)
     */
    public static void resetOrderCounter() {
        orderCounter = 1;
    }
}