/**
 * The Game class is the driver class for the game
 *
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
 *
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.20.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 */

import javax.swing.*;
import java.awt.*;

public class Game {
    /** This variable is the main window of the game */
    public static JFrame frame;
    /** This variable stores the current screen*/
    public static JPanel screen;
    /** This variable stores the game state */
    public static int gameState = 1;

    Game() {
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
                new Instructions();

            } else if (gameState == 3) { //high scores

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

                PostOffice office = new PostOffice();
                frame.add(office);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = office;
                gameState = 0;
            }

        }
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
