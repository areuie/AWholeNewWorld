/**
 * The SceneJobGame class controls the scene to play the game for the job
 * <h3> Draft 4</h3>
 * <p>
 *     Version 1 - 4h
 *     Added keyboard input
 *     Added word spawners
 *     Added word queue
 *     Added typing game
 *     - Alisa
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.27.22
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
    /** This variable stores the x coord of the background */
    static int backgroundX = 0;
    /** This variable checks if the player is walking or not */
    boolean isWalking = false;
    /** This variable stores the image of the person*/
    private BufferedImage person;
    private int screenMove = 0;
    private int scrollerCounter1 = 1, scrollerCounter2 = 1;
    private char letter = ' ';

    private static String[] words = {
            "IMMIGRANT",
            "CITIZENSHIP",
            "VISA",
            "SPONSORSHIP",
            "NATURALIZATION",
            "SOCIETY",
            "COUNTRY",
            "MINORITY",
            "IDENTITY",
            "WORKING",
            "KNOWLEDGE",
            "RESIDENCE",
            "RESILIENCE",
            "EXCITING",
            "DOCUMENTED",
            "FAMILY",
            "STABILITY",
            "DISCRIMINATION"
    };
    private static Deque<Word> queue = new LinkedList();

    Timer timer1 = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            backgroundX -= 1;
            repaint();
        }
    });

    Timer timer2 = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            queue.add(new Word(words[(int) (Math.random() * words.length)]));
            repaint();
        }
    });

    /**
     * The constructor of the panel
     */
    public SceneJobGame(){
        try {
            bg = ImageIO.read(new File("src/img/workspaceSpan.png"));
            person = ImageIO.read(new File("src/img/pixil-frame-Female.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();
        if (Game.gameState == 10) {
            timer1.start();
            timer2.start();
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

        System.out.println(letter);

        if (backgroundX < -3200) {
            backgroundX = 0;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, backgroundX, 0, this);
        g2d.drawImage(background, backgroundX + 1600, 0, this);
        g2d.drawImage(background, backgroundX + 3200, 0, this);
        g2d.setFont(Game.font.deriveFont(28f));

        String word = "";
        if (queue.peekFirst() != null) word = queue.peekFirst().getWord();
        System.out.println(word);

        for (int i = 0; i < word.length(); i++) {
            g2d.drawString(String.valueOf(word.charAt(i)), queue.peekFirst().getX() + backgroundX + i * 15, queue.peekFirst().getY());
            if (queue.peekFirst().getX() + backgroundX + i * 15 < 0) Game.gameState = 1;
            if (i == 0 && letter == word.charAt(i)) {
                queue.peekFirst().setWord(word.substring(i + 1));
                letter = ' ';
            }
            if (queue.peekFirst().getWord().length() == 0) queue.remove();
        }
        int counter = 0;
        for (Word i: queue) {
            if (counter != 0) g2d.drawString(i.getWord(), i.getX() + backgroundX, i.getY());
            counter++;
        }

        Image p = person.getScaledInstance(person.getWidth()*7, person.getHeight()*7, Image.SCALE_DEFAULT);
        g2d.drawImage(p, 0, 350, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {

    }
}
