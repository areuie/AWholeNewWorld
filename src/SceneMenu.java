import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneMenu extends JPanel implements ActionListener {
    JButton bPlay, bExit;
    SceneMenu() {
        setLayout(new BorderLayout());
        BackgroundPane bg = new BackgroundPane();
        bg.setLayout(new GridBagLayout());
        add(bg);

        try {
            BufferedImage bgimg = ImageIO.read(new File("src/img/bg.png"));
            bg.setBackgroundImage(bgimg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        bPlay = new JButton("");
        bExit = new JButton("");

        bPlay.addActionListener(e -> Game.gameState = 2); //play
        bExit.addActionListener(e -> Game.gameState = 4); //exit

        bPlay.setIcon(new ImageIcon("src/img/bPlay.png"));
        bExit.setIcon(new ImageIcon("src/img/bExit.png"));

        bPlay.setBorder(BorderFactory.createEmptyBorder());
        bExit.setBorder(BorderFactory.createEmptyBorder());

        bPlay.setContentAreaFilled(false);
        bExit.setContentAreaFilled(false);

        bg.add(bPlay);
        bg.add(bExit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
