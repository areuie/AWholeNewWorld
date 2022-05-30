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
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class SceneLongMainScreen extends JPanel{
    /** This variable stores the background */
    private BufferedImage bg, spriteStanding,spriteTest;
    /** This variable stores the x coord of the background */
    int backgroundX = 0;
    /** This variable checks if the player is walking or not */
    boolean isWalking = false;
    int typeImage = 0;//0 is still, 1,2,3,4 are walking/motion
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (typeImage == 0) typeImage = 1;
            else if (typeImage == 1) typeImage = 0;
            System.out.println("hi");
            repaint();
        }
    });

    /**
     * The constructor of the panel
     */
    public SceneLongMainScreen(){
        try {
            bg = ImageIO.read(new File("src/img/BGTemp.png"));
            spriteStanding = ImageIO.read(new File("src/img/pixil-frame-female.png"));
            spriteTest = ImageIO.read(new File("src/img/pixil-frame-male.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        timer.start();
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
        if(true){
            Image standing = spriteStanding.getScaledInstance(spriteStanding.getWidth()*6, spriteStanding.getHeight()*6, Image.SCALE_DEFAULT); ;
            if (typeImage == 0) standing = spriteStanding.getScaledInstance(spriteStanding.getWidth()*6, spriteStanding.getHeight()*6, Image.SCALE_DEFAULT);
            else if (typeImage == 1) standing = spriteTest.getScaledInstance(spriteTest.getWidth()*6, spriteTest.getHeight()*6, Image.SCALE_DEFAULT);
            g.drawImage(standing,10,360, this);
        }

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

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
