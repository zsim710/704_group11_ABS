//package org.compsys704;
//
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//
//
//
//
//public static void Test_signal_Sender(String signalName, boolean value) {
//        try {
//            Socket s = new Socket("127.0.0.1", Ports.PORT_BOTTLELOADER_VIZ);
//            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
//            oos.writeObject(signalName);
//            oos.writeObject(value);
//            oos.flush();
//            oos.close();
//            s.close();
//            System.out.println("Sent signal: " + signalName + " = " + value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//}
