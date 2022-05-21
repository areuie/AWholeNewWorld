/**
 * This class is the screen for the long screen for the character.
 *
 * <p>
 * Version 1 - 2h
 * Designed background
 * - Lois
 *
 * </p>
 *
 * @author Alisa Wu, Mona Afshar, Lois Zan
 * @version 05.20.22
 *
 * <h2> Course Info:</h2>
 * ICS4U0
 * Mrs. Krasteva
 *
 */

import obsolete.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SceneWorld  extends JPanel implements ActionListener {

    SceneWorld() throws IOException {
        setLayout(new BorderLayout());
        BackgroundPanel bg = new BackgroundPanel();
        bg.setLayout(new GridBagLayout());
        add(bg);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}