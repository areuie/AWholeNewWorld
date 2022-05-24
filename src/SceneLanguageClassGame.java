/**
 * The SceneLanguageClassGame class is the screen for the language class mini-game.
 *
 * <p>
 * Version 1 - 5h
 * Added BufferedImage
 * Created random cypher key derived from a string sentence
 * Text layout and logic
 * - Alisa
 *
 * Version 2 - 2h
 * Added keyboard input functionality
 * - Alisa
 *
 * Version 3 - 2h
 * Graphics layout on PaintComponent
 * - Lois
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
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;


public class SceneLanguageClassGame extends JPanel {

    private BufferedImage bg;
    char[] cypher;
    static Map<Direction, Boolean> dirMap = new EnumMap<>(Direction.class);

    static int x = 215, y = 55;
    static int idx = 0;
    static String[] sentences = {"CAN YOU TRANSLATE THIS SENTENCE?"};
    static int[] newLine = new int[sentences[0].split(" ").length];

    /**
     * Constructor, creates a random cypher, checks keyboard input, initializes graphics
     */
    public SceneLanguageClassGame() {
        try {
            bg = ImageIO.read(new File("src/img/Desk.png"));
        } catch (IOException ex) { ex.printStackTrace(); }

        cypher = new char[26];
        for (int i = 0; i < 26; i++) {
            boolean occupied = true;
            while (occupied) {
                occupied = false;
                int random = (int) (Math.random() * 26);
                if (cypher[random] != '\u0000') occupied = true;
                else cypher[random] = (char) (i + 'A');
            }
        }
        for (char i: cypher) {
            System.out.println(i);
        }

        findNewLine();

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("A"), "left");
        im.put(KeyStroke.getKeyStroke("D"), "right");
        im.put(KeyStroke.getKeyStroke("space"), "right");

        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");


        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("left " + idx);
                if (idx - 1 >= 0) {
                    idx--;
                    x -= 25;
                    if (idx - 1 >= 0 && sentences[0].charAt(idx) == ' ') {
                        idx--;
                        x -= 25;
                    }
                }
                repaint();
            }
        });

        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right " + idx);
                if (idx + 1 < sentences[0].length()) {
                    idx++;
                    x += 25;
                    if (idx + 1 < sentences[0].length() && sentences[0].charAt(idx) == ' ') {
                        idx++;
                        x += 25;
                    }
                }
                repaint();
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    /**
     * This method finds the indexes of characters that start in a new line
     */
    void findNewLine() {

        int xC, yC = 0;
        int pixelCount = 0;
        int idxCount = 0;
        String[] split = sentences[0].split(" ");
        for (int i = 0; i < split.length; i++) {
            idxCount += split[i].length();
            if (220 + split[i].length() * 25 > 450) {

            } else pixelCount = 0;
            for (int j = 0; j < split[i].length(); j++) {

            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    /**
     * This method paints graphics on the screen.
     * @param g Graphic
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bg != null) { //prints background
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.PLAIN, 24));

        int idx = 0;
        int newLine = 0;
        int xCoord;

        for (int i = 0, xi = 0; i < sentences[0].length() - 1; i++, xi++) { //prints the sentence
            String[] split = sentences[0].split(" ");

            xCoord = (220 + xi * 25);
            if (x < 215)  {
                x = 215;
                y -= 100;
            }
            if (sentences[0].charAt(i) == ' ') {
                if ((220 + (split[idx].length() + i) * 25 + 10) > 450){ //if the word exceeds the paper, go to next line
                    if (x > 450)  {
                        x = 215;
                        y += 100;
                    }
                    newLine += 100;
                    xi = 0;
                    xi--;
                }
                idx++;
            } else { //prints out character and line
                g.setColor(Color.black);
                g.drawString(sentences[0].substring(i, i+1), xCoord, 80 + newLine);
                g.drawLine(xCoord, 85  + newLine, xCoord + 20, 85  + newLine);
                g.setColor(Color.gray);
                g.drawString((String.valueOf(cypher[(int)(sentences[0].charAt(i) - 'A')])), xCoord, 110 + newLine);
            }
        }

        g.setColor(new Color(161, 200, 240, 60));
        g.fillRoundRect(x, y, 25, 55, 10, 10);
    }

}
