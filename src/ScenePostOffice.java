/**
 * The ScenePostOffice is the screen for the post office
 * <p>
 * Version 1 - 3h
 * Added BufferedImage, created dialogue image, added graphics to screen
 * - Mona
 *
 *  Version 2 - 5h
 *  Added interactive conversation where user presses space to continue reading
 *  - Mona
 *
 *  Version 2 - 2h
 *  Edited messages to tailor it to the child
 *  - Mona
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 06.12.22
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

public class ScenePostOffice extends JPanel {

    /**This variable stores the background image*/
    private BufferedImage bg, textBox;
    /**This variable stores the image for the post office person*/
    private BufferedImage person;
    /**This variable counts the number of it runs through the if statements*/
    int count = 0;
    /**This array stores all the sentences in the convo*/
    String[] sentences;
    /**This array stores the stage at which the user is at so it displays the correct post office*/
    int stage;
    /**This variable stores the array for all the dialogue that should be printed on the screen*/
    static String[] sentences1 = {"Hello little one!", "Would you like to send a letter back", "to your family abroad?"};
    /**This variable stores the array for all the dialogue that should be printed on the screen*/
    static String[] sentences2 = {"Hello little one!", "I have received a letter from your family", "Here you go. You can read it then "};


    /**
     * Constructor, initializes graphics
     */
    ScenePostOffice(int stage) {
        try {
            bg = ImageIO.read(new File("src/img/PostOfficeBGText.png"));
            person = ImageIO.read(new File("src/img/pixil-layer-1.png"));
            textBox = ImageIO.read(new File("src/img/textBox.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        this.stage = stage;

        if (stage == 1) sentences = sentences1;
        else if (stage == 2) sentences = sentences2;

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
        g.setFont(Game.font.deriveFont(30f));
        Image back = bg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);

        if (bg != null) {
            g.drawImage(back, 0, 0, this);
            g.drawImage(textBox, 200, 500, this);
        }
        Image textBox1 = textBox.getScaledInstance(textBox.getWidth() * 2, textBox.getHeight() * 2, Image.SCALE_DEFAULT);
        g.drawImage(textBox1,0, 0, this);

        if (person != null) {
            Image teach = person.getScaledInstance(person.getWidth()*12, person.getHeight()*12, Image.SCALE_DEFAULT);
            g.drawImage(teach, -80, 320, this);
        }

        g.setColor(Color.black);

        int xcord = 230;
        int ycord = 480;

        if (count < sentences.length) {
            g.setColor(Color.black);
            g.drawString(sentences[count], xcord, ycord);
            if (count + 1 < sentences.length && count != 0) {
                g.drawString(sentences[count + 1], xcord, ycord + 40);
                count++;
            }
        } else if (count >= sentences.length) {
            if (stage == 1) Game.gameState = 8;
            if (stage == 2) Game.gameState = -8;
        }
        Game.showMoney(g);
    }
}