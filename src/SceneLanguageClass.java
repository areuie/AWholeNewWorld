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
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneLanguageClass extends JPanel {
    private BufferedImage bg;
    private BufferedImage teacher;
    private BufferedImage paperBg;
    //countGlobal for the total dialogue lines, count for teacher's dialogue, count2 for facts
    int countGlobal = 0, count = 0, count2 = 0;
    int paperY = 0;
    int paper = 0;
    boolean animatePaper = false, factsPaperFinished = false;
    boolean info = false; //false is teacher, true is paper
    static String[] sentences = {
            "Hello Everybody!",
            "Welcome to ESL (English as a Second Language).",

            "Since you guys have just landed in this new",
            "environment, we're will go over adversities",

            "that you may face as an child immigrant",
            "so that you're prepared for when they arise.",

            "There are 3 main topics",
            "we'll be discussing in this class.",

            "1. Preparing to carry the burden of being",
            "the 'sole translator' of the household",

            "2. Loneliness due to certain factors",
            "",

            "3. Figuring out your place in cultural identity",
            "",

            "Here's a info sheet that will help facilitate",
            "your learning on having too much responsibility.",

            "In order to prevent this, you need to learn to",
            "rely on your parents, and to trust them enough",

            "to tell them when you feel like there’s too much",
            "responsibility. Know that you are entitled to",

            "to act your age, especially if your living",
            "situation allows it.",

            "Here's a info sheet that will help facilitate",
            "your learning on dealing with loneliness.",

            "A good way to overcome this loneliness is to",
            "integrate into the social environment of your",

            "new country. What do kids your age play with?",
            "What are the interests of the kids in this new",
        
            "country? Introduce yourself to those.",
            "",
        
            "Here's a info sheet that will help facilitate",
            "your learning on your cultural identity.",
        
            "The key to maintaining your connection to your",
            "culture, while allowing yourself to integrate",
        
            "into your new environment, is to maintain the",
            "existence of said culture in your daily life.",
            
            "However, not to the point of feeling imposed by",
            "your culture. You must realize that there is no",
        
            "shame in enjoying your culture, as long as",
            "nobody is harmed. If someone makes fun of your",
        
            "culture, whether that be by mocking your lunch",
            "or your clothes, stay firm and stand your ground."
    };

    static String[][] sentencesPaper = {
            {"Children, especially older ones, feel the ",
                    "responsibility to become a 'translator' for their ",
                    "immigrant parents, since their impressionable ",

                    "minds can learn the language more quickly, ",
                    "(especially if  they've learned of the new ",
                    "country before immigrating there). As such, ",

                    "the child is shifted away from the role of the",
                    "protected, forcing them to take responsibility",
                    "for their parents earlier on also exposing ",
                    "them to adult struggles. Children who feel ",
                    "imposed with this responsibility earlier are at ",

                    "more risk  of developing anxiety, depression, ",
                    "eating disorders and of abusing substances.",
            },

            {
                "Before they've become comfortable with their",
                "new country, the closest thing a child has ",
                    "to their familiar environment is their",

                    "immigrant parent. When this figure of ",
                    "comfort is gone, for long periods of time,",
                    "the child will feel a sense of loneliness.",

                    "Especially if they aren't able to make friends."
            },

            {
                "Many immigrant children face this issue: ",
                    "they\'re too ‘foreign’ for their homeland, but",
                    "they're too 'exotic' in the country they've",
                    "immigrated to. Either way, they can't seem",

                    "to fit in. This manifests itself in low",
                    "self-confidence, becoming less socially active,",
                    "and raised anxiety when in an environment",
                    "where they feel they don't completely belong."
            }

    };

    Timer timer1 = new Timer(50, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(animatePaper && paperY <0) {
                paperY +=4 ;
                System.out.println("Loading paper");
            }else{
                animatePaper = false;
            }
            repaint();
        }
    });


    /**
     * Constructor, initializes graphics
     */
    SceneLanguageClass(int i ) {
        try {
            bg = ImageIO.read(new File("src/img/TeacherBG.png"));
            teacher = ImageIO.read(new File("src/img/pixil-layer-3.png"));
            paperBg = ImageIO.read(new File("src/img/factPaper.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (Game.gameState == 9) timer1.start();

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "next");
        getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(count + "%%%");
                if (!info) count += 2;
                else if (info) count2 += 3;

                if (count == 14) {
                    info = true;
                } else if (count == 22) {
                    info = true;
                }else if (count == 28) {
                    info = true;
                }
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
        g.setColor(Color.black);

        Image background = bg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        g.drawImage(background, 0, 0, this);

        int xcord = 160;
        int ycord = 470;

        System.out.println(count + " " + info);

        Image teach = teacher.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        g.drawImage(teach, -120, 330, this);

        if (count < sentences.length) {
            g.setColor(Color.black);
            g.drawString(sentences[count], xcord, ycord);
            if (count + 1< sentences.length) g.drawString(sentences[count + 1], xcord, ycord + 40);
        } else if (count >= sentences.length) {
            Game.gameState = 2;
        }

        if(info){
            Image bg1 = paperBg.getScaledInstance(paperBg.getWidth() * 4, paperBg.getHeight() * 2, Image.SCALE_DEFAULT);
            g.drawImage(bg1, 0, 150, this);
            if (count2 < sentencesPaper[paper].length) {
                g.setColor(Color.black);
                g.drawString(sentencesPaper[paper][count2], xcord, ycord-260);
                if (count2 + 1< sentencesPaper[paper].length){
                    g.drawString(sentencesPaper[paper][count2 + 1], xcord, ycord -220);
                    if (count2 + 2< sentencesPaper[paper].length){
                        g.drawString(sentencesPaper[paper][count2 + 2], xcord, ycord -180);
                    }
                }
            } else if (count2 >= sentencesPaper[paper].length) {
                info = false;
                count2 = 0;
                paper++;
            }
        }
        Game.showMoney(g);
        Game.instructionsState=2;
    }
}
