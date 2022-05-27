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

public class PostOfficeWrite extends JPanel {
    private BufferedImage bg;
    int nextButton=0;

    PostOfficeWrite() {
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
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }
        Graphics2D next = (Graphics2D) g;

        next.setPaint(new Color(200, 90, 90));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        next.setRenderingHints(button);

        next.fillRoundRect(335, 500, 150, 60, 25, 25);
        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));
        g.drawString("NEXT", 375, 540);

        if(nextButton==0){
            FamilyLetter(g);
        }
        else if(nextButton==1){
            paintComponent(g);
            LetterOptions(g);
        }
    }

    public void FamilyLetter(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.PLAIN, 30));
        g.drawString("From: Your Family", 290, 90);

        g.setFont(new Font("Tahoma", Font.PLAIN, 20));
        g.drawString("I know it might be difficult right now", 250, 170);
        g.drawString("living in this new environment, but ", 250, 200);
        g.drawString("always remember to save your ", 250, 230);
        g.drawString("money and don’t over spend on", 250, 260);
        g.drawString("unessesary items. Make sure to ", 250, 290);
        g.drawString("make valuable connections in the ", 250, 320);
        g.drawString("workplace, so you can make more ", 250, 350);
        g.drawString("money in the future. ", 250, 380);
        g.drawString("Sincerely", 250, 430);
        g.drawString("-Your loved ones", 250, 460);
    }
    public void LetterOptions(Graphics g){
        Graphics2D buttons = (Graphics2D) g;

        buttons.setPaint(new Color(200, 90, 90));

        RenderingHints button = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        buttons.setRenderingHints(button);

        buttons.fillRoundRect(250, 20, 70, 60, 25, 25);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

}
