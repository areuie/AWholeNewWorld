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