/**
 * The SceneInterviewDialogue class for the job interview
 * <h3> Draft 1 </h3>
 * <p>
 * Version 1 - 5h
 * Designed the background
 * Created the conversation
 * - Mona
 *
 * Version 2 - 2h
 * Made the conversation interactive
 * Completed the conversation
 * - Mona
 * </p>
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

public class SceneInterviewDialogue extends JPanel {
    /** This variable stores the background image*/
    private Image bg;
    /** This variable stores person that is interviewing*/
    private BufferedImage person;
    /** This variable stores the type of job */
    String job = "none";

    /** The constructor of the screen */
    SceneInterviewDialogue() {
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
                if (job.equals("Receptionist")) {
                    repaint();
                    Game.gameState = 12;
                }

                if (e.getX() > 350 && e.getX() < 650 && e.getY() > 300 && e.getY() < 350)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
                    job = "Engineer";
                } else if (e.getX() > 350 && e.getX() < 650 && e.getY() > 370 && e.getY() < 420)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
                    job = "Teacher";
                } else if (e.getX() > 350 && e.getX() < 650 && e.getY() > 440 && e.getY() < 490)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
                    job = "Receptionist";
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
        g.setFont(Game.font.deriveFont(20f));
        g.drawString("Engineer $100,000/year", 415, 330);
        g.drawString("Supply Teacher $40,000/year", 390, 400);
        g.drawString("Receptionist $15,000/year", 400, 470);

        if (job.equals("none")) {
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("What job would you like?", 360, 240);
        } else if (job.equals("Engineer")) {
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Sorry! We cannot accept your ", 360, 210);
            g.drawString("previous engineering degree.", 360, 240);
            g.setFont(Game.font.deriveFont(15f));
            g.drawString("Please select another option.", 360, 270);
        } else if (job.equals("Teacher")) {
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Sorry! We cannot accept your ", 360, 210);
            g.drawString("previous teaching experience.", 360, 240);
            g.setFont(Game.font.deriveFont(15f));
            g.drawString("Please select another option.", 360, 270);
        } else if (job.equals("Receptionist")) {
            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(335, 180, 330, 250, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Application accepted!", 345, 210);
            g.drawString("Click to continue.", 345, 340);
            g.setFont(Game.font.deriveFont(20f));
            g.drawString("(Sometimes degrees/experience earned in", 345, 260);
            g.drawString("a different country may not be recognized)", 345, 285);

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
