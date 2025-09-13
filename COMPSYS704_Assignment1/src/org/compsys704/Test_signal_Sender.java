package org.compsys704;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Test_signal_Sender {
    public static void main(String[] args) throws Exception {
        sendSignal("UI.POSB", true);
        Thread.sleep(2000);
        sendSignal("UI.POSC", true);
        Thread.sleep(2000);
        sendSignal("UI.POSD", true);
        Thread.sleep(2000);
        sendSignal("UI.POSA", true);
    }
    
    public static void sendSignal(String signalName, boolean value) {
        try {
            Socket s = new Socket("127.0.0.1", Ports.PORT_BOTTLELOADER_VIZ);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(signalName);
            oos.writeObject(value);
            oos.flush();
            oos.close();
            s.close();
            System.out.println("Sent signal: " + signalName + " = " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}