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
    static String[] sentences = {"Hello Everybody!", "Welcome to Language Class!", "Today we will be learning the language ", "of this country!", "In this country they are very secretive," , "so they communicate in cypher.", "Let's take a test to ensure you ", "are ready to communicate with others:"};
    static String[] fact1 = {"Children, especially older ones, feel the responsibility",
            "to become a 'translator' of sorts for their immigrant parents,",
            "since their impressionable minds can learn the language more quickly,",
            "and are exposed to the culture for a larger fraction of their lives.",
            "As such, the child is at times shifted away from the role of the one being provided for,",
            "forcing them to take responsibility for their parents earlier on",
            "and also exposing them to adult struggles that other children are shielded from.",
            "Children who feel imposed with this responsibility earlier on are at more risk of developing",
            "anxiety, depression, eating disorders and succumbing to substance abuse."};
    static String[] sol1 = {
            "In order to prevent this from taking a toll on children, parents need to",
            "learn to rely on themselves, while providing emotional support for their",
            "children. Parents should also have regular talks with them,",
            "affirming to them that they are safe to behave their age, while giving them",
            "a sense of security."};
    static String[] fact2 = {"Before they've become comfortable with their new country,",
            "the closest thing a child has to their familiar environment is their immigrant parent.",
            "When even this figure of comfort and trust is gone for long periods of time,",
            "the child will feel a sense of loneliness.",
            "Especially if they aren't able to quickly make friends."};
    static String[] sol2 = {
            "A good way to help the child overcome this loneliness is",
            "to help them into the social environment of their new country.",
            "What do kids their age play with?",
            "What are the interests of the kids in this new country?",
            "Introduce them to those."};
    static String[] fact3 = {"Many immigrant children face this issue: they're too ‘foreign’ for their homeland,",
            "but they're too 'exotic' in the country they've immigrated to.",
            "Either way, they can't seem to fit in.",
            "This manifests itself in low self-confidence, becoming less socially active,",
            "and raised anxiety when in an environment where they feel they don't completely belong."};
    static String[] sol3 = {
            "The key to maintaining the child's connection to their culture,",
            "while allowing them to integrate into their new environment,",
            "is to maintain the existence of said culture in the child's daily life,",
            "while not imposing it on them.",
            "Teach them that there is no shame in enjoying their culture."};
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
        g.setFont(Game.font.deriveFont(28f));

        if (bg != null) {
            Image background = bg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            g.drawImage(background, 0, 0, this);
        }
        if (teacher != null) {
            Image teach = teacher.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, -50, 330, this);
        }

        g.setColor(Color.black);

        int xcord = 250;
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