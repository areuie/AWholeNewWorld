/**
 * Alisa: 4h
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SceneLanguageClassGame extends JPanel {

    private BufferedImage bg;
    String[] sentences = {"CAN YOU TRANSLATE THIS SENTENCE?"};
    char[] cypher;

    static int x, y;

    SceneLanguageClassGame() {
        try {
            bg = ImageIO.read(new File("src/img/beigeBackground.png"));
        } catch (IOException ex) { ex.printStackTrace(); }

        cypher = new char[26];
        for (int i = 0; i < 26; i++) {
            boolean occupied = true;
            while (occupied) {
                occupied = false;
                int random = (int) (Math.random() * 26);
                if (cypher[random] != '\u0000') occupied = true;
                else cypher[random] = (char) (i + 'A');
            }
        }
        for (char i: cypher) {
            System.out.println(i);
        }

//        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released SPACE"), "next_state");
//        getActionMap().put("next_state", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (question == false)
//                    count++;
//                repaint();
//            }
//        });
//        addMouseListener (new MouseAdapter() {
//            public void mousePressed(MouseEvent e) {
//                if (e.getX() > 485 && e.getX() < 625 && e.getY() > 440 && e.getY() < 578) {
//                    repaint();
//                    yes = true;
//                }
//                else if (e.getX() > 695 && e.getX() < 835 && e.getY() > 440 && e.getY() < 578) {
//                    repaint();
//                    no = true;
//                }
//            }
//        });

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bg != null) {
            int x = (getWidth() - bg.getWidth()) / 2;
            int y = (getHeight() - bg.getHeight()) / 2;
            g.drawImage(bg, x, y, this);
        }

        g.setColor(Color.white);
        g.fillRect(200, 10, 400, 580);

        g.setColor(Color.black);
        g.setFont(new Font("Tahoma", Font.PLAIN, 24));

        int idx = 0;
        int newLine = 0;
        int xCoord = 0;

        for (int i = 0, xi = 0; i < sentences[0].length() - 1; i++, xi++) {
            String[] split = sentences[0].split(" ");

            xCoord = (220 + xi * 25);
            if (sentences[0].charAt(i) == ' ') {
                if ((220 + (split[idx].length() + i) * 25 + 10) > 600){
                    newLine += 100;
                    xi = 0;
                    xi--;
                }
                idx++;
            } else {
                g.setColor(Color.black);
                g.drawString(sentences[0].substring(i, i+1), xCoord, 80 + newLine);
                g.drawLine(xCoord, 85  + newLine, xCoord + 20, 85  + newLine);
                g.setColor(Color.gray);
                g.drawString((String.valueOf(cypher[(int)(sentences[0].charAt(i) - 'A')])), xCoord, 110 + newLine);
            }
        }
    }

}
