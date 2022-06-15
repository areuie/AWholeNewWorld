/**
 * The SceneMenu class is the screen for the menu.
 * <h3> Draft 1 </h3>
 * <p>
 * Version 1 - 2h
 * Found the coordinate bounds for the buttons
 * Designed background
 * - Alisa
 * <p>
 * Version 2 - 3h
 * Added mouse listener
 * Created bounds for the buttons
 * Graphics layout
 * - Mona
 * <p>
 * Version 3 - 30 min
 * Fixed bugs
 * - Lois
 *
 * </p>
 *
 * <h3> Draft 3 </h3>
 * <p>
 * Version 4 - 1.5h
 * Redrew main screen pixel art
 * - Alisa
 * </p>
 *
 * <h3> Final </h3>
 * <p>
 * Version 5 - 2h
 * Added fade in icon before game start
 * - Mona
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneMenu extends JPanel implements ActionListener, Runnable{
    /**
     * This variable stores the background image
     */
    private BufferedImage bg;
    private BufferedImage icon;
    int state = 0;
    int transparency=0;

    /**
     * The constructor of the screen
     */
    SceneMenu() {
        try {
            bg = ImageIO.read(new File("src/img/bg2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            icon = ImageIO.read(new File("src/img/icon.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        timer1.start();

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 120 && e.getX() < 390 && e.getY() > 380 && e.getY() < 460)//if they press play button they are taken to the language class dialogue scene
                {
                    repaint();
                    Game.gameState = 15;
                    System.out.println("PLAY");

                } else if (e.getX() > 408 && e.getX() < 680 && e.getY() > 380 && e.getY() < 460)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 2;
                    System.out.println("INSTRUCTIONS");
                } else if (e.getX() > 120 && e.getX() < 390 && e.getY() > 480 && e.getY() < 560)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 3;
                    System.out.println("HIGHSCORES");
                } else if (e.getX() > 408 && e.getX() < 680 && e.getY() > 480 && e.getY() < 560)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 4;
                    System.out.println("EXIT");
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
        if (state == 0 && !Game.instructions) {
            if (icon != null) {
                Image teach = icon.getScaledInstance(756, 525, Image.SCALE_DEFAULT);
                g.drawImage(teach, 130, 70, this);
            }
            Graphics2D buttons = (Graphics2D) g;

            RenderingHints button = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            buttons.setRenderingHints(button);

            buttons.setPaint(new Color(0, 0, 0, transparency));
            buttons.fillRect(0, 0, 800, 600);
        } else {
            if (bg != null) {
                int x = (getWidth() - bg.getWidth()) / 2;
                int y = (getHeight() - bg.getHeight()) / 2;
                g.drawImage(bg, x, y, this);
            }
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

    /**
     * This method fades the image out
     * @param e ActionEvent
     */
    Timer timer1 = new Timer(5, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(transparency>249){
                state=1;
                repaint();
            }
            else {
                transparency++;
                repaint();
            }
        }
    });

    @Override
    public void run() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}