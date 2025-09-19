package org.compsys704;

import java.util.Arrays;
import java.util.List;

/**
 * Worker class to handle completion signals from SystemJ for order processing
 */
public class OrderCompletionWorker extends Worker {
    
    // Reference to POS instance to notify of completion
    private static POS posInstance = null;
    
    // Track which workpiece is currently at each position
    private static int workpieceAtPos1 = 0; // Index of workpiece currently at position 1
    private static int workpieceAtPos2 = 0; // Index of workpiece currently at position 2
    private static int workpieceAtPos3 = 0; // Index of workpiece currently at position 3
    private static int workpieceAtPos4 = 0; // Index of workpiece currently at position 4
    private static int workpieceAtPos5 = 0; // Index of workpiece currently at position 5
    
    public static void setPOSInstance(POS pos) {
        posInstance = pos;
    }
    
    public static void resetWorkpieceIndex() {
        workpieceAtPos1 = 0;
        workpieceAtPos2 = 0;
        workpieceAtPos3 = 0;
        workpieceAtPos4 = 0;
        workpieceAtPos5 = 0;
    }

    @Override
    public void setSignal(boolean status) {
        //System.out.println("OrderCompletionWorker received signal: " + signame + " = " + status);
        
        if (status && posInstance != null) {
            switch(signame) {
                case "pos1":
                    updateWorkpieceAtPosition(1);
                    break;
                case "pos2":
                    updateWorkpieceAtPosition(2);
                    break;
                case "pos3":
                    updateWorkpieceAtPosition(3);
                    break;
                case "pos4":
                    updateWorkpieceAtPosition(4);
                    break;
                case "pos5":
                    updateWorkpieceAtPosition(5);
                    break;
                case "BatchFinished":
                    // Notify POS system that entire batch is finished
                    posInstance.onBatchFinished();
                    resetWorkpieceIndex(); // Reset for next batch
                    break;
                default:
                    System.err.println("Unknown signal name in OrderCompletionWorker: " + signame);
            }
        }
    }
    
    /**
     * Updates the workpiece status when it reaches a specific position
     * @param position The position (1-5) that the workpiece has reached
     */
    private void updateWorkpieceAtPosition(int position) {
        OrderDetails currentOrder = posInstance.getCurrentProcessingOrder();
        if (currentOrder == null) {
            System.err.println("No current order being processed");
            return;
        }
        
        int workpieceIndexToUpdate = -1;
        
        // Determine which workpiece to update based on the position
        switch (position) {
            case 1:
                // New workpiece arriving at position 1
                workpieceAtPos1++;
                workpieceIndexToUpdate = workpieceAtPos1 - 1; // Convert to 0-based index
                break;
            case 2:
                // Workpiece moving from pos1 to pos2
                workpieceAtPos2++;
                workpieceIndexToUpdate = workpieceAtPos2 - 1;
                break;
            case 3:
                // Workpiece moving from pos2 to pos3
                workpieceAtPos3++;
                workpieceIndexToUpdate = workpieceAtPos3 - 1;
                break;
            case 4:
                // Workpiece moving from pos3 to pos4
                workpieceAtPos4++;
                workpieceIndexToUpdate = workpieceAtPos4 - 1;
                break;
            case 5:
                // Workpiece moving from pos4 to pos5 (completion)
                workpieceAtPos5++;
                workpieceIndexToUpdate = workpieceAtPos5 - 1;
                break;
            default:
                System.err.println("Invalid position: " + position);
                return;
        }
        
        if (workpieceIndexToUpdate < 0 || workpieceIndexToUpdate >= currentOrder.getWorkpieceCount()) {
            System.err.println("Workpiece index out of bounds: " + workpieceIndexToUpdate + 
                             " for order with " + currentOrder.getWorkpieceCount() + " workpieces");
            return;
        }
        
        Workpiece workpiece = currentOrder.getWorkpieces().get(workpieceIndexToUpdate);
        workpiece.updatePositionReached(position);
        
        System.out.println("Updated " + workpiece.getWorkpieceId() + " - reached position " + position + 
                          " (" + workpiece.getStatus() + ")");
    }

    // Define which signals this worker can handle
    static final List<String> signames = Arrays.asList("pos1", "pos2", "pos3", "pos4", "pos5", "BatchFinished");

    @Override
    public boolean hasSignal(String sn) {
        return signames.contains(sn);
    }
}