/**
 * The SceneLanguageClassGame class is the screen for the language class mini-game.
 *
 * <h3>Draft 1</h3>
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
 * </p>
 *
 * <h3>Draft 2</h3>
 * <p>
 * Version 4 - 4h
 * Fixing logical bugs and graphical bugs
 * - Alisa
 *
 * Version 5 - 2.5h
 * Added alphabet input (a,b,c)
 * Finished cypher game
 * Changed font
 * - Alisa
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 06.03.22
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class SceneLanguageClassGame extends JPanel {

    /**
     * This variable is the background of the panel
     */
    private BufferedImage bg;
    /**
     * These variables control the x and y coordinates of the letter selector
     */
    static int x = 205, y = 55;
    /**
     * This variable controls the index of the letter selected
     */
    static int idx = 0;
    /**
     * This variable controls the direction of where the letter selector is going towards (left/right/neither)
     */
    static char dir = ' ';
    int prompt = 0;
    int sentencesIdx = 0;
    boolean stage = false;//false is prompt, true is game
    /**
     * This variable stores the answer key for the sentence to be decyphered
     */
    static String[] sentences = {
            "I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
            "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
            "I WILL@TAKE INITIATIVE AND@TRY TO MAKE@FRIENDS AT@SCHOOL.",
            "I FEEL LIKE@AN OUTSIDER SO@I WILL KEEP@TO MYSELF@AT SCHOOL.",
    };
    static String[][] prompts = {
            {       "Scenario: Your parent puts on too",
                    "much burden on yourself at home."
            },
            {       "Scenario: You feel lonely because",
                    "of your separated family and",
                    "lack of school friends."
            }
    };
    /**
     * This variable stores the random cypher of the string
     */
    char[] cypher;
    /**
     * This variable stores the letters that the player guesses
     */
    char[] userGuess;
    /**
     * This variable stores the current letter that the player pressed
     */
    static char letter = ' ';

    /**
     * Constructor, creates a random cypher, checks keyboard input, initializes graphics
     */
    public SceneLanguageClassGame() {
        try {
            bg = ImageIO.read(new File("src/img/Desk.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        userGuess = new char[sentences[sentencesIdx].length()];
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
        for (char i : cypher) {
            System.out.println(i);
        }

        randomizeGivenChars();

        addMouseListener(new MouseAdapter() { //menu
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 250 && e.getX() < 550 && e.getY() > 300 && e.getY() < 350)//if they press yes they are taken to the scene
                {
                    System.out.println("yess!");
                    stage = true;
                    reset();
                     repaint();
                } else if (e.getX() > 250 && e.getX() < 550 && e.getY() > 370 && e.getY() < 420) {//if they press no, they continue on
                    System.out.println("noo!");
                    stage = true;
                    sentencesIdx++;
                    reset();
                    repaint();
                }
            }
        });

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");

        //keyb
        im.put(KeyStroke.getKeyStroke("A"), "A");
        im.put(KeyStroke.getKeyStroke("B"), "B");
        im.put(KeyStroke.getKeyStroke("C"), "C");
        im.put(KeyStroke.getKeyStroke("D"), "D");
        im.put(KeyStroke.getKeyStroke("E"), "E");
        im.put(KeyStroke.getKeyStroke("F"), "F");
        im.put(KeyStroke.getKeyStroke("G"), "G");
        im.put(KeyStroke.getKeyStroke("H"), "H");
        im.put(KeyStroke.getKeyStroke("I"), "I");
        im.put(KeyStroke.getKeyStroke("J"), "J");
        im.put(KeyStroke.getKeyStroke("K"), "K");
        im.put(KeyStroke.getKeyStroke("L"), "L");
        im.put(KeyStroke.getKeyStroke("M"), "M");
        im.put(KeyStroke.getKeyStroke("N"), "N");
        im.put(KeyStroke.getKeyStroke("O"), "O");
        im.put(KeyStroke.getKeyStroke("P"), "P");
        im.put(KeyStroke.getKeyStroke("Q"), "Q");
        im.put(KeyStroke.getKeyStroke("R"), "R");
        im.put(KeyStroke.getKeyStroke("S"), "S");
        im.put(KeyStroke.getKeyStroke("T"), "T");
        im.put(KeyStroke.getKeyStroke("U"), "U");
        im.put(KeyStroke.getKeyStroke("V"), "V");
        im.put(KeyStroke.getKeyStroke("W"), "W");
        im.put(KeyStroke.getKeyStroke("X"), "X");
        im.put(KeyStroke.getKeyStroke("Y"), "Y");
        im.put(KeyStroke.getKeyStroke("Z"), "Z");

        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ;
                if (idx - 1 >= 0) {
                    idx--;
                    x -= 25;
                    System.out.println("i tried wuts the idx?" + idx);
                    if (idx - 1 >= 0 && sentences[sentencesIdx].charAt(idx) == ' ') {
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
                if (idx + 1 < sentences[sentencesIdx].length() - 1) {
                    idx++;
                    x += 25;
                    if (idx + 1 < sentences[sentencesIdx].length() && sentences[sentencesIdx].charAt(idx) == ' ') {
                        idx++;
                        x += 25;
                    }
                }
                System.out.println("right " + idx);
                dir = 'r';
                repaint();
            }
        });

        //hi!
        am.put("A", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'A';
                repaint();
            }
        });
        am.put("B", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'B';
                repaint();
            }
        });
        am.put("C", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'C';
                repaint();
            }
        });
        am.put("D", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'D';
                repaint();
            }
        });
        am.put("E", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'E';
                repaint();
            }
        });
        am.put("F", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'F';
                repaint();
            }
        });
        am.put("G", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'G';
                repaint();
            }
        });
        am.put("H", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'H';
                repaint();
            }
        });
        am.put("I", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'I';
                repaint();
            }
        });
        am.put("J", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'J';
                repaint();
            }
        });
        am.put("K", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'K';
                repaint();
            }
        });
        am.put("L", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'L';
                repaint();
            }
        });
        am.put("M", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'M';
                repaint();
            }
        });
        am.put("N", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'N';
                repaint();
            }
        });
        am.put("O", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'O';
                repaint();
            }
        });
        am.put("P", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'P';
                repaint();
            }
        });
        am.put("Q", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'Q';
                repaint();
            }
        });
        am.put("R", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'R';
                repaint();
            }
        });
        am.put("S", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'S';
                repaint();
            }
        });
        am.put("T", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'T';
                repaint();
            }
        });
        am.put("U", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'U';
                repaint();
            }
        });
        am.put("V", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'V';
                repaint();
            }
        });
        am.put("W", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'W';
                repaint();
            }
        });
        am.put("X", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'X';
                repaint();
            }
        });
        am.put("Y", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'Y';
                repaint();
            }
        });
        am.put("Z", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letter = 'Z';
                repaint();
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    private void checkCorrect() {
        boolean same = true;
        for (int i = 0; i < sentences[sentencesIdx].length(); i++) {
            if (sentences[sentencesIdx].charAt(i) != userGuess[i]) same = false;
        }
        if (same) {
            stage = false;
            prompt++;
            sentencesIdx = prompt * 2;
            if (prompt >= prompts.length) Game.gameState = 12;
        }
    }

    private void reset() {
        userGuess = new char[sentences[sentencesIdx].length()];
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
        for (char i : cypher) {
            System.out.println(i);
        }

        randomizeGivenChars();
    }

    private void fillInSimilarLetters(char c) {
        for (int i = 0; i < userGuess.length; i++) {
            System.out.println((sentences[sentencesIdx].charAt(idx) - 'A'));
            if ((sentences[sentencesIdx].charAt(idx) - 'A') >= 0 && (sentences[sentencesIdx].charAt(idx) - 'A') <= 26 &&
                    (sentences[sentencesIdx].charAt(i) - 'A') >= 0 && (sentences[sentencesIdx].charAt(i) - 'A') <= 26) {
                System.out.println("---------------------" + (cypher[(int) (sentences[sentencesIdx].charAt(idx) - 'A')]));
                if (cypher[(int) (sentences[sentencesIdx].charAt(idx) - 'A')] == (cypher[(int) (sentences[sentencesIdx].charAt(i) - 'A')])) {
                    userGuess[i] = c;
                }
            }
        }
        repaint();
    }

        private void randomizeGivenChars () {
            for (int i = 0; i < sentences[sentencesIdx].length(); i++) {
                int random = (int) (Math.random() * 100);

                if (i == 0 || i == sentences[sentencesIdx].length() || i > 1 && (sentences[sentencesIdx].charAt(i - 1) == '@' || sentences[sentencesIdx].charAt(i - 1) == ' ')) {
                    userGuess[i] = sentences[sentencesIdx].charAt(i);
                } else if (i < sentences[sentencesIdx].length() - 1 && (sentences[sentencesIdx].charAt(i + 1) == '@' || sentences[sentencesIdx].charAt(i + 1) == ' ')) {
                    userGuess[i] = sentences[sentencesIdx].charAt(i);
                } else if (sentences[sentencesIdx].charAt(i) == '@') {
                    userGuess[i] = '@';
                } else if (sentences[sentencesIdx].charAt(i) == ' ') {
                    userGuess[i] = ' ';
                } else if (sentences[sentencesIdx].charAt(i) == '.') {
                    userGuess[i] = '.';
                } else if (sentences[sentencesIdx].charAt(i) == '?') {
                    userGuess[i] = '?';
                } else if (random > 85) {
                    userGuess[i] = sentences[sentencesIdx].charAt(i);
                } else userGuess[i] = ' ';
            }
        }

//    /**
//     * This method finds the indexes of characters that start in a new line
//     */
//    void findNewLine() {
//        int idxCount = 0;
//        int count = 0;
//        String[] split = sentences[sentencesIdx.split(" ");
//        for (int i = 0; i < split.length; i++) {
//            idxCount += split[i].length() - 1;
//            if (i - 1 >= 0) idxCount++;
//            if (220 + idxCount * 25 > 450) {
//                newLine[count] = idxCount;
//                count++;
//            }
//        }
//    }

        /**
         * This method checks where the index should be if the user goes back a line
         * @param str
         * @return New selected letter index
         */
        int previousLine (String str){
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == '@') return i + 1;
            }
            return 0;
        }

        /**
         * This method determines the dimensions of the panel
         * @return The dimensions of the panel
         */
        @Override
        public Dimension getPreferredSize () {
            return new Dimension(800, 600);
        }

        /**
         * This method paints graphics on the screen.
         * @param g Graphic
         */
        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            g.setFont(Game.font.deriveFont(28f));

            if (bg != null) { //prints background
                int x = (getWidth() - bg.getWidth()) / 2 - 30;
                int y = (getHeight() - bg.getHeight()) / 2 - 50;
                Image background = bg.getScaledInstance(880 , 660, Image.SCALE_DEFAULT);
                g.drawImage(background, x, y, this);
            }

            g.setColor(Color.black);

            if (letter != ' ') {
                fillInSimilarLetters(letter);
                userGuess[idx] = letter;
            }
            letter = ' ';
            if (!stage) {
                g.setColor(Color.black);
                for (int i = 0; i < prompts[prompt].length; i++) {
                    g.drawString(prompts[prompt][i], 205, 80 + i * 35);
                }
                Graphics2D buttons = (Graphics2D) g;

                RenderingHints button = new RenderingHints(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                buttons.setRenderingHints(button);

                buttons.setPaint(new Color(150, 150, 150));
                buttons.fillRoundRect(250, 300, 300, 50, 25, 25);
                buttons.fillRoundRect(250, 370, 300, 50, 25, 25);

                g.setColor(Color.black);
                g.setFont(Game.font.deriveFont(25f));
                g.drawString("Yes", 380, 335);
                g.drawString("No", 380, 405);
            }
            else if (stage) {
                int newLine = 0;
                int xCoord;

                for (int i = 0, xi = 0; i < sentences[sentencesIdx].length() - 1; i++, xi++) { //prints the sentence

                    xCoord = 210 + xi * 25;
                    if (sentences[sentencesIdx].charAt(i) == '@') {
                        System.out.println(sentences[sentencesIdx].charAt(idx));
                        if (sentences[sentencesIdx].charAt(idx) == '@') {
                            //if (x > sentences[sentencesIdx.substring(0, i).length() * 25) {
                            if (dir == 'r') {
                                x = 205;
                                y += 100;
                                idx++;
                            } else if (dir == 'l') {
                                x = 205;
                                y -= 100;
                                System.out.println("f" + previousLine(sentences[sentencesIdx].substring(0, idx)));
                                idx = previousLine(sentences[sentencesIdx].substring(0, idx));
                            }
                            //}


                        }
                        xi = -1;
                        newLine += 100;
                    } else if (sentences[sentencesIdx].charAt(i) == ' ') {

                    } else { //prints out character and line
                        g.setColor(Color.black);
                        g.drawString(Character.toString(userGuess[i]), xCoord, 80 + newLine);
                        g.drawLine(xCoord, 85 + newLine, xCoord + 20, 85 + newLine);
                        g.setColor(Color.gray);
                        if ((sentences[sentencesIdx].charAt(i) - 'A') >= 'A' || (sentences[sentencesIdx].charAt(i) - 'A') <= 'Z')
                            g.drawString((String.valueOf(cypher[(int) (sentences[sentencesIdx].charAt(i) - 'A')])), xCoord, 110 + newLine);
                    }
                }

                g.setColor(new Color(161, 200, 240, 60));
                g.fillRoundRect(x, y, 25, 55, 10, 10);
                checkCorrect(); //checks if the user guess is the same as the answer key
            }
            Game.showMoney(g); //shows how much money the player has

        }

    }
