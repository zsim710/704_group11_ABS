package org.compsys704;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BottleStation extends JFrame {
	private JPanel panel;
	
	public BottleStation() {
		setLayout(new BorderLayout());
//		this.setPreferredSize(new Dimension(200, 300));
 
		panel = new RotaryCanvas(); // canvas creates the image panel
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setBackground(Color.WHITE);
        add(panel, BorderLayout.CENTER);
		
//		this.setLayout(new GridBagLayout());
//		GridBagConstraints c = new GridBagConstraints();
//		c.gridx = 0;
//		c.gridy = 0;
//		this.add(panel,c);
		 
//		JPanel pan = new JPanel(new GridLayout(1, 0));
//		pan.setBackground(Color.magenta);
		
		// for tests
//		JCheckBox pe = new JCheckBox("smth");
//		pe.setEnabled(false);
//		pe.addItemListener(new SignalCheckBoxClient(Ports.PORT_LOADER_CONTROLLER, Ports.SIGNAL_PUSHER_EXTEND)); // todo
//		pan.add(pe);
		
//		c.gridx = 0;
//		c.gridy = 2;
//		pan.setBorder(BorderFactory.createTitledBorder("Mode selector"));

		JPanel buttonPanel = new JPanel(new FlowLayout());
		
        JButton fault = new JButton("Cap on Bottle at Pos1");
        fault.addActionListener(new SignalClient(Ports.PORT_ROTARY_CONTROLLER, Ports.SIMULATE_FAULT));

		// TODO send to main controller to enable/disable whole system, change ports
        JButton enable = new JButton("Enable");
        enable.addActionListener(new SignalClient(Ports.PORT_ROTARY_CONTROLLER, Ports.ROTARY_ENABLE));

        buttonPanel.add(fault);
		buttonPanel.add(enable);
        add(buttonPanel, BorderLayout.SOUTH); 

      
//		JPanel pan3 = new JPanel(new GridLayout(0, 2));
//		pan3.add(pan);
//		pan3.add(pan2);
//		c.gridx = 0;
//		c.gridy = 2; 
//		this.add(pan3,c);
		
		this.setTitle("Rotary Table");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

	}

	public static void main(String[] args) {
		BottleStation cl = new BottleStation();
		cl.pack();
		cl.setVisible(true);
		
		SignalServer<LoaderBSWorker> server = new SignalServer<LoaderBSWorker>(Ports.PORT_ROTARY_VIZ, LoaderBSWorker.class);
		System.out.println("Starting SignalServer on port " + Ports.PORT_ROTARY_VIZ);
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