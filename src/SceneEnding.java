/**
 * The Ending class is the screen for everytime someone finishes the game
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

public class SceneEnding extends JPanel {
    /** This variable stores the background image*/
    private BufferedImage bg;

    /** The constructor of the screen */
    SceneEnding() {
        try {
            bg = ImageIO.read(new File("src/img/bg2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 360 && e.getX() < 460 && e.getY() > 510 && e.getY() < 570)//if they press play button they are taken to the language class dialogue scene
                {
                    System.exit(0);
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
        buttons.fillRoundRect(110, 350, 590, 230, 25, 25);

        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(70f));

        if(Game.sponsoredFamily.equals("Everybody")){
            g.drawString("Best Ending!", 260, 430);
            g.setFont(Game.font.deriveFont(40f));
            g.drawString("This is the best outcome of the game!", 130, 480);
        } else if(Game.sponsoredFamily.equals("one kid")){
            g.drawString("Good Ending!", 260, 430);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("This is the second best outcome of the game!", 150, 480);
        } else if(Game.sponsoredFamily.equals("nobody")) {
            g.drawString("Bad Ending", 270, 420);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Unfortunately you got the bad ending because " , 200, 460);
            g.drawString("you weren't able to bring your family here.", 205, 490);
        }

        buttons.setPaint(new Color(98, 193, 199));
        buttons.fillRoundRect(360, 510, 100, 60, 25, 25);
        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(40f));
        g.drawString("DONE", 375, 555);

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
