import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneMenu extends JPanel{
    private BufferedImage bg;

    SceneMenu() {
        try {
            bg = ImageIO.read(new File("src/img/bg.png"));
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    @Override
    public Dimension getPreferredSize() { return new Dimension(800, 600); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }
        g.drawRect(120,384,272, 80);
        g.drawRect(408,384,272, 80);

        g.drawRect(120,480,272, 80);
        g.drawRect(408,480,272, 80);

    }
}
