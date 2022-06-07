/**
 * The SceneImmigrationOffice class for the immigration office
 * <p>
 * Version 1 - 5h
 * Designed the background
 * Created the conversation
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

public class SceneImmigrationOffice extends JPanel {
    /** This variable stores the background image*/
    private Image bg;
    private Image airport;
    /** This variable stores person that is interviewing*/
    private BufferedImage person;
    private BufferedImage child;
    private BufferedImage player;
    /** This variable stores the money needed to pay for the sponsorship*/
    int moneyNeeded;
    int futureStatus=-1;
    int next=0;

    /** The constructor of the screen */
    SceneImmigrationOffice() {
        try {
            bg = ImageIO.read(new File("src/img/immigrationOfficeBG.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            airport = ImageIO.read(new File("src/img/airportBG.png")).getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            person = ImageIO.read(new File("src/img/pixil-layer-2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            player = ImageIO.read(new File("src/img/pixil-frame-Female.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            child = ImageIO.read(new File("src/img/pixil-frame-Child.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 80 && e.getX() < 200 && e.getY() > 280 && e.getY() < 330 && next==0)//if they press play button they are taken to the language class dialogue scene
                {
                    moneyNeeded=300;
                    Game.sponsoredFamily="two kids";
                    repaint();
                } else if (e.getX() > 210 && e.getX() < 330 && e.getY() > 280 && e.getY() < 330 && next==0)//if they press play button they are taken to the language class dialogue scene
                {
                    moneyNeeded=150;
                    Game.sponsoredFamily="one kid";
                    repaint();
                } else if (e.getX() > 340 && e.getX() < 460 && e.getY() > 280 && e.getY() < 330 && moneyNeeded==0 && next==0)//if they press play button they are taken to the language class dialogue scene
                {
                    Game.sponsoredFamily="nobody";
                    futureStatus=0;
                    next=1;
                    repaint();
                } else if (e.getX() > 340 && e.getX() < 460 && e.getY() > 280 && e.getY() < 330 && moneyNeeded!=0)//if they press play button they are taken to the language class dialogue scene
                {
                    next=1;
                    repaint();
                } else if (e.getX() > 700 && e.getX() < 790 && e.getY() > 500 && e.getY() < 550 && next==1)//if they press play button they are taken to the language class dialogue scene
                {
                    System.exit(0);
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
        buttons.fillRoundRect(340, 280, 120, 50, 25, 25);

        if(Game.sponsoredFamily.equals("none")){
            buttons.setPaint(new Color(220, 135, 135));
            buttons.fillRoundRect(80, 280, 120, 50, 25, 25);
            buttons.fillRoundRect(210, 280, 120, 50, 25, 25);

            g.setColor(Color.black);
            g.setFont(Game.font.deriveFont(20f));
            g.drawString("Yes", 120, 310);
            g.drawString("One child", 235, 310);
            g.drawString("No", 390, 310);

            g.setFont(Game.font.deriveFont(22f));
            g.drawString("You can sponsor a spouse, or a partner from ", 90, 180);
            g.drawString("$1,080, or a child from $150. Would you like ", 90, 210);
            g.drawString("to sponsor your two children?", 90, 240);
        }
        else if(Game.sponsoredFamily.equals("two kids") && Game.money>moneyNeeded+100)
        {
            g.setFont(Game.font.deriveFont(22f));
            g.setColor(Color.black);
            g.drawString("Congratulations! Your request to sponsor ", 90, 180);
            g.drawString("both of your children has been approved! ", 90, 210);
            g.drawString("They are ready to travel here.", 90, 240);
            Game.money-=300;
            g.drawString("NEXT", 380, 310);
            futureStatus=2;
        }
        else if(Game.money<=moneyNeeded && next==0)
        {
            g.setFont(Game.font.deriveFont(22f));
            g.setColor(Color.black);
            g.drawString("Unfortunately your request to sponsor ", 90, 180);
            g.drawString("has been denied due to insufficient", 90, 210);
            g.drawString("money. Try again in 3 months.", 90, 240);
            g.drawString("NEXT", 380, 310);
            futureStatus=0;
        }
        else if(Game.sponsoredFamily.equals("one kid") && Game.money>moneyNeeded+100)
        {
            g.setFont(Game.font.deriveFont(22f));
            g.setColor(Color.black);
            g.drawString("Congratulations! Your request to sponsor ", 90, 180);
            g.drawString("one of your children has been approved! ", 90, 210);
            g.drawString("They are ready to travel here.", 90, 240);
            Game.money-=150;
            g.drawString("NEXT", 380, 310);
            futureStatus=1;
        } else if(next==1)
            Airport(g);
        Game.showMoney(g);
    }

    public void Airport(Graphics g){
        if (airport != null) {
            g.drawImage(airport, 0, 0, this);
        }

        Graphics2D buttons = (Graphics2D) g;

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.setPaint(new Color(255, 255, 255));
        buttons.fillRoundRect(130, 400, 650, 100, 25, 25);
        g.setFont(Game.font.deriveFont(22f));
        g.setColor(Color.black);

        if (player != null) {
            Image teach = player.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, -100, 250, this);
        }
        if (child != null) {
            Image teach = child.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, -50, 250, this);
        }

        if(futureStatus==2){
            g.drawString("Congratulations! You’ve brought over all children, and have applied ", 220, 430);
            g.drawString("for permanent residence. You don’t know what the future will bring,", 220, 460);
            g.drawString("but at least you and your family will face it together.", 220, 490);
            buttons.fillRoundRect(700, 500, 90, 50, 25, 25);
            g.setColor(Color.white);
            g.setFont(Game.font.deriveFont(35f));
            g.drawString("DONE", 715, 535);
        } else if(futureStatus==1){
            g.drawString("You’ve successfully been able to sponsor one of your children,", 220, 430);
            g.drawString("and for this, you are extremely grateful. Perhaps in the future,", 220, 460);
            g.drawString("you will be able to bring over more of your family.", 220, 490);
            buttons.fillRoundRect(700, 500, 90, 50, 25, 25);
            g.setColor(Color.white);
            g.setFont(Game.font.deriveFont(35f));
            g.drawString("DONE", 715, 535);
        } else if(futureStatus==0){
            g.drawString("Unfortunately you didn’t save enough money to be able to sponsor any ", 220, 430);
            g.drawString("of your family. You remain alone with one child in this foreign country.", 220, 460);
            g.drawString("Maybe in the future you will be able to bring over more of your family?", 220, 490);
            buttons.fillRoundRect(700, 500, 90, 50, 25, 25);
            g.setColor(Color.white);
            g.setFont(Game.font.deriveFont(35f));
            g.drawString("DONE", 715, 535);
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
