/**
 * The SceneLanguageClass is the screen for the language class.
 *
 * <p>
 * Version 1 - 3h
 * Added BufferedImage, created dialogue image, added graphics to screen
 * - Mona
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.20.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SceneLanguageClass extends JPanel {
    private BufferedImage bg;
    private BufferedImage teacher;
    static String[] sentences = {"Hello Everybody!", "Welcome to Language Class!", "Today we will be doing this!"};


    /**
     * Constructor, initializes graphics
     */
    SceneLanguageClass() {
        try {
            bg = ImageIO.read(new File("src/img/TeacherBG.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            teacher = ImageIO.read(new File("src/img/pixil-layer-3.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Image back = bg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        super.paintComponent(g);
        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }
        if (teacher != null) {
            Image teach = teacher.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, -50, 330, this);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.PLAIN, 24));

        int xcord=300;
        int ycord=470;
        //for( int x=0; x<sentences.length; x++) {

            g.setColor(Color.black);
            g.drawString(sentences[0], xcord, ycord);
            g.drawString(sentences[0 + 1], xcord, ycord+40);
        //}
    }

}

