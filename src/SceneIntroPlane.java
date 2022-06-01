/**
 * The SceneIntroPlane is the screen for the introduction scene.
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.27.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneIntroPlane extends JPanel {
    private BufferedImage bg;
    private BufferedImage plane;
    int count = 0, planeX = -100, planeY = 200;
    boolean almostFinished = false;
    static String[] sentences = {"Welcome to your new country.", "We hope you'll find everyone wonderful.", "Remember to study English hard,", " make new friends, ", "and enjoy your stay to the fullest." , 
    "We've already made accomodations for you ", "by giving you your first house! Though ", "the rent is still yours to pay.", "Another thing to keep in mind is your family.", "Don't fail here.", "They're counting on you."};

    Timer timer1 = new Timer(100, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(almostFinished) {
                if (planeX<=800 || planeY >=0){
                    planeX +=7;
                    planeY +=2;
                }
            }else{
                planeX +=2;
                planeY +=1;
            }
        }
    });

    /**
     * Constructor, initializes graphics
     */
    SceneIntroPlane() {
        try {
            bg = ImageIO.read(new File("src/img/SkyBG.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            plane = ImageIO.read(new File("src/img/plane.png"));
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
     * This method determines the dimensions of the panel
     * @return The dimensions of the panel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    /**
     * This method paints the graphics of the panel
     * @param g Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(Game.font.deriveFont(25f));

        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }
        if (plane != null) {
            Image airPlane = plane.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(airPlane, planeX, planeY, this);
        }

        g.setColor(Color.black);

        int xcord = 300;
        int ycord = 470;

        if (count < sentences.length) {
            g.setColor(Color.black);
            g.drawString(sentences[count], xcord, ycord);
            g.drawString(sentences[count + 1], xcord, ycord + 40);
            count++;
        } else if (count == sentences.length) {
            Game.gameState =11;
            count++;
        }
        Game.showMoney(g);
    }
}
