/**The Scene child test is the screen for everytime someone completes a level
 * <p>
 * Version 1 - 2h
 * Designed background
 * Added buttons
 * Added text
 * - Mona
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 06.03.22
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

public class SceneChildTest extends JPanel {
    /** This variable stores the background image*/
    private Image bg;
    /** This variable stores person that is interviewing*/
    private BufferedImage person;
    static String[][] sentences = {
            {       "You feel stressed because you always have to be",
                    "the one who has to answer the phone calls and",
                    "translate text for your mother to read.",
                    "",
                    "What should you do?",
            },

            {       "You feel lonely because your mother is always",
                    "taking extra shifts, leaving you alone most days.",
                    "What should you do?",
                    "",
            },
            {
                    "You feel confused because you're stuck between two",
                    "identities, your background culture and your new culture.",
                    "What should you do?",
                    "",
            }
    };

    static String[][] sentencesQ = {
            {       "You feel stressed because you always have to be",
                    "the one who has to answer the phone calls and",
                    "translate text for your mother to read.",
                    "",
                    "What should you do?",
            },

            {       "You feel lonely because your mother is always",
                    "taking extra shifts, leaving you alone most days.",
                    "What should you do?",
                    "",
            },
            {
                    "You feel confused because you're stuck between two",
                    "identities, your background culture and your new culture.",
                    "What should you do?",
                    "",
            }
    };

    /** The constructor of the screen */
    SceneChildTest() {
        try {
            bg = ImageIO.read(new File("src/img/WorkInteractBG.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            person = ImageIO.read(new File("src/img/pixil-layer-0.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 350 && e.getX() < 650 && e.getY() > 300 && e.getY() < 350)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
                } else if (e.getX() > 350 && e.getX() < 650 && e.getY() > 370 && e.getY() < 420)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
                } else if (e.getX() > 350 && e.getX() < 650 && e.getY() > 440 && e.getY() < 490)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
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
            g.drawImage(teach, -50, 230, this);
        }

        Graphics2D buttons = (Graphics2D) g;

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.setPaint(new Color(255, 255, 255));
        buttons.fillRoundRect(335, 180, 330, 100, 25, 25);

        buttons.setPaint(new Color(150, 150, 150));
        buttons.fillRoundRect(350, 300, 300, 50, 25, 25);
        buttons.fillRoundRect(350, 370, 300, 50, 25, 25);
        buttons.fillRoundRect(350, 440, 300, 50, 25, 25);

        g.setColor(Color.black);
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
