package org.compsys704;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EABS_GUI extends JFrame {
	private JPanel panel;
	private Filler filler;
	private Capper capper;
	private BottleStation bottleStation;
	private Conveyor conveyor;
	
	public EABS_GUI() {
		// Create instances of all components
		this.filler = new Filler();
		this.capper = new Capper();
		this.bottleStation = new BottleStation();
		this.conveyor = new Conveyor();
	}

	public static void main(String[] args) {
		new EABS_GUI();
	}
	
	
	
	
	
}