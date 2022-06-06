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
 * <h3> Draft 3 </h3>
 * <p>
 * Version 2 - 8h
 * Added graphics (drew them)
 * Added sprite animation
 * - Lois
 *
 * </p>
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneLongMainScreen extends JPanel{
    /** This variable stores the background */
    private BufferedImage bg, spriteStanding, spriteKidStanding, spriteAni1,spriteAni2,spriteAni3,spriteAni4;
    private BufferedImage spriteKidAni1, spriteKidAni2, spriteKidAni3, spriteKidAni4, bSchool, bWork, bPost, bImm;
    private Image[] buildingList = new Image[3];
    /** This variable stores the x coord of the background */
    int backgroundX = 0, beforeBackgroundX = 0;
    /** This variable checks if the player is walking or not */
    boolean isWalking = false;
    /** This variable controls the images needed for the sprite walking animation */
    int typeImage = 0;//0 is still, 1,2,3,4 are walking/motion
    /** This variable stores the distance between each building */
    int buildingDistBetween = 0;
    /** This variable timer controls the sprite walking animation */
    Timer timer1 = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
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
        }
    });

    /** This timer variable keeps track of the time when user stays in place, when x is not changing */
    Timer timer2 = new Timer(150, e -> beforeBackgroundX = backgroundX);

    /**
     * The constructor of the panel
     */
    public SceneLongMainScreen(){
        try {
            bg = ImageIO.read(new File("src/img/BGTemp.png"));
            spriteStanding = ImageIO.read(new File("src/img/pixil-frame-Female.png"));
            spriteKidStanding = ImageIO.read(new File("src/img/pixil-frame-Child.png"));
            spriteAni1 = ImageIO.read(new File("src/img/pixil-frame-Female1.png"));
            spriteAni2 = ImageIO.read(new File("src/img/pixil-frame-Female2.png"));
            spriteAni3 = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
            spriteAni4 = ImageIO.read(new File("src/img/pixil-frame-Female4.png"));
            spriteKidAni1 = ImageIO.read(new File("src/img/pixil-frame-Child1.png"));
            spriteKidAni2 = ImageIO.read(new File("src/img/pixil-frame-Child2.png"));
            spriteKidAni3 = ImageIO.read(new File("src/img/pixil-frame-Child3.png"));
            spriteKidAni4 = ImageIO.read(new File("src/img/pixil-frame-Child4.png"));
            bSchool = ImageIO.read(new File("src/img/schoolBuilding.png"));
            bWork = ImageIO.read(new File("src/img/workBuilding.png"));
            bPost = ImageIO.read(new File("src/img/postBuilding.png"));
//            bImm = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Game.gameState == 12) {
            timer1.start();
            timer2.start();
        }

        buildingList[0] = bSchool.getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        buildingList[1] = bWork.getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        buildingList[2] = bPost.getScaledInstance(700, 700, Image.SCALE_DEFAULT);

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");

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
        if(buildingList[0] != null){
            Image building = buildingList[0];
            g.drawImage(building, 250 + backgroundX + buildingDistBetween, -25, this);
        }
        if(buildingList[1] != null){
            Image building = buildingList[1];
            g.drawImage(building, 850 + backgroundX + buildingDistBetween, -145, this);
        }
        if(buildingList[2] != null){
            Image building = buildingList[2];
            g.drawImage(building, 1500 + backgroundX + buildingDistBetween, -40, this);
        }

        Image spriteKid = spriteKidStanding.getScaledInstance(spriteKidStanding.getWidth()*6, spriteKidStanding.getHeight()*6, Image.SCALE_DEFAULT);
        Image sprite = spriteStanding.getScaledInstance(spriteStanding.getWidth()*6, spriteStanding.getHeight()*6, Image.SCALE_DEFAULT);
        if (typeImage == 0){
            sprite = spriteStanding.getScaledInstance(spriteStanding.getWidth()*6, spriteStanding.getHeight()*6, Image.SCALE_DEFAULT);
            spriteKid = spriteKidStanding.getScaledInstance(spriteKidStanding.getWidth()*6, spriteKidStanding.getHeight()*6, Image.SCALE_DEFAULT);
        }
        else if (typeImage == 1){
            sprite = spriteAni1.getScaledInstance(spriteAni1.getWidth()*6, spriteAni1.getHeight()*6, Image.SCALE_DEFAULT);
            spriteKid = spriteKidAni1.getScaledInstance(spriteKidAni1.getWidth()*6, spriteKidAni1.getHeight()*6, Image.SCALE_DEFAULT);
        }
        else if (typeImage == 2){
            sprite = spriteAni2.getScaledInstance(spriteAni2.getWidth()*6, spriteAni2.getHeight()*6, Image.SCALE_DEFAULT);
            spriteKid = spriteKidAni2.getScaledInstance(spriteKidAni2.getWidth()*6, spriteKidAni2.getHeight()*6, Image.SCALE_DEFAULT);
        }
        else if (typeImage == 3){
            sprite = spriteAni3.getScaledInstance(spriteAni3.getWidth()*6, spriteAni3.getHeight()*6, Image.SCALE_DEFAULT);
            spriteKid = spriteKidAni3.getScaledInstance(spriteKidAni3.getWidth()*6, spriteKidAni3.getHeight()*6, Image.SCALE_DEFAULT);
        }
        else if (typeImage == 4 || typeImage ==5){
            sprite = spriteAni4.getScaledInstance(spriteAni4.getWidth()*6, spriteAni4.getHeight()*6, Image.SCALE_DEFAULT);
            spriteKid = spriteKidAni4.getScaledInstance(spriteKidAni4.getWidth()*6, spriteKidAni4.getHeight()*6, Image.SCALE_DEFAULT);
        }
        g.drawImage(spriteKid,20,365, this);
        g.drawImage(sprite,120,365, this);
    }
}
