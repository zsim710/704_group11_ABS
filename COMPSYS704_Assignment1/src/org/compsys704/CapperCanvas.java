package org.compsys704;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CapperCanvas extends JPanel {
    // upload to res folder and delete comment
    BufferedImage capperIdle;
    BufferedImage bottleAtPos4;
    BufferedImage capperGripperClamp;
    BufferedImage capperDone;
 
    public CapperCanvas() {
        try {
            capperIdle = ImageIO.read(new File("res/capperIdle.png"));
            bottleAtPos4 = ImageIO.read(new File("res/capperBottleSensed.png"));
            capperGripperClamp = ImageIO.read(new File("res/capperGripperAndClamped.png"));
            capperDone = ImageIO.read(new File("res/capperDone.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // default image: capper idle
//        g.drawImage(capperIdle, 0, 0, null);

        if (States.CAPPER_IDLE) {
            g.clearRect(0, 0, 400, 400);
            g.drawImage(capperIdle, 0, 0, null);
        }
        else if (States.BOTTLE_AT_POS4) {
            g.clearRect(0, 0, 400, 400);
            g.drawImage(bottleAtPos4, 0, 0, null);
        }
        else if (States.CAPPER_GRIPPER_CLAMP) {
            g.clearRect(0, 0, 400, 400);
            g.drawImage(capperGripperClamp, 0, 0, null);
        }
        else if (States.CAPPER_DONE) {
            g.clearRect(0, 0, 400, 400);
            g.drawImage(capperDone, 0, 0, null);
        }
    }
}
