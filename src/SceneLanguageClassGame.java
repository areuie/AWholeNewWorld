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
 * Version 4 - 4h
 * Fixing bugs (took a long time surprisingly)
 * - Alisa
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
    static char dir = ' ';
    static String[] sentences = {"CAN YOU@TRANSLATE@THIS@SENTENCE?"};
    static String guess = "";

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


        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("A"), "left");
        im.put(KeyStroke.getKeyStroke("D"), "right");
        im.put(KeyStroke.getKeyStroke("SPACE"), "edit");

        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");


        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idx - 1 >= 0) {
                    idx--;
                    x -= 25;
                    System.out.println("i tried wuts the idx?" + idx);
                    if (idx - 1 >= 0 && sentences[0].charAt(idx) == ' ') {
                        idx--;
                        x -= 25;
                    }

                    System.out.println("k." + idx);
                }

                System.out.println("left " + idx);
                dir = 'l';
                repaint();
            }
        });

        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idx + 1 < sentences[0].length() - 1) {
                    idx++;
                    x += 25;
                    if (idx + 1 < sentences[0].length() && sentences[0].charAt(idx) == ' ') {
                        idx++;
                        x += 25;
                    }
                }
                System.out.println("right " + idx);
                dir = 'r';
                repaint();
            }
        });

        am.put("edit", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //implement add any key
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

//    /**
//     * This method finds the indexes of characters that start in a new line
//     */
//    void findNewLine() {
//        int idxCount = 0;
//        int count = 0;
//        String[] split = sentences[0].split(" ");
//        for (int i = 0; i < split.length; i++) {
//            idxCount += split[i].length() - 1;
//            if (i - 1 >= 0) idxCount++;
//            if (220 + idxCount * 25 > 450) {
//                newLine[count] = idxCount;
//                count++;
//            }
//        }
//    }

    int previousLine(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '@') return i + 1;
        }
        return 0;
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

        int newLine = 0;
        int xCoord;

        for (int i = 0, xi = 0; i < sentences[0].length() - 1; i++, xi++) { //prints the sentence

            xCoord = 220 + xi * 25;
            if (sentences[0].charAt(i) == '@') {
                System.out.println(sentences[0].charAt(idx) );
                if (sentences[0].charAt(idx) == '@') {
                    //if (x > sentences[0].substring(0, i).length() * 25) {
                    if (dir == 'r' ) {
                        x = 215;
                        y += 100;
                        idx++;
                    } else if (dir == 'l' ) {
                        x = 215;
                        y -= 100;
                        System.out.println("f" + previousLine(sentences[0].substring(0, idx)));
                        idx = previousLine(sentences[0].substring(0, idx));
                    }
                    //}


                }
                xi = -1;
                newLine += 100;
            } else if (sentences[0].charAt(i) == ' '){

            } else { //prints out character and line
                g.setColor(Color.black);
                g.drawString(sentences[0].substring(i, i+1), xCoord, 80 + newLine);
                g.drawLine(xCoord, 85  + newLine, xCoord + 20, 85  + newLine);
                g.setColor(Color.gray);
                if ((sentences[0].charAt(i) - 'A') >= 'A' || (sentences[0].charAt(i) - 'A') <= 'Z') g.drawString((String.valueOf(cypher[(int)(sentences[0].charAt(i) - 'A')])), xCoord, 110 + newLine);
            }
        }

        g.setColor(new Color(161, 200, 240, 60));
        g.fillRoundRect(x, y, 25, 55, 10, 10);
    }

}
