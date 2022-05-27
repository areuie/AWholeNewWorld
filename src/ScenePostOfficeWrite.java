/**
 * The PostOfficeWrite class is for writing a letter at the post office
 *
 * <p>
 * Version 1 - 2h
 * Designed background and buttons
 * -Mona
 *
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.20.22
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
    private BufferedImage bg;
    int nextButton=0;

    ScenePostOfficeWrite() {
        try {
            bg = ImageIO.read(new File("src/img/letterWriting.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 335 && e.getX() < 500 && e.getY() > 485 && e.getY() < 560)//if they press play button they are taken to the language class dialogue scene
                {
                    nextButton = 1;
                    System.out.println("yay");
                    repaint();
                }

                if (e.getX() > 260 && e.getX() < 220 && e.getY() > 560 && e.getY() < 280 && nextButton==1)//if they press play button they are taken to the language class dialogue scene
                {
                    System.out.println("oh");
                    repaint();
                }

                if (e.getX() > 335 && e.getX() < 500 && e.getY() > 485 && e.getY() < 560)//if they press play button they are taken to the language class dialogue scene
                {
                    System.out.println("lol");
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(Game.font.deriveFont(28f));

        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }

        if (nextButton == 0) {
            FamilyLetter(g);
        } else if (nextButton == 1) {
            LetterOptions(g);
        }
        Game.showMoney(g);
    }


    public void FamilyLetter(Graphics g){
        Graphics2D next = (Graphics2D) g;

        next.setPaint(new Color(200, 90, 90));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        next.setRenderingHints(button);

        g.drawString("From: Your Family", 290, 90);

        int x = 240;
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

        next.fillRoundRect(335, 500, 150, 60, 25, 25);
        g.setColor(Color.black);
        g.drawString("NEXT", 375, 540);

        if(nextButton==0){
            repaint();
        }
        else if(nextButton==1){
            paintComponent(g);
        }

    }

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

        g.setColor(Color.black);

        g.drawString("To: Your Family", 300, 90);

        g.setFont(new Font("Tahoma", Font.PLAIN, 20));
        g.drawString("Write about...", 250, 170);

        g.setFont(new Font("Tahoma", Font.PLAIN, 18));
        g.drawString("The racist comment on the street", 280, 255);
        g.drawString("The co-worker language barrier", 280, 375);
        g.drawString("Financial Issues", 280, 495);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

}
