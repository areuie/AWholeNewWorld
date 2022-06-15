/**
 * The SceneLanguageClass is the screen for the language class.
 *
 * <p>
 * Version 1 - 3h
 * Added BufferedImage, created dialogue image, added graphics to screen
 * - Mona
 * </p>
 *
 *  <p>
 *  Version 2 - 5h
 *  Added interactive conversation where user presses space to continue reading
 *  - Mona
 *  </p>
 *
 *  <p>
 *  Version 3 - 5h
 *  Make the conversation more educational
 *  - Lois
 *  </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 06.10.22
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
    private BufferedImage boardBg,textBox;
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

            "There are 8 main topics",
            "we'll be discussing in this class.",

            "1. Being burdened by academic expectations",
            "from your parents when you're already tired.",

            "2. Loneliness due to language barriers at",
            "school at separated family.",

            "3. General feelings of stress.",
            "",

            "4. Missing your family and feeling homesick.",
            "",

            "5. Being ostracized due to cultural",
            "differences.",

            "6. Being confused about your family's financial",
            "situation.",

            "7. Feeling a disconnect between yourself and",
            "your culture.",

            "Here's a info sheet that will help facilitate",
            "your learning on academic over-expectations.",

            "In order to alleviate this type of stress, you",
            "need to learn to trust your parents enough to",

            "tell them when you feel like there’s too much",
            "responsibility. But still remember to put yourself",

            "in your parent's shoes in order to understand",
            "why they have such expectations.",

            "Here's a info sheet that will help facilitate",
            "your learning on dealing with loneliness.",

            "A good way to overcome this loneliness is to",
            "integrate into the social environment of your",

            "new country. What do kids your age play with?",
            "What are the interests of the kids in this new",

            "country? Introduce yourself to those. Don't",
            "forget to also call your family back at home.",

            "Here's a info sheet that will help facilitate",
            "your learning about managing stress.",

            "The first step to managing general stress is to",
            "take care of yourself. Sleep at least eight or",
        
            "more hours a day, eat breakfast, lunch and dinner",
            "at designated times, and communicate with a trusted",
        
            "adult about your experiences. Also realize that",
            "when you're stressed, you're more irratable, so"
                
            "try your best to controll your emotions.",
            "",

            "Here's a info sheet that will help facilitate",
            "your learning on managing homesickness.",
        
            "Homesickness comes from both a desire to go",
            "back home, and a desire to escape the current",
        
            "'home' that you have found yourself in. Try to",
            "get comfortable in your new home, and take your",
            
            "mind off thoughts of your old home by playing,",
            "doing homework, or talking with people you trust.",

            "Here's a info sheet that will help facilitate",
            "your learning on dealing with ostracization.",

            "Here's a info sheet that will help facilitate",
            "your learning on being made fun of.",

            "Here's a info sheet that will help you",
            "understand your family's financial situation.",

            "Here's a info sheet that will help you",
            "learn to reconnect with your culture."
                
            "The key to maintaining your connection to your",
            "culture, while allowing yourself to integrate",

            "into your new environment, is to maintain the",
            "existence of said culture in your daily life.",

            "However, not to the point of feeling imposed by",
            "your culture. You must realize that there is no",

            "shame in enjoying your culture, as long as",
            "nobody is harmed. If someone makes fun of your",

            "culture, whether that be by mocking your lunch",
            "or your clothes, stay firm and stand your ground.",
    };

    static String[][] sentencesPaper = {
            //1
            {"Children, especially older ones, feel the ",
                    "responsibility to become a 'model child' for",
                    "their immigrant parents, since they can",
                    "quickly realize how difficult the situation",
                    "is for their parents. Therefore, they would",
                    "want to make things easier by giving their",

                    "all, and more, at school. However, this can",
                    "lead to burnout, and accumulating stress.",
                    "Some children would want to 'tough it out'",
                    "to not seem 'weak' in front of their parents.",
                    "But that would only lead to more negative",
                    "emotions stacking up, waiting to burst.",
            },

            //2
            {
                    "Before they've become comfortable with their",
                    "new country, the closest thing a child has ",
                    "to their familiar environment is their",
                    "immigrant parent. When this figure of ",
                    "comfort is gone, for long periods of time,",
                    "the child will feel a sense of loneliness.",

                    "Especially if they aren't able to make friends."
            },

            //3
            {
                    "Moving to an environment where everything",
                    "is new, and nothing is familiar is a daunting",
                    "experience, where stress is more easily",
                    "accumulated. This, added with risks of",
                    "bullying, ostracization, or racism can lead",
                    "to a child feeling generally tired or spiritless.",
            },

            //4
            {
                    "A lack of familiar faces in a new environment",
                    "may prompt the longing for family back in",
                    "a child's home country. When knowing that",
                    "they will probably not see said family face",
                    "to face for a long time, a child may develop",
                    "symptoms of depression, especially if they",

                    "are unable to successfully integrate into",
                    "their new environment."
            },

            //5
            {
                    "Children can often be rude and ignorant,",
                    "making rude comments a common occurance",
                    "among kids, especailly if there is a",
                    "'friend' with apparent cultural differences",
                    "in their midst. A good example is lunch.",
                    "The smell of other cultures' food may seem",

                    "foregin and strange to kids who don't",
                    "understand the nuances of different cultures.",
                    "This can lead to the further ostracization",
                    "of immigrant children.",
            },

            //6
            {
                    "Finances to children are often an seen as",
                    "far-off, handled by the adults. However, at",
                    "times, its good for both the child and the",
                    "family if said child is able to understand",
                    "the financial strain that immigrating puts.",
                    "on their family. This way, they will be more",

                    "understanding of family's descisions to save",
                    "money by, say, not buying them new clothes.",
            },

            //7
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
            boardBg = ImageIO.read(new File("src/img/blackBoardBG.png"));
            textBox = ImageIO.read(new File("src/img/textBox.png"));
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
                else if (info) count2 += 6;

                if (count == 20) {
                    info = true;
                } else if (count == 28) {
                    info = true;
                }else if (count == 36) {
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

        if(info){
            Image bg1 = boardBg.getScaledInstance(800, 600, Image.SCALE_DEFAULT);;
            g.drawImage(bg1, 0, 0, this);
            if (count2 < sentencesPaper[paper].length) {
                g.setColor(Color.black);
                g.drawString(sentencesPaper[paper][count2], xcord, ycord-360);
                if (count2 + 1< sentencesPaper[paper].length){
                    g.drawString(sentencesPaper[paper][count2 + 1], xcord, ycord -320);
                    if (count2 + 2< sentencesPaper[paper].length){
                        g.drawString(sentencesPaper[paper][count2 + 2], xcord, ycord -280);
                        if (count2 + 3< sentencesPaper[paper].length){
                            g.drawString(sentencesPaper[paper][count2 + 3], xcord, ycord -240);
                            if (count2 + 4< sentencesPaper[paper].length){
                                g.drawString(sentencesPaper[paper][count2 + 4], xcord, ycord -200);
                                if (count2 + 5< sentencesPaper[paper].length){
                                    g.drawString(sentencesPaper[paper][count2 + 5], xcord, ycord -160);
                                }
                            }
                        }
                    }
                }
            } else if (count2 >= sentencesPaper[paper].length) {
                info = false;
                count2 = 0;
                paper++;
            }
        }

        Image textBox1 = textBox.getScaledInstance(textBox.getWidth() * 2, textBox.getHeight() * 2, Image.SCALE_DEFAULT);
        g.drawImage(textBox1,0, 0, this);
        Image teach = teacher.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        g.drawImage(teach, -120, 330, this);

        if (count < sentences.length) {
            g.setColor(Color.black);
            g.drawString(sentences[count], xcord, ycord);
            if (count + 1< sentences.length) g.drawString(sentences[count + 1], xcord, ycord + 40);
        } else if (count >= sentences.length) {
            Game.gameState = 12;
        }


        Game.showMoney(g);
        Game.instructionsState=2;
    }
}
