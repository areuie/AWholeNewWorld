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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneLongMainScreen extends JPanel{
    /** This variable stores the background */
    private BufferedImage bg, spriteStanding,spriteAni1,spriteAni2,spriteAni3,spriteAni4, spriteKidStanding,spriteKidAni1, spriteKidAni2, spriteKidAni3, spriteKidAni4, bSchool, bWork, bPost, bImm;
    private Image[] buildingList = new Image[4];
    boolean[] buttonHover = new boolean[2];
    private int[][] levelBuildingList =
            {
                    {0, 2},
                    {0, 1, 2},
                    {1, 3}
            };
    /** This variable stores the x coord of the background */
    static int backgroundX = 0, beforeBackgroundX = 0;
    /** This variable checks if the player is walking or not */
    boolean isWalking = false;
    /** This variable controls the images needed for the sprite walking animation */
    int typeImage = 0;//0 is still, 1,2,3,4 are walking/motion
    /** This variable stores the distance between each building */
    int buildingDistBetween = 600;
    /** This variable stores the type of popup*/
    int popupType = 0; //0 is default, 1 is school, 2 is work, 3 is post office, 4 is immigration office
    /** This variable stores the y coords of the buildings */
    int[] buildingYCoords = {-95, -230, -105, -230};
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
                System.out.println("!isWalking" + Game.level);
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
            spriteStanding = ImageIO.read(new File("src/img/pixil-frame-female.png"));
            spriteAni1 = ImageIO.read(new File("src/img/pixil-frame-Female1.png"));
            spriteAni2 = ImageIO.read(new File("src/img/pixil-frame-Female2.png"));
            spriteAni3 = ImageIO.read(new File("src/img/pixil-frame-Female3.png"));
            spriteAni4 = ImageIO.read(new File("src/img/pixil-frame-Female4.png"));

            spriteKidStanding = ImageIO.read(new File("src/img/pixil-frame-Child.png"));
            spriteKidAni1 = ImageIO.read(new File("src/img/pixil-frame-Child1.png"));
            spriteKidAni2 = ImageIO.read(new File("src/img/pixil-frame-Child2.png"));
            spriteKidAni3 = ImageIO.read(new File("src/img/pixil-frame-Child3.png"));
            spriteKidAni4 = ImageIO.read(new File("src/img/pixil-frame-Child4.png"));

            bSchool = ImageIO.read(new File("src/img/schoolBuilding.png"));
            bWork = ImageIO.read(new File("src/img/workBuilding.png"));
            bPost = ImageIO.read(new File("src/img/postBuilding.png"));
            bImm = ImageIO.read(new File("src/img/immigrationBuilding.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Game.gameState == 12) {
            timer1.start();
            timer2.start();
        }

        buildingList[0] = bSchool.getScaledInstance(bSchool.getWidth() * 2, bSchool.getHeight() * 2, Image.SCALE_DEFAULT);
        buildingList[1] = bWork.getScaledInstance(bWork.getWidth() * 2, bWork.getHeight() * 2, Image.SCALE_DEFAULT);
        buildingList[2] = bPost.getScaledInstance(bPost.getWidth() * 2,bPost.getHeight() * 2, Image.SCALE_DEFAULT);
        buildingList[3] = bImm.getScaledInstance(bImm.getWidth() * 2, bImm.getHeight() * 2, Image.SCALE_DEFAULT);

        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                if (popupType != 0) {
                    if (e.getX() > 250 && e.getX() < 550 && e.getY() > 300 && e.getY() < 350)//if they press yes they are taken to the scene
                    {
                        System.out.println("hover");
                        buttonHover[0] = true;
                    } else buttonHover[0] = false;
                    if (e.getX() > 250 && e.getX() < 550 && e.getY() > 370 && e.getY() < 420)//if they press no, they continue on
                    {
                        System.out.println("no hover");
                        buttonHover[1] = true;
                    } else buttonHover[1] = false;
                    repaint();
                }
            }

        });

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (popupType != 0) {
                    if (e.getX() > 250 && e.getX() < 550 && e.getY() > 300 && e.getY() < 350)//if they press yes they are taken to the scene
                    {
                        System.out.println("yess!");
                        backgroundX -= 5;
                        timer1.stop();
                        timer2.stop();
                        switch (popupType) {
                            case 1:
                                Game.gameState = 5;
                                break;
                            case 2:
                                Game.gameState = 8;
                                break;
                            case 3:
                                Game.gameState = 6;
                                break;
                            case 4:
                                Game.gameState = 9;
                                break;
                            case 5:
                                Game.gameState = 7;
                                break;
                            case 6:
                                Game.gameState = 16;
                                break;
                            case 7:
                                Game.gameState = 11;
                                break;
                        }
                        repaint();
                    } else if (e.getX() > 250 && e.getX() < 550 && e.getY() > 370 && e.getY() < 420)//if they press no, they continue on
                    {
                        System.out.println("noo!");
                        popupType = 0;
                        backgroundX -= 5;
                        repaint();
                    }
                }
            }
        });

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");

        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right " + backgroundX);
                if (Game.level == 1) {
                    if (backgroundX == -890) {
                        popupType = 1;
                    } else if (backgroundX == -1300) {
                        popupType = 2;
                    } else if (backgroundX + 1 < -1770) {
                        backgroundX = 0;
                        popupType = 0;
                        Game.gameState = 13;
                        isWalking = true;
                        System.out.println("Iswalking");
                    } else if (backgroundX + 1 > -1770) {
                        backgroundX -= 5;
                        isWalking = true;
                        System.out.println("Iswalking");
                    }
                } else if (Game.level == 2) {
                    if (backgroundX == -890) {
                        popupType = 3;
                    } else if (backgroundX == -1360) {
                        popupType = 4;
                    } else if (backgroundX == -1900) {
                        popupType = 5;
                    } else if (backgroundX + 1 < -2520) {
                        backgroundX = 0;
                        popupType = 0;
                        Game.gameState = 13;
                        isWalking = true;
                        System.out.println("Iswalking");
                    } else if (backgroundX + 1 > -2520) {
                        backgroundX -= 5;
                        isWalking = true;
                        System.out.println("Iswalking");
                    }
                } else if (Game.level == 3) {
                    if (backgroundX == -760) {
                        popupType = 6;
                    } else if (backgroundX == -1440) {
                        popupType = 7;
                    } else if (backgroundX + 1 < -2000) {
                        backgroundX = 0;
                        popupType = 0;
                        Game.gameState = 13;
                        isWalking = true;
                        System.out.println("Iswalking");
                    } else if (backgroundX + 1 > -2000) {
                        backgroundX -= 5;
                        isWalking = true;
                        System.out.println("Iswalking");
                    }
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
            g.drawImage(background, backgroundX + 2400, 0, this);
        }

        g.setFont(Game.font.deriveFont(27f));
        g.setColor(new Color(47, 47, 47));
        g.drawString("You safely immigrated with your mother.",100 + backgroundX, 105);
        g.drawString("Your goal is to overcome adversities",100 + backgroundX, 135);
        g.drawString("and sponsor the rest of your family,so",100 + backgroundX, 165);
        g.drawString("so that your family can start a new life.",100 + backgroundX, 195);
        g.drawString("",100 + backgroundX, 325);
        g.drawString("You will play as your mom during some scenes, as",100 + backgroundX, 255);
        g.drawString("your struggles may also stem from her struggles too.",100 + backgroundX, 285);
        g.setFont(Game.font.deriveFont(40f));
        g.setColor(new Color(0, 0, 0));
        g.drawString("Use the right arrow to move.",100 + backgroundX, 350);

        for (int i = 0; i < levelBuildingList[Game.level - 1].length; i++) {
            g.drawImage(buildingList[levelBuildingList[Game.level - 1][i]], backgroundX + buildingDistBetween * (i + 1), buildingYCoords[levelBuildingList[Game.level - 1][i]], this);
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

        if (popupType == 1) {
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(235, 180, 330, 100, 25, 25);

            if (!buttonHover[0]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[0]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 300, 300, 50, 25, 25);

            if (!buttonHover[1]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[1]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("Would you like to", 285, 230);
            g.drawString("enter the writing class?", 285, 260);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Yes", 380, 335);
            g.drawString("No", 380, 405);
        } else if (popupType == 2) {
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(235, 180, 330, 100, 25, 25);

            if (!buttonHover[0]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[0]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 300, 300, 50, 25, 25);

            if (!buttonHover[1]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[1]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("Would you like to enter", 285, 230);
            g.drawString("the post office?", 285, 260);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Yes", 380, 335);
            g.drawString("No", 380, 405);
        } else if (popupType == 3) {
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(235, 180, 330, 100, 25, 25);

            if (!buttonHover[0]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[0]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 300, 300, 50, 25, 25);

            if (!buttonHover[1]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[1]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("Would you like to enter", 285, 230);
            g.drawString("the writing class test?", 285, 260);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Yes", 380, 335);
            g.drawString("No", 380, 405);
        } else if (popupType == 4) {
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(235, 180, 330, 100, 25, 25);

            if (!buttonHover[0]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[0]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 300, 300, 50, 25, 25);

            if (!buttonHover[1]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[1]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("Would you like to enter", 285, 230);
            g.drawString("the job interview?", 285, 260);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Yes", 380, 335);
            g.drawString("No", 380, 405);
        } else if (popupType == 5) {
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(235, 180, 330, 100, 25, 25);

            if (!buttonHover[0]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[0]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 300, 300, 50, 25, 25);

            if (!buttonHover[1]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[1]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("Would you like to enter", 285, 230);
            g.drawString("the post office?", 285, 260);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Yes", 380, 335);
            g.drawString("No", 380, 405);
        } else if (popupType == 6) {
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(235, 180, 330, 100, 25, 25);

            if (!buttonHover[0]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[0]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 300, 300, 50, 25, 25);

            if (!buttonHover[1]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[1]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("Would you like to enter", 285, 230);
            g.drawString("the office?", 285, 260);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Yes", 380, 335);
            g.drawString("No", 380, 405);
        } else if (popupType == 7) {
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(255, 255, 255));
            buttons.fillRoundRect(235, 180, 330, 100, 25, 25);

            if (!buttonHover[0]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[0]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 300, 300, 50, 25, 25);

            if (!buttonHover[1]) buttons.setPaint(new Color(150, 150, 150));
            else if (buttonHover[1]) buttons.setPaint(new Color(100, 100, 100));
            buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(30f));
            g.drawString("Would you like to enter", 285, 230);
            g.drawString("the immigration office?", 285, 260);
            g.setFont(Game.font.deriveFont(25f));
            g.drawString("Yes", 380, 335);
            g.drawString("No", 380, 405);
        }

        Game.showMoney(g);
    }
}
