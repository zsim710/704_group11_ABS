package org.compsys704;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents a single workpiece/bottle within an order - Digital Twin implementation
 * Each workpiece tracks its own state and manufacturing data
 */
public class Workpiece implements Serializable {
    private static int workpieceCounter = 1; // Static counter for unique IDs
    
    // Unique identification
    private String workpieceId;
    private String parentOrderId;
    private int sequenceInOrder; // Position within the order (1, 2, 3, etc.)
    
    // Recipe data from parent order
    private int liquidAmount1;
    private int liquidAmount2;
    
    // Manufacturing tracking
    private Date creationTimestamp;
    private Date startProcessingTimestamp;
    private Date completionTimestamp;
    private WorkpieceStatus status;
    
    // Fault detection flags (initially all false/low)
    private boolean liquidMixingFault;
    private boolean capFault;
    private boolean sealingFault;
    private boolean qualityControlFault;
    private boolean transportFault;
    
    // Manufacturing process tracking
    private boolean liquidMixed;
    private boolean capped;
    private boolean sealed;
    private boolean qualityChecked;
    
    /**
     * Constructor to create a workpiece instance
     * @param parentOrder The order this workpiece belongs to
     * @param sequenceInOrder Position of this workpiece in the order (1-based)
     */
    public Workpiece(OrderDetails parentOrder, int sequenceInOrder) {
        this.workpieceId = "WP_" + workpieceCounter++;
        this.parentOrderId = parentOrder.getOrderId();
        this.sequenceInOrder = sequenceInOrder;
        
        // Copy recipe data from parent order
        this.liquidAmount1 = parentOrder.getLiquidAmount1();
        this.liquidAmount2 = parentOrder.getLiquidAmount2();
        
        // Initialize timestamps
        this.creationTimestamp = new Date();
        this.startProcessingTimestamp = null;
        this.completionTimestamp = null;
        
        // Initial status
        this.status = WorkpieceStatus.CREATED;
        
        // Initialize all fault flags as false (low)
        this.liquidMixingFault = false;
        this.capFault = false;
        this.sealingFault = false;
        this.qualityControlFault = false;
        this.transportFault = false;
        
        // Initialize process tracking flags
        this.liquidMixed = false;
        this.capped = false;
        this.sealed = false;
        this.qualityChecked = false;
    }
    
    // Getters
    public String getWorkpieceId() {
        return workpieceId;
    }
    
    public String getParentOrderId() {
        return parentOrderId;
    }
    
    public int getSequenceInOrder() {
        return sequenceInOrder;
    }
    
    public int getLiquidAmount1() {
        return liquidAmount1;
    }
    
    public int getLiquidAmount2() {
        return liquidAmount2;
    }
    
    public Date getCreationTimestamp() {
        return creationTimestamp;
    }
    
    public Date getStartProcessingTimestamp() {
        return startProcessingTimestamp;
    }
    
    public Date getCompletionTimestamp() {
        return completionTimestamp;
    }
    
    public WorkpieceStatus getStatus() {
        return status;
    }
    
    // Fault getters
    public boolean isLiquidMixingFault() {
        return liquidMixingFault;
    }
    
    public boolean isCapFault() {
        return capFault;
    }
    
    public boolean isSealingFault() {
        return sealingFault;
    }
    
    public boolean isQualityControlFault() {
        return qualityControlFault;
    }
    
    public boolean isTransportFault() {
        return transportFault;
    }
    
    // Process tracking getters
    public boolean isLiquidMixed() {
        return liquidMixed;
    }
    
    public boolean isCapped() {
        return capped;
    }
    
    public boolean isSealed() {
        return sealed;
    }
    
    public boolean isQualityChecked() {
        return qualityChecked;
    }
    
    // Status update methods
    public void startProcessing() {
        this.startProcessingTimestamp = new Date();
        this.status = WorkpieceStatus.PROCESSING;
    }
    
    public void completeProcessing() {
        this.completionTimestamp = new Date();
        this.status = WorkpieceStatus.COMPLETED;
    }
    
    public void setFaulted() {
        this.status = WorkpieceStatus.FAULTED;
    }
    
    public void setStatus(WorkpieceStatus status) {
        this.status = status;
    }
    
    // Process step setters
    public void setLiquidMixed(boolean liquidMixed) {
        this.liquidMixed = liquidMixed;
    }
    
    public void setCapped(boolean capped) {
        this.capped = capped;
    }
    
    public void setSealed(boolean sealed) {
        this.sealed = sealed;
    }
    
    public void setQualityChecked(boolean qualityChecked) {
        this.qualityChecked = qualityChecked;
    }
    
    // Fault setters
    public void setLiquidMixingFault(boolean liquidMixingFault) {
        this.liquidMixingFault = liquidMixingFault;
        if (liquidMixingFault) setFaulted();
    }
    
    public void setCapFault(boolean capFault) {
        this.capFault = capFault;
        if (capFault) setFaulted();
    }
    
    public void setSealingFault(boolean sealingFault) {
        this.sealingFault = sealingFault;
        if (sealingFault) setFaulted();
    }
    
    public void setQualityControlFault(boolean qualityControlFault) {
        this.qualityControlFault = qualityControlFault;
        if (qualityControlFault) setFaulted();
    }
    
    public void setTransportFault(boolean transportFault) {
        this.transportFault = transportFault;
        if (transportFault) setFaulted();
    }
    
    /**
     * Check if workpiece has any faults
     * @return true if any fault is detected
     */
    public boolean hasFaults() {
        return liquidMixingFault || capFault || sealingFault || 
               qualityControlFault || transportFault;
    }
    
    /**
     * Get completion percentage based on process steps
     * @return percentage complete (0-100)
     */
    public int getCompletionPercentage() {
        int stepsCompleted = 0;
        int totalSteps = 4; // liquidMixed, capped, sealed, qualityChecked
        
        if (liquidMixed) stepsCompleted++;
        if (capped) stepsCompleted++;
        if (sealed) stepsCompleted++;
        if (qualityChecked) stepsCompleted++;
        
        return (stepsCompleted * 100) / totalSteps;
    }
    
    /**
     * Reset workpiece counter (call when clearing batches)
     */
    public static void resetWorkpieceCounter() {
        workpieceCounter = 1;
    }
    
    /**
     * Update workpiece status when it reaches a specific position in the manufacturing line
     * @param position The position (1-5) that the workpiece has reached
     */
    public void updatePositionReached(int position) {
        switch (position) {
            case 1:
                // Position 1: Start processing (liquid mixing station)
                if (status == WorkpieceStatus.CREATED) {
                    startProcessing();
                }
                setLiquidMixed(true);
                System.out.println(workpieceId + " reached position 1 - liquid mixing");
                break;
                
            case 2:
                // Position 2: Capping station
                setCapped(true);
                System.out.println(workpieceId + " reached position 2 - capping");
                break;
                
            case 3:
                // Position 3: Sealing station
                setSealed(true);
                System.out.println(workpieceId + " reached position 3 - sealing");
                break;
                
            case 4:
                // Position 4: Quality control station
                setQualityChecked(true);
                System.out.println(workpieceId + " reached position 4 - quality control");
                break;
                
            case 5:
                // Position 5: Final completion
                completeProcessing();
                System.out.println(workpieceId + " reached position 5 - completed");
                break;
                
            default:
                System.err.println("Invalid position: " + position + " for workpiece " + workpieceId);
        }
    }
    
    @Override
    public String toString() {
        return "Workpiece{" +
                "workpieceId='" + workpieceId + '\'' +
                ", parentOrderId='" + parentOrderId + '\'' +
                ", sequenceInOrder=" + sequenceInOrder +
                ", status=" + status +
                ", liquidAmount1=" + liquidAmount1 +
                ", liquidAmount2=" + liquidAmount2 +
                ", faults=" + hasFaults() +
                ", completion=" + getCompletionPercentage() + "%" +
                '}';
    }
}