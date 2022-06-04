/**
 * The Level Complete class is the screen for everytime someone completes a level
 * <h3> Draft 3 </h3>
 * <p>
 * Version 1 - 2h
 * Designed background
 * - Mona
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 06.03.22
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

public class LevelComplete extends JPanel {
    /** This variable stores the background image*/
    private BufferedImage bg;

    /** The constructor of the screen */
    LevelComplete() {
        try {
            bg = ImageIO.read(new File("src/img/bg2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 300 && e.getX() < 500 && e.getY() > 300 && e.getY() < 350)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.gameState=12;//whichever game state will indicate the map of building
                }
            }
        });
    }

    /**
     * This method paints graphics on the screen.
     * @param g Graphic
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }
        Graphics2D buttons = (Graphics2D) g;

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.setPaint(new Color(96, 96, 96));
        buttons.fillRoundRect(100, 40, 600, 520, 25, 25);

        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(70f));
        g.drawString("LEVEL "+Game.level+" COMPLETE", 180, 250);

        buttons.setPaint(new Color(100, 30, 50));
        buttons.fillRoundRect(300, 300, 200, 60, 25, 25);
        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(40f));
        g.drawString("CONTINUE", 330, 345);
    }

    /**
     * This method determines the dimensions of the panel
     * @return The dimensions of the panel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

}
