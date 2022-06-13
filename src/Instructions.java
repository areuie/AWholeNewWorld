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

public class Instructions extends JPanel {
    /** This variable stores the background image*/
    private BufferedImage bg;

    /** The constructor of the screen */
    Instructions() {
        try {
            bg = ImageIO.read(new File("src/img/bg2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 350 && e.getX() < 450 && e.getY() > 445 && e.getY() < 505)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.gameState=1;
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

        buttons.setPaint(new Color(96, 96, 96, 255));
        buttons.fillRoundRect(100, 40, 600, 520, 25, 25);

        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(70f));
        g.drawString("Instructions", 260, 130);

        int y=200;
        g.setFont(Game.font.deriveFont(20f));

            g.drawString("You are an immigrant who has just arrived to a new country with your", 140, y);
            g.drawString("mom. This game will help stimulate the challenges that immigrants ", 140, y + 30);
            g.drawString("children face when arriving in a new country. There will ", 140, y + 60);
            g.drawString("be a walking part of the game where you can use your arrow keys to ", 140, y + 90);
            g.drawString("move right and left. Walk past buildings and choose the one you want ", 140, y + 120);
            g.drawString("to enter by clicking yes or no. Use your space key to click through ", 140, y + 150);
            g.drawString("the dialogue or use your mouse to press the buttons.", 140, y + 180);

        buttons.setPaint(new Color(98, 193, 199));
        buttons.fillRoundRect(350, 445, 100, 60, 25, 25);
        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(40f));
        g.drawString("NEXT", 365, 490);

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
