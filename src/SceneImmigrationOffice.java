/**
 * The SceneImmigrationOffice class for the immigration office
 * <p>
 * Version 1 - 5h
 * Designed the background
 * Created the conversation
 * - Mona
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.31.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneImmigrationOffice extends JPanel {
    /** This variable stores the background image*/
    private Image bg;
    /** This variable stores person that is interviewing*/
    private BufferedImage person;
    int moneyDecreased;

    /** The constructor of the screen */
    SceneImmigrationOffice() {
        try {
            bg = ImageIO.read(new File("src/img/interviewBG.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            person = ImageIO.read(new File("src/img/pixil-layer-2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 80 && e.getX() < 200 && e.getY() > 280 && e.getY() < 330)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.money-=300;
                    Game.sponsoredFamily="two kids";
                    Game.gameState++;
                } else if (e.getX() > 210 && e.getX() < 330 && e.getY() > 280 && e.getY() < 330)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.money-=150;
                    Game.sponsoredFamily="one kid";
                    Game.gameState++;
                } else if (e.getX() > 340 && e.getX() < 460 && e.getY() > 280 && e.getY() < 330)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.sponsoredFamily="nobody";
                    Game.gameState++;
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
            g.drawImage(bg, 0, 0, this);
        }
        if (person != null) {
            Image teach = person.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, 400, 180, this);
        }

        Graphics2D buttons = (Graphics2D) g;

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.setPaint(new Color(255, 255, 255));
        buttons.fillRoundRect(70, 150, 400, 100, 25, 25);

        buttons.setPaint(new Color(220, 135, 135));
        buttons.fillRoundRect(80, 280, 120, 50, 25, 25);
        buttons.fillRoundRect(210, 280, 120, 50, 25, 25);
        buttons.fillRoundRect(340, 280, 120, 50, 25, 25);

        g.setColor(Color.black);
        g.setFont(Game.font.deriveFont(20f));
        g.drawString("Yes", 120, 310);
        g.drawString("One child", 235, 310);
        g.drawString("No", 390, 310);

        g.setFont(Game.font.deriveFont(22f));
        g.drawString("You can sponsor a spouse, or a partner from ", 90, 180);
        g.drawString("$1,080, or a child from $150. Would you like ", 90, 210);
        g.drawString("to sponsor your two children?", 90, 240);

        if(moneyDecreased==300){
            Game.money-=moneyDecreased;
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
