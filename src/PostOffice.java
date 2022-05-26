/**
 * The SceneLanguageClass is the screen for the language class.
 *
 * <p>
 * Version 1 - 3h
 * Added BufferedImage, created dialogue image, added graphics to screen
 * - Mona
 * </p>
 *
 *  <p>
 *  Version 2 - 5h
 *  Added interactive conversation where user presses space to continue reading
 *  - Mona
 *  </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.24.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PostOffice extends JPanel {
    private BufferedImage bg;
    private BufferedImage teacher;
    int count = 0;
    static String[] sentences = {"Hello!", "I have received a letter from your family", "Here you go. You can read it then ", "write your own message to send back."};


    /**
     * Constructor, initializes graphics
     */
    PostOffice() {
        try {
            bg = ImageIO.read(new File("src/img/postOfficeBG.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            teacher = ImageIO.read(new File("src/img/pixil-layer-1.png"));
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

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }


    @Override
    protected void paintComponent(Graphics g) {
        Image back = bg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        super.paintComponent(g);
        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }
        if (teacher != null) {
            Image teach = teacher.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, -50, 330, this);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.PLAIN, 24));

        int xcord = 300;
        int ycord = 470;

        if (count < sentences.length) {
            g.setColor(Color.black);
            g.drawString(sentences[count], xcord, ycord);
            g.drawString(sentences[count + 1], xcord, ycord + 40);
            count++;
        } else if (count == sentences.length) {
            Game.gameState =6;
        }
    }
}
