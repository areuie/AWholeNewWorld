import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SceneLanguageClass extends JPanel{
    ArrayList<String> dialogue = new ArrayList<String>();
    private BufferedImage bg;

    SceneLanguageClass() {
        try {
            bg = ImageIO.read(new File("src/img/beigeBackground.png"));
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
