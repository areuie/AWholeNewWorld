/**
 * This class is the screen for the instructions.
 *
 *<h3>Draft 1</h3>
 * <p>
 *     Version 1 - 30 min
 *     Added background image
 *     - Lois
 * </p>
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.27.22
 *
 * <h2>Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
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

    /** This variable is the background of the screen */
    private BufferedImage bg;

    /** This is the constructor of the instructions screen */
    Instructions() {
        try {
            bg = ImageIO.read(new File("src/img/instructions.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
