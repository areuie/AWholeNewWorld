import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneWorld  extends JPanel implements ActionListener {

    SceneWorld() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
