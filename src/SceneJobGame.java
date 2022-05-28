/**
 * The SceneJobGame class is for writing a letter at the post office
 *
 * <p>
 * Version 1 - 2h
 * Designed background and buttons
 * -Mona
 *
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.20.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 *
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneJobGame extends JPanel {
    private BufferedImage bg = null;

    SceneJobGame () {
//        try {
//            bg = ImageIO.read(new File(""));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(Game.font.deriveFont(28f));

        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }


        Game.showMoney(g);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

}