package org.compsys704;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.compsys704.LoaderCapperWorker;
import org.compsys704.Ports;

public class Capper extends JFrame {
	private JPanel panel;

    public Capper() {
        setLayout(new BorderLayout()); // what is this

        // Canvas for drawing images
        panel = new CapperCanvas();
        panel.setPreferredSize(new Dimension(400, 400));
		panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);

        // Control buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnBottleAtPos4 = new JButton("Bottle at Pos 4");
        btnBottleAtPos4.addActionListener(new SignalClient(Ports.PORT_CAPPER_CONTROLLER, Ports.CAPPER_BOTTLE_PRESENT));
        
        // JButton btnEnable = new JButton("Enable");
        // btnEnable.addActionListener(new SignalClient(Ports.PORT_CAPPER_CONTROLLER, Ports.ROTARY_ENABLE));

        // JButton btnFault = new JButton("Fault"); 

        buttonPanel.add(btnBottleAtPos4);
        // buttonPanel.add(btnEnable);
        // buttonPanel.add(btnFault);
 
        add(buttonPanel, BorderLayout.SOUTH); 

        // Event listeners
//        btnBottleAtPos3.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setState(States.BOTTLE_AT_POS3);
//            }
//        });
//
//        btnEnable.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (currentState == States.BOTTLE_AT_POS3) {
//                    setState(States.CAPPER_GRIPPER_CLAMP);
//                }
//            }
//        });
//
//        btnFault.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setState(States.FAULT);
//            }
//        }); 

        this.setTitle("Capper");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

    }

    public static void main(String[] args) {
        Capper cl = new Capper();
		cl.pack();
		cl.setVisible(true);
		
		SignalServer<LoaderCapperWorker> server = new SignalServer<LoaderCapperWorker>(Ports.PORT_CAPPER_VIZ, LoaderCapperWorker.class);
		System.out.println("Starting SignalServer on port " + Ports.PORT_CAPPER_VIZ);
		new Thread(server).start();
		while(true){
			try {
				cl.repaint();
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }
}
