/**
 * The SceneLanguageClass is the screen for the language class.
 *
 * <h3>Draft 1</h3>
 * <p>
 * Version 1 - 3h
 * Added BufferedImage, created dialogue image, added graphics to screen
 * - Mona
 * </p>
 *
 * <h3>Draft 2</h3>
 *  <p>
 *  Version 2 - 5h
 *  Added interactive conversation where user presses space to continue reading
 *  - Mona
 *  </p>
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
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneLanguageClass extends JPanel {
    private BufferedImage bg;
    private BufferedImage teacher;
    int count = 0;
    static String[] sentences = {
            "Hello Everybody!",
            "Welcome to ESL (English as a Second Language).",
            "Since many of you guys have just landed in this new",
            "environment, we're going to be going over adversities",
            "adversities that you may face as an child immigrant",
            "so that you're prepared for when they arise.",
            "There are 3 main topics",
            "we'll be discussing in this class.",
            "1. Preparing to carry the burden of being",
            "the sole translator of the household",
            "2. Loneliness due to certain factors",
            "",
            "3. Figuring out your place in cultural identity",
            ""
    };

    /**
     * Constructor, initializes graphics
     */
    SceneLanguageClass() {
        try {
            bg = ImageIO.read(new File("src/img/TeacherBG.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            teacher = ImageIO.read(new File("src/img/pixil-layer-3.png"));
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
        g.setFont(Game.font.deriveFont(27f));

        if (bg != null) {
            Image background = bg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            g.drawImage(background, 0, 0, this);
        }
        if (teacher != null) {
            Image teach = teacher.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, -120, 330, this);
        }

        g.setColor(Color.black);

        int xcord = 160;
        int ycord = 470;

        if (count < sentences.length) {
            g.setColor(Color.black);
            g.drawString(sentences[count], xcord, ycord);
            if (count + 1 < sentences.length) {
                g.drawString(sentences[count + 1], xcord, ycord + 40);
            }
            count++;
        } else if (count == sentences.length) {
            Game.gameState =6;
            count++;
        }
        Game.showMoney(g);
    }
}