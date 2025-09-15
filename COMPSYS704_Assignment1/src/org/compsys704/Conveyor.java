package org.compsys704;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

public class Conveyor extends JFrame {
	private JPanel panel;
	
	public Conveyor() {

		panel = new ConveyorCanvas(); // canvas creates the image panel
		panel.setPreferredSize(new Dimension(700, 700));
		panel.setBackground(Color.WHITE);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(panel,c);
		
		JPanel pan = new JPanel(new GridLayout(1, 0));
		pan.setBackground(Color.magenta);
		
		// stop button
		JButton button1 = new JButton("Resume");
		JButton button2 = new JButton("Stop");
//		button2.addActionListener(new SignalClient(Ports.PORT_Conveyor_PLANT, Ports.Conveyor_motConveyorOnOff));

		
		pan.add(button1);
		pan.add(button2);
		
		c.gridx = 0;
		c.gridy = 2;
		pan.setBorder(BorderFactory.createTitledBorder("Conveyor Stop and Resume"));

		JPanel pan2 = new JPanel(new GridLayout(2, 2));
		pan2.setBackground(Color.black);

		JPanel pan3 = new JPanel(new GridLayout(0, 2));
		pan3.add(pan);
		pan3.add(pan2);
		c.gridx = 0;
		c.gridy = 2; 
		this.add(pan3,c);
		
		this.setTitle("Conveyor");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

	}

	public static void main(String[] args) {
		Conveyor cl = new Conveyor();
		cl.pack();
		cl.setVisible(true);
		
		SignalServer<LoaderConveyorWorker> server = new SignalServer<LoaderConveyorWorker>(Ports.PORT_CONVEYOR_VIZ, LoaderConveyorWorker.class);
		System.out.println("Starting SignalServer on port " + Ports.PORT_CONVEYOR_VIZ);
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
