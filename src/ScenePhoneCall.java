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
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScenePhoneCall extends JPanel {
    /** This variable stores the background image*/
    private Image bg;
    /** This variable stores the type of job */
    static String[] sentences = {
            "Hey Mom! Can I get that sweater I ", "wanted to get a couple weeks ago?",
            "Sorry honey I didn't make ", "enough money this week to buy it.",
            "Awww","But I really wanted it!!",
            "Maybe it would be helpful for you", "to put yourself in my shoes",
            "Why?", "", "Maybe you will be able to see", "how hard I work for you.",
            "Okay I guess I should see how ", "difficult work is.",
            "In the game you will be working ","in place of me. Use your keyboard","to type the words before", "it exits the screen."};
    int count;



    /** The constructor of the screen */
    ScenePhoneCall() {
        try {
            bg = ImageIO.read(new File("src/img/newClothesCallBG.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                repaint();
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

        g.setColor(Color.black);

        int xcord;
        int ycord;

        if(count%4==0){
            xcord = 210;
            ycord = 450;
            Kid(g);
        } else {
            xcord = 280;
            ycord = 40;
            Mom(g);
        }

        g.setColor(Color.black);
        g.setFont(Game.font.deriveFont(20f));

        if (count < sentences.length-1) {
            g.drawString(sentences[count], xcord, ycord);
            g.drawString(sentences[count+1], xcord, ycord+30);
            if (count>12){
                g.drawString(sentences[count+2], xcord, ycord+60);
                g.drawString(sentences[count+3], xcord, ycord+90);
                count+=2;
            }
            count++;
        } else if (count >= sentences.length) {
            Game.gameState = 10;
        }

    }

    public void Mom(Graphics g){
        Graphics2D buttons = (Graphics2D) g;

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.setPaint(new Color(255, 255, 255));
        buttons.fillRoundRect(270, 10, 270, 130, 25, 25);
    }

    public void Kid(Graphics g){
        Graphics2D buttons = (Graphics2D) g;

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.setPaint(new Color(255, 255, 255));
        buttons.fillRoundRect(200, 420, 300, 130, 25, 25);
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
