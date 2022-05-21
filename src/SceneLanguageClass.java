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
    private BufferedImage teacher;
    private BufferedImage speech;

    SceneLanguageClass() {
        try {
            bg = ImageIO.read(new File("src/img/Images/TeacherBG.png"));
        } catch (IOException ex) { ex.printStackTrace(); }
        try {
            teacher = ImageIO.read(new File("src/img/Images/pixil-layer-1.png"));
        } catch (IOException ex) { ex.printStackTrace(); }
        try {
            speech = ImageIO.read(new File("src/img/dialogue1.png"));
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    @Override
    public Dimension getPreferredSize() { return new Dimension(800, 600); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) /2;
            int y = (getHeight() - bg.getHeight()) /2;
            g.drawImage(bg, x, y, this);
        }
        if (teacher != null) {
            Image teach = teacher.getScaledInstance(400, 400, Image.SCALE_DEFAULT);
            g.drawImage(teach, 400, 150, this);
        }
        if (speech != null) {
            Image spe = speech.getScaledInstance(436, 178, Image.SCALE_DEFAULT);
            g.drawImage(spe, 150, 200, this);
        }

    }

}
