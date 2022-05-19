/**
 * Alisa: 2h (+5h Research)
 * Added game loop, setup menu
 */

import javax.swing.*;
import java.awt.*;

public class Game {
    /** This variable is the main window of the game */
    public static JFrame frame;
    /** Current Screen */
    public static JPanel screen;
    /** Stores the graphics on the screen */
    public static Graphics2D graphics;
    public static int gameState = 1;

    Game() {
        frame = new JFrame();

        ImageIcon logo = new ImageIcon("src/img/mallowicon.png");
        frame.setIconImage(logo.getImage());
        frame.setLayout(new GridBagLayout());
        frame.setTitle("A Whole New World");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        loop();
    }
    void loop() {

        while(true) {
            if(gameState == 1) { //menu
                SceneMenu menu = new SceneMenu();
                frame.add(menu);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                screen = menu;
                gameState = 0;

            } else if (gameState == 2) { //play

            } else if (gameState == 3) { //high scores

            } else if (gameState == 4) { //exit
                System.exit(0);
            }
        }
    }

}