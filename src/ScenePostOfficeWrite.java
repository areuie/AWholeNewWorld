/**
 * The PostOfficeWrite class is for writing a letter at the post office
 *
 * <h2>Draft 2</h2>
 * <p>
 * Version 1 - 2h
 * Designed background and buttons
 * -Mona
 *
 * Version 2 - 5h
 * Created Game and buttons
 * -Mona
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScenePostOfficeWrite extends JPanel {

    /**This variable stores the background Image*/
    private BufferedImage bg;
    /**This variable stores the button for how many times user has interacted*/
    int nextButton=0;

    /**
     * Constructor
     */
    ScenePostOfficeWrite() {
        try {
            bg = ImageIO.read(new File("src/img/letterWriting.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /**
         * Checks if a user pressed the screen and which button it reacted with
         */
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 335 && e.getX() < 480 && e.getY() > 500 && e.getY() < 555 && nextButton==0)
                {
                    nextButton = 1;
                    repaint();
                }

                else if (e.getX() > 260 && e.getX() < 560 && e.getY() > 220 && e.getY() < 280 && nextButton==1)
                {
                    nextButton=2;
                    repaint();
                }

                else if (e.getX() > 260 && e.getX() < 560 && e.getY() > 340 && e.getY() < 420 && nextButton==1)
                {
                    nextButton=3;
                    repaint();
                }
                else if (e.getX() > 260 && e.getX() < 560 && e.getY() > 460 && e.getY() < 540 && nextButton==1){

                    nextButton=4;
                    repaint();
                }
                else if (e.getX() > 335 && e.getX() < 480 && e.getY() > 500 && e.getY() < 555 && nextButton==5){

                    nextButton=6;
                    repaint();
                }
                else if (nextButton==6)
                {
                    System.out.println("done");
                    Game.gameState=9;
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
        g.setFont(Game.font.deriveFont(28f));

        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }

        System.out.println(nextButton);
        if (nextButton == 0) {
            FamilyLetter(g);
        } if (nextButton==1) {
            LetterOptions(g);
        } else if(nextButton==2){
            RacistComment(g);
            nextButton=5;
        } else if(nextButton==3){
            LanguageBarrier(g);
            nextButton=5;
        } else if(nextButton==4){
            FinancialIssues(g);
            nextButton=5;
        } else if(nextButton==6){
            MoneyOptions(g);
        }
        Game.showMoney(g);
    }


    /**
     * This method writes the letter from the family
     * @param g Graphic
     */
    public void FamilyLetter(Graphics g){
        Graphics2D next = (Graphics2D) g;

        next.setPaint(new Color(200, 90, 90));
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        next.setRenderingHints(button);

        g.drawString("From: Your Family", 290, 115);

        g.setFont(new Font("Tahoma", Font.PLAIN, 17));
        int x = 260;
        g.drawString("I know it might be difficult right now", x, 170);
        g.drawString("living in this new environment, but ", x, 200);
        g.drawString("always remember to save your ", x, 230);
        g.drawString("money and don’t over spend on", x, 260);
        g.drawString("unessesary items. Make sure to ", x, 290);
        g.drawString("make valuable connections in the ", x, 320);
        g.drawString("workplace, so you can make more ", x, 350);
        g.drawString("money in the future. ", x, 380);
        g.drawString("Sincerely", x, 430);
        g.drawString("-Your loved ones", x, 460);

        g.setFont(new Font("Tahoma", Font.PLAIN, 30));
        next.fillRoundRect(335, 480, 150, 60, 25, 25);
        g.setColor(Color.black);
        g.drawString("NEXT", 375, 520);
    }

    /**
     * This method gives the user buttons for 3 different options on the letter
     * @param g Graphic
     */
    public void LetterOptions(Graphics g){
        Graphics2D buttons = (Graphics2D) g;

        buttons.setPaint(new Color(150, 150, 150));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.fillRoundRect(260, 220, 300, 60, 25, 25);
        buttons.fillRoundRect(260, 340, 300, 60, 25, 25);
        buttons.fillRoundRect(260, 460, 300, 60, 25, 25);


        g.setColor(new Color(200, 90, 90));
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));

        g.drawString("To: Your Family", 290, 115);

        g.setFont(new Font("Tahoma", Font.PLAIN, 17));
        g.drawString("Write about...", 250, 185);

        g.drawString("The racist comment on the street", 280, 255);
        g.drawString("The co-worker language barrier", 280, 375);
        g.drawString("Financial Issues", 280, 495);
    }

    /**
     * This method writes a letter based on the racist comment on the street
     * @param g Graphic
     */
    public void RacistComment(Graphics g) {
        Graphics2D next = (Graphics2D) g;
        next.setPaint(new Color(200, 90, 90));
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        next.setRenderingHints(button);

        g.drawString("To: Your Family", 290, 115);

        g.setFont(new Font("Tahoma", Font.PLAIN, 17));
        int x = 260;

        next.setPaint(new Color(200, 90, 90));

        g.drawString("Hey Family! I'm really enjoying myself ", x, 170);
        g.drawString("here, but a couple days ago, someone  ", x, 200);
        g.drawString("yelled a racist comment at me, when I ", x, 230);
        g.drawString("was on my way home from language ", x, 260);
        g.drawString("class. I was taken aback, because  ", x, 290);
        g.drawString("everyone has been so kind to me ", x, 320);
        g.drawString("since I've arrived here. Anyways, ", x, 350);
        g.drawString("hope you are doing well and I can't ", x, 380);
        g.drawString("wait to see you guys soon! ", x, 410);
        g.drawString("Sincerely", x, 440);
        g.drawString("-", x, 460);

        g.setFont(new Font("Tahoma", Font.PLAIN, 30));
        next.fillRoundRect(335, 480, 150, 60, 25, 25);
        g.setColor(Color.black);
        g.drawString("SEND", 375, 520);
    }

    /**
     * This method writes a letter based on the language barrier issue at work
     */
    public void LanguageBarrier(Graphics g) {
        Graphics2D next = (Graphics2D) g;
        next.setPaint(new Color(200, 90, 90));
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        next.setRenderingHints(button);

        g.drawString("To: Your Family", 290, 115);

        g.setFont(new Font("Tahoma", Font.PLAIN, 17));
        int x = 260;

        next.setPaint(new Color(200, 90, 90));

        g.drawString("Hey Family! I'm really enjoying myself ", x, 170);
        g.drawString("here, but I'm really struggling at work. ", x, 200);
        g.drawString("I still have a very thick accent when I ", x, 230);
        g.drawString("speak, so it's been really hard to ", x, 260);
        g.drawString("communicate with my co-workers.", x, 290);
        g.drawString("Anyways, hope you are doing well  ", x, 320);
        g.drawString("and I can't wait to see you guys soon!", x, 350);
        g.drawString("Sincerely ", x, 380);
        g.drawString("-", x, 410);

        g.setFont(new Font("Tahoma", Font.PLAIN, 30));
        next.fillRoundRect(335, 480, 150, 60, 25, 25);
        g.setColor(Color.black);
        g.drawString("SEND", 375, 520);
    }

    /**
     * This method writes a letter based on the financial issues
     */
    public void FinancialIssues(Graphics g) {
        Graphics2D next = (Graphics2D) g;
        next.setPaint(new Color(200, 90, 90));
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        next.setRenderingHints(button);

        g.drawString("To: Your Family", 290, 115);

        g.setFont(new Font("Tahoma", Font.PLAIN, 17));
        int x = 260;

        next.setPaint(new Color(200, 90, 90));

        g.drawString("Hey Family! I'm really enjoying myself ", x, 170);
        g.drawString("here, but I'm really struggling. It's ", x, 200);
        g.drawString("been very difficult making money so ", x, 230);
        g.drawString("far, and rent is getting more expensive.", x, 260);
        g.drawString("I live in a very small apartment in a ", x, 290);
        g.drawString("bad area so I'm starting to save up for", x, 320);
        g.drawString("a new place. Hope to see you all soon!", x, 350);
        g.drawString("Sincerely ", x, 380);
        g.drawString("-", x, 410);

        g.setFont(new Font("Tahoma", Font.PLAIN, 30));
        next.fillRoundRect(335, 480, 150, 60, 25, 25);
        g.setColor(Color.black);
        g.drawString("SEND", 375, 520);
    }

    /**
     * This method gives the user buttons for 3 different options on the letter
     */
    public void MoneyOptions(Graphics g) {
        Graphics2D buttons = (Graphics2D) g;

        buttons.setPaint(new Color(150, 150, 150));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.fillRoundRect(260, 220, 300, 60, 25, 25);
        buttons.fillRoundRect(260, 340, 300, 60, 25, 25);
        buttons.fillRoundRect(260, 460, 300, 60, 25, 25);


        g.setColor(new Color(200, 90, 90));
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));

        g.drawString("To: Your Family", 290, 115);

        g.setFont(new Font("Tahoma", Font.PLAIN, 17));
        g.drawString("How much money would you like to send?", 250, 185);

        g.drawString("$0", 280, 255);
        g.drawString("$100", 280, 375);
        g.drawString("$"+Game.money, 280, 495);
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