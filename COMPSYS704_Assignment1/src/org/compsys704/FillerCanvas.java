package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FillerCanvas extends JPanel {
	// upload to res folder and delete comment
	BufferedImage fillerOff;
	BufferedImage f1valveAndCanisterOn;
	BufferedImage f2valveAndCanisterOn;
	BufferedImage f1InletAndCanister;
	BufferedImage f2InletAndCanister;
	BufferedImage bottleAtFiller;
    BufferedImage allFillersComplete;

	public FillerCanvas(){
		try {
			fillerOff = ImageIO.read(new File("res/fillerOff.png"));
			f1valveAndCanisterOn = ImageIO.read(new File("res/f1ValveAndCanister.png"));
            f2valveAndCanisterOn = ImageIO.read(new File("res/f2ValveAndCanister.png"));
			f1InletAndCanister = ImageIO.read(new File("res/f1InletAndCanister.png"));
            f2InletAndCanister = ImageIO.read(new File("res/f2InletAndCanister.png"));
            bottleAtFiller = ImageIO.read(new File("res/bottleAtFiller.png"));
            allFillersComplete = ImageIO.read(new File("res/allFillersComplete.png"));
        } catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;  
		}
	}
	     
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

        // draw the og image of filler off
//        g.drawImage(fillerOff, 0, 0, null);

        // filler 
        if(States.BOTTLE_AT_POS2) {	
            g.clearRect(0, 0, 400, 400);
            g.drawImage(bottleAtFiller, 0, 0, null);
        }
        else if (States.ALL_FILLERS_COMPLETE) {
            g.clearRect(0, 0, 400, 400);
            g.drawImage(allFillersComplete, 0, 0, null);
        }
        else if (States.FILLER1_VALVE_CANISTER) {
            g.clearRect(0, 0, 400, 400);
            g.drawImage(f1valveAndCanisterOn, 0, 0, null);
        } 
        else if (States.FILLER2_VALVE_CANISTER) { // done
            g.clearRect(0, 0, 400, 400);
            g.drawImage(f2valveAndCanisterOn, 0, 0, null);
        }
        else if (States.FILLER1_VALVE_INLET) { // done
            g.clearRect(0, 0, 400, 400);
            g.drawImage(f1InletAndCanister, 0, 0, null);
        }
        else if (States.FILLER2_VALVE_INLET) { // done
            g.clearRect(0, 0, 400, 400);
            g.drawImage(f2InletAndCanister, 0, 0, null);
        }
        else if (States.FILLER_IDLE) {
            g.clearRect(0, 0, 400, 400);
            g.drawImage(fillerOff, 0, 0, null);
        }
	}
	
}