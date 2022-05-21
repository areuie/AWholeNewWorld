/**
 * This class
 */


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Instructions extends JPanel {

    private BufferedImage bg;
    Instructions() {
        try {
            bg = ImageIO.read(new File("src/img/instructions.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
