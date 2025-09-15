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
			BufferedImage conveyorOn = ImageIO.read(new File("res/conveyorOn.png"));

			BufferedImage conveyorOff = ImageIO.read(new File("res/conveyorOff.png"));
//			conveyorOff = conveyorOff.getSubimage(0, 0, 378, 100); // og image

			BufferedImage conveyorBottleAtPos1 = ImageIO.read(new File("res/conveyorBottleAtPos1.png"));

			BufferedImage conveyorBottleLeftPos5 = ImageIO.read(new File("res/conveyorBottleComplete.png"));

//			BufferedImage RT = ImageIO.read(new File("res/RT3.0.png"));
//			RotaryTable = RT.getSubimage(0, 0, 387, 100);

			 
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;  
		}
	}

	    
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		int x = 500;
		int y = 100;
		
		int x1 = 50;
		int y1 = 15;
		
		g.drawImage(conveyorOff, 378, 100, null);


    // conveyor 
	if(States.BOTTLE_AT_LOAD) {	
		g.clearRect(0, 0, x, y);
		g.drawImage(conveyorOn, x1, y1, null);
    }
	else if (States.BOTTLE_AT_POS_1) {
		g.clearRect(0, 0, x, y);
		g.drawImage(conveyorBottleAtPos1, x1, y1, null);
	
	}
//	else if (States.BOTTLE_AT_POS_5) {
//
//	} 
	else if (States.BOTTLE_LEFT_POS_5) { // done
		g.clearRect(0, 0, x, y);
		g.drawImage(conveyorBottleLeftPos5, x1, y1, null);

	}
//	else if (States.BOTTLE_AT_EMPTY) { // done
//		g.setColor(Color.red);
//        g.fillOval(rectX + 10, rectY - 25, 30, 30); 	
//	}
	
	
	}
	
	
} 
		

