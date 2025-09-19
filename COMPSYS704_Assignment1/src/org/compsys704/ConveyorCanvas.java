package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ConveyorCanvas extends JPanel {
	// upload to res folder and delete comment
	BufferedImage conveyorOn;
	BufferedImage conveyorOff;
	BufferedImage conveyorBottleAtPos1;
	BufferedImage conveyorBottleLeftPos5;

	public ConveyorCanvas(){
		try {
			conveyorOn = ImageIO.read(new File("res/conveyorOn.png"));
//			conveyorOn = bi.getSubimage(0, 101, 387, 100);
			
			conveyorOff = ImageIO.read(new File("res/conveyorOff.png"));
//			conveyorOff = bi2.getSubimage(0, 0, 387, 100); // og image
			
			conveyorBottleAtPos1 = ImageIO.read(new File("res/conveyorBottleAtPos1.png"));
//			conveyorBottleAtPos1 = bi3.getSubimage(0,  0, 387, 100);

			conveyorBottleLeftPos5 = ImageIO.read(new File("res/conveyorBottleComplete.png"));
//			conveyorBottleLeftPos5 = bi4.getSubimage(0,  0, 387, 100);
			 
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;  
		}
	}

	    
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int x = 0;
		int y = 0;
		
		int w=387;
		int h=100;
		
		g.drawImage(conveyorOff, 0, 0, null); //default conveyor off for start
		g.drawImage(conveyorOff, 0, 110, null); //default conveyor off for end


	    // conveyor 
		if(States.BOTTLE_AT_LOAD) {	
			g.clearRect(0, 0, w, h);
			g.drawImage(conveyorOn, x, y, null);
	    }
		else if (States.BOTTLE_AT_POS_1) {
			g.clearRect(0, 0, w, h);
			g.drawImage(conveyorBottleAtPos1, x, y, null);
		
		}
		else if (States.BOTTLE_LEFT_POS_5) { // done
			g.clearRect(0, 110, w, h);
			g.drawImage(conveyorBottleLeftPos5, x, 110, null);
	
		}

	}
	
} 
		
