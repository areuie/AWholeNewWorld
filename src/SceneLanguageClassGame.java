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
import java.util.EnumMap;
import java.util.Map;


public class SceneLanguageClassGame extends JPanel {

    private BufferedImage bg;
    String[] sentences = {"CAN YOU TRANSLATE THIS SENTENCE?"};
    char[] cypher;
    static Map<Direction, Boolean> dirMap = new EnumMap<>(Direction.class);

    static int x, y;

    public SceneLanguageClassGame() {
        try {
            bg = ImageIO.read(new File("src/img/Images/Desk.png"));
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

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();


        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, false), "pressed");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, true), "released");


        am.put("pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pressed");
            }
        });

        am.put("released", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("released");
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    void setKeyBind(InputMap inputMap, ActionMap actionMap, int keyCode, Direction dir) {
        KeyStroke press = KeyStroke.getKeyStroke(keyCode, 0, false);
        KeyStroke released = KeyStroke.getKeyStroke(keyCode, 0, true);

        Action pressAction = new PressedAction(dir, true);
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
                if ((220 + (split[idx].length() + i) * 25 + 10) > 500){
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
