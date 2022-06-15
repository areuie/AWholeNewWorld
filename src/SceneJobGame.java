/**
 * The SceneJobGame class controls the scene to play the game for the job
 * <h3> Draft 3</h3>
 * <p>
 *     Version 1 - 4h
 *     Added keyboard input
 *     Added word spawners
 *     Added word queue
 *     Added typing game
 *     - Alisa
 *
 *     Version 2 - 2h
 *     Fixed bug: Words disappearing when the screen crossed the screen loop
 *     - Alisa
 * </p>
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
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class SceneJobGame extends JPanel implements ActionListener, Runnable{
    /** This variable stores the background */
    private BufferedImage bg;
    static int stage = 6;
    /** This variable stores the x coord of the background */
    static int backgroundX = 0;
    /** This variable stores the image of the person and icons*/
    private BufferedImage person, brainIcon;
    /** This variable stores the letter that the user pressed*/
    private char letter = ' ';
    /** This variable stores the type of image of the sprite*/
    private int spriteImg = 1;
    private boolean gameOver = false;
    /** This variable keeps track of what good words have been typed*/
    private boolean[] counter;
    /** This variable stores the number of chances the player has*/
    private int chances = 3;
    /** This variable stores the words going across the screen*/
    private static String[] words = {
            "1. How to create new friends in a new country:",
            "2. How to deal with stress in general:",
            "3. What to do when people joke about your accent:",
            "4. What should you do if you miss your family overseas?:",
            "5. What to do when feeling homesick:",
            "6. How to react if parents can't buy things?:",
            "7. What to do when people comment on your lunch:",
            "8. How to support parent(s) as a kid:",

    };
    /** This variable stores the queue of words going across the screen */
    private static Deque<Word> queue = new LinkedList();
    /** This is the timer that moves the background (auto-scroller) */
    Timer timer1 = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            backgroundX -= 2;
            repaint();
        }
    });
    /** This is the timer that keeps on adding new words to the queue */
    Timer timer2 = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int random = (int) (Math.random() * 6);
            if (random > 1) queue.add(new Word('g'));
            else  queue.add(new Word('b'));
            repaint();
        }
    });
    /** This is the timer that animates the moving sprite */
    Timer timer3 = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String path = "src/img/pixil-frame-Female" + spriteImg + ".png";
            try {
                person = ImageIO.read(new File(path));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            repaint();

            if (spriteImg > 3) spriteImg = 1;
            else spriteImg++;

            if (gameOver) {
                timer1.stop();
                timer2.stop();
                timer3.stop();
                Game.gameState = 12;
            }
            boolean allTrue = true;
            for (int i = 0; i < counter.length; i++) {
                System.out.print(counter[i] + " ");
                if (counter[i] == false) allTrue = false;
            }
            System.out.println();
            if (allTrue) {
                if (stage + 1 < Word.good.length) {
                    Word.count=0;
                    stage++;
                }
                else {
                    timer1.stop();
                    timer2.stop();
                    timer3.stop();
                    Game.gameState = 12;
                }
                reset();
            }
        }
    });

    /**
     * The constructor of the panel
     */
    public SceneJobGame(){
        try {
            bg = ImageIO.read(new File("src/img/workspaceSpan.png"));
            person = ImageIO.read(new File("src/img/pixil-frame-Female1.png"));
            brainIcon = ImageIO.read(new File("src/img/brainIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        counter = new boolean[Word.good[stage].length];

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();
        if (Game.gameState == 10) {
            timer1.start();
            timer2.start();
            timer3.start();
        }

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

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "space");
        getActionMap().put("space", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (queue.peek()!= null) {
                    if (queue.peek().getType() == 'b') {
                        Game.money += 50;
                        queue.remove();
                    }
                    else {
                        chances--;
                        if (Word.count - 1 >= 0) Word.count--;
                        queue.remove();
                        if (chances < 0) gameOver = true;
                    }
                }
                System.out.println("hay");
                repaint();
            }
        });

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

    /**
     * This method resets the settings for the game
     */
    private void reset() {
        counter = new boolean[Word.good[stage].length];
        queue = new LinkedList();
        letter = ' ';
        backgroundX = 0;
        chances = 3;
    }

    /**
     * This method determines the dimensions of the panel
     * @return The dimensions of the panel
     */
    @Override
    public Dimension getPreferredSize() { return new Dimension(800, 600); }

    /**
     * This method paints graphics on the screen.
     * @param g Graphic
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = bg.getScaledInstance(1600, 600, Image.SCALE_DEFAULT);

        if (backgroundX < -3200) {
            backgroundX = 0;
            for (Word i: queue) {
                i.setX();
            }
        }

        //System.out.println(backgroundX);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, backgroundX, 0, this);
        g2d.drawImage(background, backgroundX + 1600, 0, this);
        g2d.drawImage(background, backgroundX + 3200, 0, this);
        g2d.setFont(Game.font.deriveFont(28f));

        String word = "";
        if (queue.peekFirst() != null) {
            word = queue.peekFirst().getWord();
            //System.out.println(word + " " + (queue.peekFirst().getX()));
        }

        for (int i = 0; i < word.length(); i++) {
            g2d.drawString(String.valueOf(word.charAt(i)), queue.peekFirst().getX()+ i * 15, queue.peekFirst().getY());
            if (queue.peekFirst().getX() + i * 15 < 0) {
                if (queue.peekFirst().getType() == 'g') {if (Word.count - 1 >= 0) Word.count--;}
                queue.remove();
                chances--;
                if (chances < 0) gameOver = true;
            }
            if (i == 0 && letter == word.charAt(i)) {
                queue.peekFirst().setWord(word.substring(i + 1));
                letter = ' ';
            }
            if (queue.peekFirst().getWord().length() == 0) {

                if (queue.peekFirst().getType() == 'g') {
                    Game.money += 50;
                    for (int j=  0; j < Word.good[stage].length; j++) {
                        System.out.println(Word.good[stage][j] + " " + (queue.peekFirst().getOgWord()));
                        if (Word.good[stage][j].equals(queue.peekFirst().getOgWord())) counter[j] = true;
                    }
                    queue.remove();
                } else {
                    chances--;
                    queue.remove();
                    if (chances < 0) gameOver = true;
                }
            }
        }
        int counter = 0;
        for (Word i: queue) {
            if (counter != 0) g2d.drawString(i.getWord(), i.getX(), i.getY());
            counter++;
        }

        Image p = person.getScaledInstance(person.getWidth()*7, person.getHeight()*7, Image.SCALE_DEFAULT);
        g2d.drawImage(p, 0, 350, null);

        g2d.setColor(new Color(234, 238, 255, 182));
        g2d.setFont(Game.font.deriveFont(27f));
        g2d.fillRoundRect(10, 20, 590, 80, 25, 25);
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawString(words[stage], 25, 65);

        for (int i = 0; i < chances; i++) {
            g2d.drawImage(brainIcon, 0, 100 + i * 55, null);
        }

        Game.showMoney(g2d);
    }

    /** This method is the actionPerformed overriden method */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /** This method is the run overriden method */
    @Override
    public void run() {

    }
}
