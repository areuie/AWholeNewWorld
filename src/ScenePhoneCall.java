/**
 * The ScenePhoneCall class for phone call with mom
 * <h3> Draft 1 </h3>
 * <p>
 * Version 1 - 5h
 * Designed the background
 * Created the conversation
 * - Mona
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScenePhoneCall extends JPanel {
    /** This variable stores the background image*/
    private Image bg;
    /** This variable stores the mom*/
    private BufferedImage mom;
    /** This variable stores the kid*/
    private BufferedImage kid;
    /** This variable stores the type of job */
    String job = "none";
    static String[] sentences = {
            "Hey Mom! Can I get that toy I wanted to get a couple weeks ago?",
            "Sorry honey I didn't make enough money this week to buy it.",
            "Awww"};



    /** The constructor of the screen */
    ScenePhoneCall() {
        try {
            bg = ImageIO.read(new File("src/img/WorkInteractBG.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            mom = ImageIO.read(new File("src/img/pixil-frame-Female.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } try {
            kid = ImageIO.read(new File("src/img/pixil-frame-Child1.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
        if (mom != null) {
            Image teach = mom.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, 500, 230, this);
        }
        if (kid != null) {
            Image teach = kid.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
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
        } else if (job.equals("Receptionist"))
            Game.gameState=12;
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
