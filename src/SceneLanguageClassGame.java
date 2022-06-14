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

//took 2 hours
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
    int choice = 0;
    int quizRight = 0;
    boolean wrong = false;
    boolean answered = false;
    boolean score = false;
    boolean stage = false;//false is prompt, true is game
    static String[] ansKey = {
            "a","ab","ac","bc","a","ab","ac","bc"
    };
    static String[][] abc = {
            {
                    "a) Communicate with your parent(s).",
                    "Let them know how you're feeling.",
                    "b) Let it go",
                    "c) Call the police"
            },
            {
                    "a) Approach those who share your ethnic",
                    "background",
                    "b) Join clubs and after-school programs",
                    "c) Wait for people to come to you"
            },
            {
                    "a) Take deep breaths/meditate",
                    "b) Ignore and suppress the stress",
                    "c) Reach out to a loved one"
            },
            {
                    "a) Grow resentment",
                    "b) Call family members",
                    "c) Send mail overseas"
            },
            {
                    "a) Communicate with your parent(s).",
                    "Let them know how you're feeling.",
                    "b) Let it go",
                    "c) Call the police"
            },
            {
                    "a) Approach those who share your ethnic",
                    "background",
                    "b) Join clubs and after-school programs",
                    "c) Wait for people to come to you"
            },
            {
                    "a) Take deep breaths/meditate",
                    "b) Ignore and suppress the stress",
                    "c) Reach out to a loved one"
            },
            {
                    "a) Grow resentment",
                    "b) Call family members",
                    "c) Send mail overseas"
            }
    };
    /**
     * This variable stores the answer key for the sentence to be decyphered
     */
    static String[][] sentences = {
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            },
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            },
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            },
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            },
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            },
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            },
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            },
            {"I WILL@COMMUNICATE WITH@MY PARENTS ABOUT@MY STRESSORS.",
                    "I WILL AVOID@COMMUNICATING@WITH MY PARENTS@ABOUT MY@STRESSORS.",
                    "I WILL@TAKE INITIATIVE@AND TRY TO MAKE@FRIENDS AT@SCHOOL.",
            }
    };
    static String[][] prompts = {
            {       "Scenario: Your parent puts on too",
                    "much burden on yourself to do good.",
                    "at school. You're already trying",
                    "your best."
            },
            {       "Scenario: You feel lonely because",
                    "of your separated family and",
                    "language barrier at school."
            },
            {
                "Scenario: You feel stressed due to",
                    "your situation."
            },
            {
                "Scenario: You deeply miss your",
                    "family back home/feel homesick."
            },
            {
                "Scenario: People at school plug",
                    "their noses out of disgust",
                    "because of your lunch."
            },
            {
                "Scenario: People at school tease",
                    "you for having an accent."
            },
            {
                "Scenario: Your family is having",
                    "financial issues. How can you",
                    "support your family as a kid?"
            },
            {
                "Scenario: You feel like you can't",
                    "identify with either culture/",
                    "don't fit in."
            },
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
        userGuess = new char[sentences[prompt][choice].length()];
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
                System.out.println(answered);
                if (score) {
                    Game.gameState = 12;
                }
                else if (answered) {
                    if (!wrong) stage = true;
                    reset();
                    System.out.println("hi");
                    prompt = Math.min(prompt + 1, prompts.length);
                    if (prompt >= prompts.length) score = true;
                    repaint();
                }
                else if (!stage) {
                    if (e.getX() > 300 && e.getX() < 350 && e.getY() > 510 && e.getY() < 550)//if they press yes they are taken to the scene
                    {
                        choice = 0;
                        answered = true;
                        if (ansKey[prompt].contains("a")) {
                            quizRight++;
                            System.out.println("yess!");
                            System.out.println(quizRight);
                            wrong = false;
                            repaint();
                        } else {
                            wrong = true;
                            repaint();
                        }
                    } else if (e.getX() > 370 && e.getX() < 410 && e.getY() > 510 && e.getY() < 550) {//if they press no, they continue on
                        choice = 1;
                        answered = true;
                        if (ansKey[prompt].contains("b"))  {
                            quizRight++;
                            System.out.println("noo!");System.out.println(quizRight);
                            wrong = false;
                            repaint();
                        } else {
                            wrong = true;
                            repaint();
                        }
                    } else if (e.getX() > 450 && e.getX() < 500 && e.getY() > 510 && e.getY() < 550) {//if they press no, they continue on
                        choice = 2;
                        answered = true;
                        if (ansKey[prompt].contains("c")) {
                            quizRight++;
                            System.out.println(quizRight);
                            System.out.println("noo!");
                            wrong = false;
                            repaint();
                        } else {
                            wrong = true;
                            repaint();
                        }
                    }
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
                    if (idx - 1 >= 0 && sentences[prompt][choice].charAt(idx) == ' ') {
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
                if (idx + 1 < sentences[prompt][choice].length() - 1) {
                    idx++;
                    x += 25;
                    if (idx + 1 < sentences[prompt][choice].length() && sentences[prompt][choice].charAt(idx) == ' ') {
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
        for (int i = 0; i < sentences[prompt][choice].length(); i++) {
            if (sentences[prompt][choice].charAt(i) != userGuess[i]) same = false;
        }
        if (same) {
            stage = false;
            if (prompt >= prompts.length) score = true;
        }
    }

    private void reset() {
        userGuess = new char[sentences[prompt][choice].length()];
        cypher = new char[26];
        wrong = false;
        answered = false;
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
            System.out.println((sentences[prompt][choice].charAt(idx) - 'A'));
            if ((sentences[prompt][choice].charAt(idx) - 'A') >= 0 && (sentences[prompt][choice].charAt(idx) - 'A') <= 26 &&
                    (sentences[prompt][choice].charAt(i) - 'A') >= 0 && (sentences[prompt][choice].charAt(i) - 'A') <= 26) {
                System.out.println("---------------------" + (cypher[(int) (sentences[prompt][choice].charAt(idx) - 'A')]));
                if (cypher[(int) (sentences[prompt][choice].charAt(idx) - 'A')] == (cypher[(int) (sentences[prompt][choice].charAt(i) - 'A')])) {
                    userGuess[i] = c;
                }
            }
        }
        repaint();
    }

        private void randomizeGivenChars () {
            for (int i = 0; i < sentences[prompt][choice].length(); i++) {
                int random = (int) (Math.random() * 100);

                if (i == 0 || i == sentences[prompt][choice].length() || i > 1 && (sentences[prompt][choice].charAt(i - 1) == '@' || sentences[prompt][choice].charAt(i - 1) == ' ')) {
                    userGuess[i] = sentences[prompt][choice].charAt(i);
                } else if (i < sentences[prompt][choice].length() - 1 && (sentences[prompt][choice].charAt(i + 1) == '@' || sentences[prompt][choice].charAt(i + 1) == ' ')) {
                    userGuess[i] = sentences[prompt][choice].charAt(i);
                } else if (sentences[prompt][choice].charAt(i) == '@') {
                    userGuess[i] = '@';
                } else if (sentences[prompt][choice].charAt(i) == ' ') {
                    userGuess[i] = ' ';
                } else if (sentences[prompt][choice].charAt(i) == '.') {
                    userGuess[i] = '.';
                } else if (sentences[prompt][choice].charAt(i) == '?') {
                    userGuess[i] = '?';
                } else if (random > 85) {
                    userGuess[i] = sentences[prompt][choice].charAt(i);
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
            g.setFont(Game.font.deriveFont(25f));

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
            if (score) {
                g.setFont(Game.font.deriveFont(35f));
                g.drawString("Your score is " + quizRight + "/8.", 210, 390);
                g.setFont(Game.font.deriveFont(22f));
                g.drawString("Click anywhere to continue", 210, 435);
            }
            else if (!stage) {
                g.setColor(Color.black);
                for (int i = 0; i < prompts[prompt].length; i++) {
                    g.drawString(prompts[prompt][i], 205, 80 + i * 25);
                }
                Graphics2D buttons = (Graphics2D) g;

                RenderingHints button = new RenderingHints(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                buttons.setRenderingHints(button);

                g.setColor(Color.black);
                g.setFont(Game.font.deriveFont(25f));

                int xp = 205;
                int yp = 190;


                for (int i = 0; i < abc[prompt].length; i++) {
                    g.drawString(abc[prompt][i], xp, yp);
                    yp += 30;
                }
                buttons.setPaint(new Color(150, 150, 150));
                if (answered) {
                    if (!wrong) {
                        g.setFont(Game.font.deriveFont(35f));
                        g.setColor(new Color(80, 177, 69));
                        g.drawString("Correct!", 260, 40);
                    }
                    else {
                        g.setFont(Game.font.deriveFont(35f));
                        g.setColor(new Color(189, 57, 57));
                        g.drawString("Wrong Answer", 260, 40);
                    }
                    g.setColor(new Color(189, 57, 57));
                }

                buttons.fillRoundRect(300, 510, 50, 40, 25, 25);
                buttons.fillRoundRect(370, 510, 50, 40, 25, 25);
                buttons.fillRoundRect(450, 510, 50, 40, 25, 25);

                if (answered) {
                    if (ansKey[prompt].contains("a")) {
                        g.setColor(new Color(80, 177, 69));
                        buttons.fillRoundRect(300, 510, 50, 40, 25, 25);
                    }
                    if (ansKey[prompt].contains("b")) {
                        g.setColor(new Color(80, 177, 69));
                        buttons.fillRoundRect(370, 510, 50, 40, 25, 25);
                    }
                    if (ansKey[prompt].contains("c")) {
                        g.setColor(new Color(80, 177, 69));
                        buttons.fillRoundRect(450, 510, 50, 40, 25, 25);
                    }

                    g.setFont(Game.font.deriveFont(30f));
                    g.setColor(new Color(0, 0, 0));
                    g.drawString("Click anywhere to continue", 215, 400);
                }

                g.setFont(Game.font.deriveFont(20f));
                g.setColor(new Color(0, 0, 0));
                g.drawString("a", 320, 540);
                g.drawString("b", 390, 540);
                g.drawString("c", 470, 540);

            }
            else if (stage) {
                int newLine = 0;
                int xCoord;

                for (int i = 0, xi = 0; i < sentences[prompt][choice].length() - 1; i++, xi++) { //prints the sentence

                    xCoord = 210 + xi * 25;
                    if (sentences[prompt][choice].charAt(i) == '@') {
                        System.out.println(sentences[prompt][choice].charAt(idx));
                        if (sentences[prompt][choice].charAt(idx) == '@') {
                            //if (x > sentences[sentencesIdx.substring(0, i).length() * 25) {
                            if (dir == 'r') {
                                x = 205;
                                y += 100;
                                idx++;
                            } else if (dir == 'l') {
                                x = 205;
                                y -= 100;
                                System.out.println("f" + previousLine(sentences[prompt][choice].substring(0, idx)));
                                idx = previousLine(sentences[prompt][choice].substring(0, idx));
                            }
                            //}


                        }
                        xi = -1;
                        newLine += 100;
                    } else if (sentences[prompt][choice].charAt(i) == ' ') {

                    } else { //prints out character and line
                        g.setColor(Color.black);
                        g.drawString(Character.toString(userGuess[i]), xCoord, 80 + newLine);
                        g.drawLine(xCoord, 85 + newLine, xCoord + 20, 85 + newLine);
                        g.setColor(Color.gray);
                        if ((sentences[prompt][choice].charAt(i) - 'A') >= 'A' || (sentences[prompt][choice].charAt(i) - 'A') <= 'Z')
                            g.drawString((String.valueOf(cypher[(int) (sentences[prompt][choice].charAt(i) - 'A')])), xCoord, 110 + newLine);
                    }
                }

                g.setColor(new Color(161, 200, 240, 60));
                g.fillRoundRect(x, y, 25, 55, 10, 10);
                checkCorrect(); //checks if the user guess is the same as the answer key
            }

            Game.showMoney(g); //shows how much money the player has

        }

    }
