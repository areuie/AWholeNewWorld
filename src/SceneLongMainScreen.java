/**
 * The SceneLanguageClassGame class is the screen for the language class mini-game.
 * <h3> Draft 1 </h3>
 * <p>
 * Version 1 - 5h
 * Added BufferedImage
 * Created random cypher key derived from a string sentence
 * Text layout and logic
 * - Lois
 *
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.27.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 *
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class SceneLongMainScreen extends JPanel{
    /** This variable stores the background */
    private BufferedImage bg;
    /** This variable stores the x coord of the background */
    int backgroundX = 0;
    /** This variable checks if the player is walking or not */
    boolean isWalking = false;

    /**
     * The constructor of the panel
     */
    public SceneLongMainScreen(){
        try {
            bg = ImageIO.read(new File("src/img/BGTemp.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method determines the dimensions of the panel
     * @return The dimensions of the panel
     */
    @Override
    public Dimension getPreferredSize() { return new Dimension(800, 600); }

    /**
     * This method paints graphics on the screen.
     * @param g Graphic
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            Image background = bg.getScaledInstance(2400, 600, Image.SCALE_DEFAULT);
            g.drawImage(background, backgroundX, 0, this);
        }

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("A"), "left");
        im.put(KeyStroke.getKeyStroke("D"), "right");

        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");


        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("left " + backgroundX);
                if (backgroundX + 1 <= 0) {
                    backgroundX+=5;
                    isWalking = true;
                }
                repaint();
            }
        });

        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right " + backgroundX);
                if (backgroundX + 1 > -1595) {
                    backgroundX-=5;
                    isWalking = true;
                }
                repaint();
            }
        });
        setFocusable(true);
        requestFocusInWindow();
    }


}
