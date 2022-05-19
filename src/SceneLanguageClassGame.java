import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SceneLanguageClassGame extends JPanel {

    private BufferedImage img;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public BufferedImage getBackgroundImage() {
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawOval(0, 0, 100, 100);
    }

}
