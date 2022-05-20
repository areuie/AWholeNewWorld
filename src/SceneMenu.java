import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneMenu extends JPanel {
    private BufferedImage bg;
    private volatile boolean selected;

    SceneMenu() {
        try {
            bg = ImageIO.read(new File("src/img/bg.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        selected = false;

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getX() > 120 && e.getX() < 390 && e.getY() > 380 && e.getY() < 460)//if they press play button they are taken to the next game
                {
                    repaint();
                    Game.gameState = 2;
                    selected = true;
                    System.out.println("PLAY");

                } else if (e.getX() > 408 && e.getX() < 680 && e.getY() > 380 && e.getY() < 460)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 3;
                    selected = true;
                    System.out.println("INSTRUCTIONS");
                } else if (e.getX() > 120 && e.getX() < 390 && e.getY() > 480 && e.getY() < 560)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 4;
                    selected = true;
                    System.out.println("HIGHSCORES");
                } else if (e.getX() > 408 && e.getX() < 680 && e.getY() > 480 && e.getY() < 560)//if they press instructions button they are taken to that page
                {
                    repaint();
                    Game.gameState = 5;
                    selected = true;
                    System.out.println("EXIT");
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public int selectedOption() {
        repaint();
        revalidate();
        while (!selected) ;
        return Game.gameState;
    }
}
