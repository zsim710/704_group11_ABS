package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	BufferedImage arm1;
	BufferedImage arm2;
	BufferedImage p1;
	BufferedImage p2;
	BufferedImage loader;
	BufferedImage cap;
	
	BufferedImage RotaryTable;
//	BufferedImage[] rotaryFrames = new BufferedImage[5];
	int rotaryFrameIndex = 0;
	
	public Canvas(){
		try {
			 BufferedImage bi = ImageIO.read(new File("res/arm.png"));
			 arm1 = bi.getSubimage(0, 0, 64, 256);
//			 arm2 = bi.getSubimage(71, 0, 48, 256);
//			loader = ImageIO.read(new File("res/loader.png"));
			// bi = ImageIO.read(new File("res/pusher.png"));
			// p1 = bi.getSubimage(0, 0, 238, 68);
			// p2 = bi.getSubimage(238, 0, 172, 68);
//			cap = ImageIO.read(new File("res/cap.png"));
			 BufferedImage RT = ImageIO.read(new File("res/RT3.0.png"));
			 RotaryTable = RT.getSubimage(0, 0, 380, 378);

			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;  
		}
	}
	 	int rectX = 50;  // Default position (POSA)
	    int rectY = 150;
	    int rectWidth = 50;
	    int rectHeight = 100;
	    Color rectColor = Color.black;  // Default color
	    
//	    Color WS1Color = Color.gray;
//	    Color WS2Color = Color.gray;
//	    Color WS3Color = Color.gray;
//	    Color WS4Color = Color.gray;
//	    Color WS5Color = Color.gray;
//	    Color WS6Color = Color.gray;
	    
	    Color [] WSColors = {Color.gray, Color.gray, Color.gray, Color.gray, Color.gray, Color.gray};

	    boolean [] BottlePresent = {false, false, false, false, false, false}; 
	    
	    int armx = 30;
	    int army = 30;
	    
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
//		g.drawImage(loader, 0, 100, null);
		g.drawImage(RotaryTable, 220, 219, 300, 300, null);
		g.drawImage(arm1, armx, army, null);
		
        g.setColor(WSColors[0]);
        g.fillOval(230, 378, 60, 60); // ws1
        g.setColor(WSColors[1]);
        g.fillOval(305, 248, 60, 60); // ws2
        g.setColor(WSColors[2]);
        g.fillOval(455, 248, 60, 60); // ws3
        g.setColor(WSColors[3]);
        g.fillOval(530, 378, 60, 60); // ws4
        g.setColor(WSColors[4]);
        g.fillOval(455, 508, 60, 60); // ws5
        g.setColor(WSColors[5]);
        g.fillOval(305, 508, 60, 60); // ws6

//        g.fillRect(50, 300, 200, 40); // Draw a visible rectangle
        	    
	    // Change rectangle position and color based on states
	    if (States.POSA) {
	        rectX = 50;
	        rectColor = Color.green;
	        rectY = 150;
	        army = 30;
	//        g.drawImage(arm1, 0, 0, null);
//	        g.fillRect(50, 300, 200, 40); // Draw a visible rectangle
//	        g.setColor(Color.green);
	
	    } else if (States.POSB) {
	    	rectY = 150;
	        rectX = 125;  // Move to position B
			army = 60;
	        rectColor = Color.cyan;
	
	    } else if (States.POSC) {
	    	rectY = 150;
	        rectX = 200;  // Move to position C
	        rectColor = Color.yellow;
	
	    } else if (States.POSD) {
	        rectX = 200;  // Move to position D
			rectY = 200;
	        rectColor = Color.orange;
	    }
    
    // Draw the movable rectangle
//    g.setColor(rectColor);
//    g.fillRect(rectX, rectY, rectWidth, rectHeight);
	    
	    // check for WS occupied
//	    if(States.WS1) {
//	    	WS1Color = Color.blue;
//	    }
	    if(States.rotation != States.prevRotation){
			if(States.rotation){
//				rotaryFrameIndex = (rotaryFrameIndex + 1) % rotaryFrames.length;
				
				
				BottlePresent[rotaryFrameIndex] = false;
				WSColors[rotaryFrameIndex] = Color.gray;
				rotaryFrameIndex = (rotaryFrameIndex + 1) % 6;
				BottlePresent[rotaryFrameIndex] = true;
				WSColors[rotaryFrameIndex] = Color.blue;

			}
			// else: hold previous image
		}
	    
//	    for (int i=0; i<5; i++) {
	    	//if (BottlePresent[rotaryFrameIndex] = true) {
	    //	} else {
	    	//	WSColors[i] = Color.gray;
	    //	}
//	    }
	    
    
    // Show grip status 
    if (States.GRIPDAT) {
        //g.setColor(Color.red);
        g.setColor(Color.blue);
      //  System.out.println("I SEE U");
        g.fillOval(rectX + 10, rectY - 25, 30, 30); // Draw grip indicator above the rectangle
    } else {
    	g.setColor(Color.magenta);
        g.fillOval(rectX + 10, rectY - 25, 30, 30); 
    }
    
    
	// Rotary animation: advance frame on rising edge
	// Draw the current rotary image (always show the last selected frame)
//	g.drawImage(rotaryFrames[rotaryFrameIndex], 300, 100, null);
	
	}
	
	
} 
		

