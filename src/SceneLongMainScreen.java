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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneLongMainScreen extends JPanel{
    /** This variable stores the background */
    private BufferedImage bg, spriteStanding,spriteAni1,spriteAni2,spriteAni3,spriteAni4, bSchool, bWork, bPost, bImm;
    private Building[] buildingList = new Building[4];
    /** This variable stores the x coord of the background */
    int backgroundX = 0, beforeBackgroundX = 0;
    /** This variable checks if the player is walking or not */
    boolean isWalking = false;
    int typeImage = 0;//0 is still, 1,2,3,4 are walking/motion
    Timer timer1 = new Timer(100, e -> {
        if(isWalking) {
            if (typeImage >4) typeImage = 1;
            System.out.println("type image: " + typeImage);
            repaint();
            typeImage++;
            System.out.println("Current X: " + backgroundX + " and before X: " + beforeBackgroundX);
        }
        if(beforeBackgroundX==backgroundX){
            isWalking = false;
            typeImage = 0;
            System.out.println("!isWalking");
        }
    });

    //Keep track of the time when user stays in place, when x is not changing.
    Timer timer2 = new Timer(150, e -> beforeBackgroundX = backgroundX);

    /**
     * The constructor of the panel
     */
    public SceneLongMainScreen(){
        try {
            bg = ImageIO.read(new File("src/img/BGTemp.png"));
            spriteStanding = ImageIO.read(new File("src/img/pixil-frame-female.png"));
            spriteAni1 = ImageIO.read(new File("src/img/pixil-frame-Female1.png"));
            spriteAni2 = ImageIO.read(new File("src/img/pixil-frame-Female2.png"));
            spriteAni3 = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
            spriteAni4 = ImageIO.read(new File("src/img/pixil-frame-Female4.png"));

//            bSchool = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
//            bWork = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
//            bPost = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
//            bImm = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Game.gameState == 9) {
            timer1.start();
            timer2.start();
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
                    System.out.println("Iswalking");
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
                    System.out.println("Iswalking");
                }
                repaint();
            }
        });
        setFocusable(true);
        requestFocusInWindow();
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

        Image sprite = spriteStanding.getScaledInstance(spriteStanding.getWidth()*6, spriteStanding.getHeight()*6, Image.SCALE_DEFAULT); ;
        if (typeImage == 0) sprite = spriteStanding.getScaledInstance(spriteStanding.getWidth()*6, spriteStanding.getHeight()*6, Image.SCALE_DEFAULT);
        else if (typeImage == 1) sprite = spriteAni1.getScaledInstance(spriteAni1.getWidth()*6, spriteAni1.getHeight()*6, Image.SCALE_DEFAULT);
        else if (typeImage == 2) sprite = spriteAni2.getScaledInstance(spriteAni2.getWidth()*6, spriteAni2.getHeight()*6, Image.SCALE_DEFAULT);
        else if (typeImage == 3) sprite = spriteAni3.getScaledInstance(spriteAni3.getWidth()*6, spriteAni3.getHeight()*6, Image.SCALE_DEFAULT);
        else if (typeImage == 4 || typeImage ==5) sprite = spriteAni4.getScaledInstance(spriteAni4.getWidth()*6, spriteAni4.getHeight()*6, Image.SCALE_DEFAULT);

        for (int i = 0; i < buildingList.length; i++) {
            g.drawImage(buildingList[i].getType(), buildingList[i].getX(), buildingList[i].getY(), this);
        }

        g.drawImage(sprite,10,360, this);
    }
}
