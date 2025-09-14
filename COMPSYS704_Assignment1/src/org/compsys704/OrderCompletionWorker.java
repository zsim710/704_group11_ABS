package org.compsys704;

import java.util.Arrays;
import java.util.List;

/**
 * Worker class to handle completion signals from SystemJ for order processing
 */
public class OrderCompletionWorker extends Worker {
    
    // Reference to POS instance to notify of completion
    private static POS posInstance = null;
    
    public static void setPOSInstance(POS pos) {
        posInstance = pos;
    }

    @Override
    public void setSignal(boolean status) {
        System.out.println("OrderCompletionWorker received signal: " + signame + " = " + status);
        
        switch(signame) {
            case "OrderComplete":
                if (status && posInstance != null) {
                    // Notify POS system that current order is complete
                    posInstance.onOrderCompleted();
                }
                break;
            case "BatchFinished":
                if (status && posInstance != null) {
                    // Notify POS system that entire batch is finished
                    posInstance.onBatchFinished();
                }
                break;
            default:
                System.err.println("Unknown signal name in OrderCompletionWorker: " + signame);
        }
    }

    // Define which signals this worker can handle
    static final List<String> signames = Arrays.asList("OrderComplete", "BatchFinished");

    @Override
    public boolean hasSignal(String sn) {
        return signames.contains(sn);
    }
}