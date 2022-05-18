import javax.swing.*;
import java.awt.*;

public class SceneMenu extends JFrame{
    SceneMenu() {
        this.setLayout(new GridBagLayout());
        this.setTitle("A Whole New World");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 600);

        ImageIcon logo = new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/mallowicon.png");
        this.setIconImage(logo.getImage());

        ImagePanel menu = new ImagePanel(
                new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/bg.png").getImage());

        JButton bPlay = new JButton("");
        bPlay.setIcon(new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/bPlay.png"));

        JButton bExit = new JButton("");
        bExit.setIcon(new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/bExit.png"));

        this.add(menu);
        this.add(bPlay);
        this.add(bExit);

        //this.pack();
        this.setVisible(true);
    }
}
