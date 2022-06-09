/**
 * The Game class is the driver class for the game
 *
 * <h3>Draft 1</h3>
 * <p>
 * Version 1 - 4h (+4h Research)
 * Added variables to store the JFrame and JPanel, and the state of the game
 * Setup game state conditions
 * Added initialize frame
 * - Alisa
 * <p>
 * Version 2 - 2h
 * Changed Scene from SceneLanguageClassGame to SceneLanguageClass to test
 * Connected instructions screen
 * - Mona
 * <p>
 * Version 3 - 2h
 * Fixed a bug with multiple screens showing up at once
 * - Lois
 * </p>
 *
 * <h3>Draft 2</h3>
 * <p>
 *     Version 4 - 30 min
 *     Added game states
 *     - Lois
 * </p>
 *
 * <h3> Draft 3</h3>
 * <p>
 *     Version 5 - 30 min
 *     Added variables storing the money given to family, and how happy the family is
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

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Game {
    /** This variable is the main window of the game */
    public static JFrame frame = new JFrame();
    /** This variable stores the current screen*/
    public static JPanel screen;
    /** This variable stores the game state */
    public static int gameState = 0;
    /** This variable stores the amount of money the player has */
    public static int money = 300;
    /** This variable is the font of the game*/
    public static Font font;
    /** This variable stores the family happiness */
    public static int familyHappiness;
    /** This variable stores the amount of money given to family */
    public static int familyMoneyGiven;
    /** This variable stores the family that is sponsored */
    public static String sponsoredFamily="none";
    /** This variable stores the level of the game */
    public static int level = 1;
    /** This variable stores the current state of instructions */
    public static int instructionsState = 1;

    static {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/font/marumonica.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is the main method to start the game. It controls the screens of the game.
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::initializeFrame);
        SceneMenu menu = new SceneMenu();
        frame.add(menu);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        screen = menu;

        while (true) {
            if (gameState == 1) { //menu
                frame.remove(screen);
                menu = new SceneMenu();
                frame.add(menu);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = menu;
                gameState = 0;

            } else if (gameState == 2) { //Instructions
                frame.remove(screen);

                Instructions instruct = new Instructions();
                frame.add(instruct);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = instruct;
                gameState = 0;

            } else if (gameState == 3) { //high scores
                frame.remove(screen);

                SceneLeaderboard leaderboard = new SceneLeaderboard();
                frame.add(leaderboard);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = leaderboard;
                gameState = 0;
            } else if (gameState == 4) { //exit
                System.exit(0);

            } else if (gameState == 5) { //language classroom
                frame.remove(screen);

                SceneLanguageClass classroom = new SceneLanguageClass();
                frame.add(classroom);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = classroom;
                gameState = 0;

            } else if (gameState == 6) { //language game
                frame.remove(screen);

                SceneLanguageClassGame langtest = new SceneLanguageClassGame();
                frame.add(langtest);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = langtest;
                gameState = 0;

            } else if (gameState == 7) { //post office
                frame.remove(screen);

                ScenePostOffice office = new ScenePostOffice(1);
                frame.add(office);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = office;
                gameState = 0;
            } else if (gameState == -7){
                frame.remove(screen);

                ScenePostOffice office = new ScenePostOffice(2);
                frame.add(office);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = office;
                gameState = 0;
            } else if (gameState == 8) { //post office writing
                frame.remove(screen);

                ScenePostOfficeWrite letter = new ScenePostOfficeWrite(1);
                frame.add(letter);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = letter;
                gameState = 0;
            } else if (gameState == -8) { //post office writing
                frame.remove(screen);

                ScenePostOfficeWrite letter = new ScenePostOfficeWrite(2);
                frame.add(letter);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = letter;
                gameState = 0;
            } else if (gameState == 9) {
                frame.remove(screen);

                SceneInterviewDialogue interview = new SceneInterviewDialogue();
                frame.add(interview);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = interview;
                gameState = 0;
            }
            else if (gameState == 10) {
                frame.remove(screen);

                SceneJobGame jobGame = new SceneJobGame();
                frame.add(jobGame);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = jobGame;
                gameState = 0;
            }
            else if (gameState == 11) {
                frame.remove(screen);

                SceneImmigrationOffice immigration = new SceneImmigrationOffice();
                frame.add(immigration);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = immigration;
                gameState = 0;
            } else if (gameState == 12) {
                frame.remove(screen);

                SceneLongMainScreen longScreen = new SceneLongMainScreen();
                frame.add(longScreen);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = longScreen;
                gameState = 0;
            } else if (gameState == 13) {
                frame.remove(screen);

                LevelComplete complete = new LevelComplete();
                frame.add(complete);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = complete;
                gameState = 0;
            } else if (gameState == 14) {
                frame.remove(screen);

                SceneEnding end = new SceneEnding();
                frame.add(end);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = end;
                gameState = 0;
            }

        }
    }

    /**
     * This method paints the box indicator of the amount of money the player has
     * @param g
     */
    public static void showMoney(Graphics g) {
        g.setFont(Game.font.deriveFont(28f));
        g.setColor(new Color(161, 200, 240, 90));
        g.fillRoundRect(615, 20, 155, 50, 10, 10);
        g.setColor(Color.black);
        g.drawString("Funds: " + money, 625, 55);
    }

    /**
     * This method initializes the settings of the frame/window of the game.
     */
    private static void initializeFrame() {
        frame = new JFrame();

        ImageIcon logo = new ImageIcon("src/img/mallowicon.png");
        frame.setIconImage(logo.getImage());
        frame.setLayout(new GridBagLayout());
        frame.setTitle("A Whole New World");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

}
