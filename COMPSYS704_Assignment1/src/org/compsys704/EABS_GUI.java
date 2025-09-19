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
		
		// Make all windows visible
		this.filler.pack();
		this.filler.setVisible(true);
		
		this.capper.pack();
		this.capper.setVisible(true);
		
		this.bottleStation.pack();
		this.bottleStation.setVisible(true);
		
		this.conveyor.pack();
		this.conveyor.setVisible(true);
		
		// Start SignalServers for each component
		startSignalServers();
	}
	
	private void startSignalServers() {
		// Start SignalServer for Filler
		SignalServer<LoaderFillerWorker> fillerServer = new SignalServer<LoaderFillerWorker>(Ports.PORT_FILLER_VIZ, LoaderFillerWorker.class);
		System.out.println("Starting Filler SignalServer on port " + Ports.PORT_FILLER_VIZ);
		new Thread(fillerServer).start();
		
		// Start SignalServer for Capper
		SignalServer<LoaderCapperWorker> capperServer = new SignalServer<LoaderCapperWorker>(Ports.PORT_CAPPER_VIZ, LoaderCapperWorker.class);
		System.out.println("Starting Capper SignalServer on port " + Ports.PORT_CAPPER_VIZ);
		new Thread(capperServer).start();
		
		// Start SignalServer for BottleStation
		SignalServer<LoaderBSWorker> bottleStationServer = new SignalServer<LoaderBSWorker>(Ports.PORT_ROTARY_VIZ, LoaderBSWorker.class);
		System.out.println("Starting BottleStation SignalServer on port " + Ports.PORT_ROTARY_VIZ);
		new Thread(bottleStationServer).start();
		
		// Start SignalServer for Conveyor
		SignalServer<LoaderConveyorWorker> conveyorServer = new SignalServer<LoaderConveyorWorker>(Ports.PORT_CONVEYOR_VIZ, LoaderConveyorWorker.class);
		System.out.println("Starting Conveyor SignalServer on port " + Ports.PORT_CONVEYOR_VIZ);
		new Thread(conveyorServer).start();
		
		// Start repaint loop
		startRepaintLoop();
	}
	
	private void startRepaintLoop() {
		new Thread(() -> {
			while(true) {
				try {
					this.filler.repaint();
					this.capper.repaint();
					this.bottleStation.repaint();
					this.conveyor.repaint();
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		new EABS_GUI();
	}
	
	
	
	
	
}