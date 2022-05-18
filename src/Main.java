import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	    JFrame window = new JFrame();
        //this lets the window close when the user presses the x button
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("A Whole New World");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //sizes the window so that the contents are to size in the window
        window.pack();

        //window displayed at center of the screen
        window.setLocationRelativeTo(null);
        //shows the window
        window.setVisible(true);
    }
}
