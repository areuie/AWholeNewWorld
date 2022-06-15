/**
 * The SceneIntroPlane is the screen for the introduction scene.
 *
 * <p>
 *     Version 1 - 8h (Including drawing graphics)
 *     Added keyboard input
 *     Added timers
 *     Added graphics
 *     Drew graphics
 *     - Lois
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 06.14.22
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
    private BufferedImage plane, textBox;
    int count = 0, planeX = -150, planeY = 50;
    boolean almostFinished = false;
    static String[] sentences = {"Welcome to your new country.", "We hope you'll find everyone wonderful.", "Remember to study English hard,", " make new friends, ", "and enjoy your stay to the fullest." , 
    "You're lucky that you've made plans for yourself", "by giving renting your first house! Though ",
    "the rent might prove a problem.", "Another thing to keep in mind is your family.", "Don't fail here.", "They're counting on you."};

    Timer timer1 = new Timer(50, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(almostFinished) {
                if (planeX<=821 || planeY >=0){
                    planeX +=20;
                    planeY -=4 ;
                    System.out.println("Almost finished!");
                }
            }else{
                planeX +=2;
                planeY -=1;
                System.out.println("Moving..");
            }
            repaint();
        }
    });

    /**
     * Constructor, initializes graphics
     */
    SceneIntroPlane() {
        try {
            bg = ImageIO.read(new File("src/img/SkyBG.png"));
            textBox = ImageIO.read(new File("src/img/textBox.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            plane = ImageIO.read(new File("src/img/airplane.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        timer1.start();

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
            Image background = bg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            g.drawImage(background, 0, 0, this);
            Image airPlane = plane.getScaledInstance(600, 600, Image.SCALE_DEFAULT);
            g.drawImage(airPlane, planeX, planeY, this);
            Image textBox1 = textBox.getScaledInstance(textBox.getWidth() * 2, textBox.getHeight() * 2, Image.SCALE_DEFAULT);
            g.drawImage(textBox1,0, 0, this);
        }

        g.setColor(Color.black);

        int xcord = 200;
        int ycord = 470;

        if (count < sentences.length) {
            g.setColor(Color.black);
            g.drawString(sentences[count], xcord, ycord);
            if(count == sentences.length - 2) almostFinished = true;
        }
        if (count >= sentences.length-1 && planeX>=800) {
            Game.gameState =12;
            count++;
        }
        System.out.println("Current count: " + count + " and current planeX: " + planeX + " Current lenght array is: " + sentences.length);

        Game.showMoney(g);
    }
}
