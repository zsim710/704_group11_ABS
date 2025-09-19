package org.compsys704;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Test utility to simulate SystemJ sending completion signals to the POS system
 * Use this to test the order completion functionality
 */
public class OrderCompletionSignalSender {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Order Completion Signal Sender - Test Utility");
        System.out.println("This simulates SystemJ sending completion signals to POS");
        
        // Wait a bit for user to start POS system
        System.out.println("Make sure POS system is running, then press Enter to send completion signal...");
        System.in.read();
        
        // Send order completion signal
        sendCompletionSignal("MainControllerCD.OrderComplete", true);
        
        Thread.sleep(2000);
        
        // Send another completion signal
        sendCompletionSignal("MainControllerCD.OrderComplete", true);
        
        Thread.sleep(2000);
        
        // Send batch finished signal
        sendCompletionSignal("MainControllerCD.BatchFinished", true);
        
        System.out.println("Test signals sent!");
    }
    
    /**
     * Sends a completion signal to the POS system
     * @param signalName The signal name (should match those in OrderCompletionWorker)
     * @param value The signal value (typically true for completion)
     */
    public static void sendCompletionSignal(String signalName, boolean value) {
        try {
            Socket s = new Socket("127.0.0.1", Ports.PORT_ORDER_COMPLETION);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(signalName);
            oos.writeObject(new Object[]{value}); // Send as Object array to match Worker expectation
            oos.flush();
            oos.close();
            s.close();
            System.out.println("Sent completion signal: " + signalName + " = " + value);
        } catch (Exception e) {
            System.err.println("Error sending completion signal: " + e.getMessage());
            e.printStackTrace();
        }
    }
}