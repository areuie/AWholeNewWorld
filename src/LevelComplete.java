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
            bg = ImageIO.read(new File("src/img/bg2noButton.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 300 && e.getX() < 500 && e.getY() > 300 && e.getY() < 350)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.level++;
                    System.out.println(Game.level);
                    if (Game.level > 3) Game.gameState = 1;
                    else Game.gameState=12;//whichever game state will indicate the map of building
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

        buttons.setPaint(new Color(96, 96, 96, 208));
        buttons.fillRoundRect(100, 40, 600, 520, 25, 25);

        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(70f));
        if (Game.level == 1) {
            g.drawString("DEFICIENCY", 240, 190);
        } else if(Game.level == 2) {
            g.drawString("PANIC ROOM", 250, 190);
        } else if (Game.level == 3) {
            g.drawString("ESCAPE ROOM", 250, 190);
        }
        g.drawString("LEVEL COMPLETE", 200, 250);

        buttons.setPaint(new Color(98, 193, 199));
        buttons.fillRoundRect(300, 300, 200, 60, 25, 25);
        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(40f));
        g.drawString("CONTINUE", 330, 345);

        g.setFont(Game.font.deriveFont(20f));
        g.drawString("Note: In the completion of this level you noticed it was time to pay rent!", 140, 400);
        g.drawString("Your money decreases by $100.", 270, 430);

        Game.showMoney(g);
        Game.money-=100;
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
