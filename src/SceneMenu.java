/**
 * The SceneMenu class is the screen for the menu.
 * <h3> Draft 1 </h3>
 * <p>
 * Version 1 - 2h
 * Found the coordinate bounds for the buttons
 * Designed background
 * - Alisa
 *
 * Version 2 - 3h
 * Added mouse listener
 * Created bounds for the buttons
 * Graphics layout
 * - Mona
 *
 * Version 3 - 30 min
 * Fixed bugs
 * - Lois
 *
 * </p>
 *
 * <h3> Draft 3 </h3>
 * <p>
 *     Version 4 - 1.5h
 *     Redrew main screen pixel art
 *     - Alisa
 * </p>
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

public class SceneMenu extends JPanel {
    /** This variable stores the background image*/
    private BufferedImage bg;

    /** The constructor of the screen */
    SceneMenu() {
        try {
            bg = ImageIO.read(new File("src/img/bg2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 120 && e.getX() < 390 && e.getY() > 380 && e.getY() < 460)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
                    Game.gameState = 5;
                    System.out.println("PLAY");

                } else if (e.getX() > 408 && e.getX() < 680 && e.getY() > 380 && e.getY() < 460)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 2;
                    System.out.println("INSTRUCTIONS");
                } else if (e.getX() > 120 && e.getX() < 390 && e.getY() > 480 && e.getY() < 560)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 3;
                    System.out.println("HIGHSCORES");
                } else if (e.getX() > 408 && e.getX() < 680 && e.getY() > 480 && e.getY() < 560)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 4;
                    System.out.println("EXIT");
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
