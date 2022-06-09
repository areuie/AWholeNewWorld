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
            bg = ImageIO.read(new File("src/img/bg2noButton.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 350 && e.getX() < 450 && e.getY() > 445 && e.getY() < 505 && Game.instructionsState==1 && Game.level==1)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.gameState=1;
                } else if (e.getX() > 350 && e.getX() < 450 && e.getY() > 445 && e.getY() < 505 && Game.level==3)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.gameState=10;
                } else if (e.getX() > 350 && e.getX() < 450 && e.getY() > 445 && e.getY() < 505 && Game.instructionsState==2 )//if they press play button they are taken to the language class dialogue scene
                {
                    Game.gameState=6;
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

        buttons.setPaint(new Color(96, 96, 96, 232));
        buttons.fillRoundRect(100, 40, 600, 520, 25, 25);

        g.setColor(Color.white);
        g.setFont(Game.font.deriveFont(70f));
        g.drawString("Game Instructions", 180, 130);

        int y=200;
        g.setFont(Game.font.deriveFont(20f));
        if(Game.instructionsState==1) {
            g.drawString("You are an immigrant who has just arrived to a new country with your", 140, y);
            g.drawString("child. This game will help stimulate the challenges that immigrants ", 140, y + 30);
            g.drawString("and their children face, when arriving in a new country. There will ", 140, y + 60);
            g.drawString("be a walking part of the game where you can use your arrow keys to ", 140, y + 90);
            g.drawString("move right and left. Walk past buildings and choose the one you want ", 140, y + 120);
            g.drawString("to enter by clicking yes or no. Use your space key to click through ", 140, y + 150);
            g.drawString("the dialogue or use your mouse to press the buttons.", 140, y + 180);
        } else if(Game.level==3){
            g.drawString("In this game you will need to do your job at work, which is ", 140, y);
            g.drawString("typing as many of the words as you see on the screen before", 140, y + 30);
            g.drawString("they pass the screen. Use your keyboard to type the words", 140, y + 60);
        } else if(Game.instructionsState==2){
            g.drawString("In this game you will need to decipher the sentence using the", 140, y);
            g.drawString("symbols underneath the line. For example the symbol N underneath", 140, y + 30);
            g.drawString("the line may correspond to the letter A, so you need to put A", 140, y + 60);
            g.drawString("everywhere that the letter N is found. Doing this you will be  ", 140, y + 90);
            g.drawString("able to decipher the sentence.", 140, y + 120);
            g.drawString("Use your left and right arrow keys to move through the sentence.", 140, y + 150);
        }

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
