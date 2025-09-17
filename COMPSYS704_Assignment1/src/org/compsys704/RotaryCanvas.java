package org.compsys704;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RotaryCanvas extends JPanel {
	BufferedImage p1;
	BufferedImage p2;
	BufferedImage loader;
	BufferedImage cap;
	
	BufferedImage RotaryTable;
//	BufferedImage[] rotaryFrames = new BufferedImage[5];
	int rotaryFrameIndex = 0;
	 
	public RotaryCanvas(){
		try {
//			 BufferedImage bi = ImageIO.read(new File("res/arm.png"));
//			 arm1 = bi.getSubimage(0, 0, 64, 256);
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
	    
	    Color [] WSColors = {Color.gray, Color.gray, Color.gray, Color.gray, Color.gray, Color.gray};

	    boolean [] BottlePresent = {false, false, false, false, false, false}; 
	    
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(RotaryTable, 100, 100, 300, 300, null);	    
	    
	    if (States.FAULT_AT_POS1) {
	    	WSColors[0] = Color.red;
	    } else if (States.BOTTLE_AT_POS_1R) {
	    	WSColors[0] = Color.cyan;
	    } else {
	    	WSColors[0] = Color.gray;
	    }
	    
	    if (States.BOTTLE_AT_POS_2R) {
	    	WSColors[1] = Color.cyan;
	    } else {
	    	WSColors[1] = Color.gray;
	    }
	    
	    if (States.BOTTLE_AT_POS_3R) {
	    	WSColors[2] = Color.cyan;
	    } else {
	    	WSColors[2] = Color.gray;
	    }
	    
	    if (States.BOTTLE_AT_POS_4R) {
	    	WSColors[3] = Color.cyan;
	    } else {
	    	WSColors[3] = Color.gray;
	    }
	    
	    if (States.BOTTLE_AT_POS_5R) {
	    	WSColors[4] = Color.cyan;
	    } else {
	    	WSColors[4] = Color.gray;
	    }
	    
	    g.setColor(WSColors[0]);
	    g.fillOval(70, 220, 60, 60); // ws1
	    g.setColor(WSColors[1]);
	    g.fillOval(145, 91, 60, 60); // ws2
	    g.setColor(WSColors[2]);
	    g.fillOval(295, 91, 60, 60); // ws3
		g.setColor(WSColors[3]);
	    g.fillOval(370, 220, 60, 60); // ws4
	    g.setColor(WSColors[4]);
	    g.fillOval(295, 349, 60, 60); // ws5
	    g.setColor(WSColors[5]);
	    g.fillOval(145, 349, 60, 60); // ws6
	    
	    if (States.FAULT_AT_POS1) {
	    	g.setColor(Color.red);
	    	g.fillRect(0, 0, 50, 50);
	    }
	    
	    // check for WS occupied
//	    if(States.WS1) {
//	    	WS1Color = Color.blue;
//	    }
//	    if(States.rotation != States.prevRotation){
//			if(States.rotation){
////				rotaryFrameIndex = (rotaryFrameIndex + 1) % rotaryFrames.length;
//				
//				BottlePresent[rotaryFrameIndex] = false;
//				WSColors[rotaryFrameIndex] = Color.gray;
//				rotaryFrameIndex = (rotaryFrameIndex + 1) % 6;
//				BottlePresent[rotaryFrameIndex] = true;
//				WSColors[rotaryFrameIndex] = Color.blue;
//
//			}
//			// else: hold previous image
//		}
	    
//	    for (int i=0; i<5; i++) {
	    	//if (BottlePresent[rotaryFrameIndex] = true) {
	    //	} else {
	    	//	WSColors[i] = Color.gray;
	    //	}
//	    }
	    
    
    // Show grip status 
//    if (States.GRIPDAT) {
//        //g.setColor(Color.red);
//        g.setColor(Color.blue);
//      //  System.out.println("I SEE U");
//        g.fillOval(rectX + 10, rectY - 25, 30, 30); // Draw grip indicator above the rectangle
//    } else {
//    	g.setColor(Color.magenta);
//        g.fillOval(rectX + 10, rectY - 25, 30, 30); 
//    }
    
    
	// Rotary animation: advance frame on rising edge
	// Draw the current rotary image (always show the last selected frame)
//	g.drawImage(rotaryFrames[rotaryFrameIndex], 300, 100, null);
	
	}
	
	
} 
		

