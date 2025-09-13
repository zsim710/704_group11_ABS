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
	
	public Canvas(){
		try {
			 BufferedImage bi = ImageIO.read(new File("res/arm.png"));
			 arm1 = bi.getSubimage(0, 0, 64, 256);
			 arm2 = bi.getSubimage(71, 0, 48, 256);
//			loader = ImageIO.read(new File("res/loader.png"));
			// bi = ImageIO.read(new File("res/pusher.png"));
			// p1 = bi.getSubimage(0, 0, 238, 68);
			// p2 = bi.getSubimage(238, 0, 172, 68);
//			cap = ImageIO.read(new File("res/cap.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
//		g.drawImage(loader, 0, 100, null);
//		g.drawImage(arm1, 0, 0, null);
        g.fillRect(50, 300, 200, 40); // Draw a visible rectangle
        
	    // Define rectangle position based on states
	    int rectX = 50;  // Default position (POSA)
	    int rectY = 150;
	    int rectWidth = 50;
	    int rectHeight = 100;
	    Color rectColor = Color.green;  // Default color
	    
	    // Change rectangle position and color based on states
	    if (States.POSA) {
	        rectX = 50;
	        rectColor = Color.green;
	//        g.drawImage(arm1, 0, 0, null);
//	        g.fillRect(50, 300, 200, 40); // Draw a visible rectangle
//	        g.setColor(Color.green);
	
	    } else if (States.POSB) {
	        rectX = 125;  // Move to position B
	//		g.drawImage(arm2, 20, 0, null);
	        rectColor = Color.cyan;
	
	    } else if (States.POSC) {
	        rectX = 200;  // Move to position C
	        rectColor = Color.yellow;
	
	    } else if (States.POSD) {
	        rectX = 200;  // Move to position D
			rectY = 200;
	        rectColor = Color.orange;

	
	    }
    
    // Draw the movable rectangle
    g.setColor(rectColor);
    g.fillRect(rectX, rectY, rectWidth, rectHeight);
    
    // Show grip status
    if (States.GRIPDAT) {
        g.setColor(Color.red);
        g.fillOval(rectX + 10, rectY - 25, 30, 30); // Draw grip indicator above the rectangle
    }
}

		// // base rectangle
		// g.drawRect(50, 150, 50, 100);
		// g.setColor(Color.green);
		
		// if(States.ARM_AT_DEST)
		// 	g.drawImage(arm1, 0, 0, null);
		// else
		// 	g.drawImage(arm2, 30, 0, null);
		//System.out.println("made it into paintComponent");

		
// 		if(States.POSA){
// //        this.setBackground(Color.green);
//     //    g.setColor(Color.green);
//         g.fillRect(50, 150, 50, 100); // Draw a visible rectangle
        
// 		}
// 		else if(States.POSB){
// //			this.setBackground(Color.cyan);
// //			g.setColor(Color.cyan);
// //			g.fillRect(50, 50, 100, 100);

// 			// System.err.println("im cyan?>>");
// 		}
// 		else if(States.POSC){
// //			this.setBackground(Color.yellow);
// 			g.setColor(Color.yellow);
// 			g.fillRect(200, 150, 50, 100);
// //	        g.fillOval(200, 100, 50, 50); // Draw a visible circle when gripping

// 		}
// 		else if(States.POSD){
// //			this.setBackground(Color.orange);
// //			g.setColor(Color.orange);
// //			g.fillRect(50, 50, 100, 100);
// 		}
    
//     // Show grip status
//     if(States.GRIPDAT){
//         g.setColor(Color.red);
//         g.fillOval(200, 100, 50, 50); // Draw a visible circle when gripping
//     }
    
    // Your other drawing code...
//    if(States.CAP_READY){ 
//        g.setColor(Color.black);
//        g.fillOval(40, 243, 30, 30);
//    }
    
//    if(!States.MAG_EMPTY){
//        g.drawImage(cap, 152, 155, null);
//    }
//		else{
//			if(States.CAP_READY){ // A cap is pushed to the source pos
//				g.setColor(Color.black);
//				g.fillOval(40, 243, 30, 30);
//			}
//		}
		
		// if(States.PUSHER_RETRACTED){
		// 	g.drawImage(p1, 90, 225, null);
		// 	if(!States.MAG_EMPTY){
		// 		g.setColor(Color.black);
		// 		g.fillOval(154, 243, 30, 30);
		// 	}
		// }
		// else{
		// 	g.drawImage(p2, 90, 225, null);
		// }
//		
//		if(!States.MAG_EMPTY){
//			g.drawImage(cap, 152, 155, null);
//		}
		
		// for bottle loader
		
	}

