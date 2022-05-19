/**
 * Obsolete -- not used anymore
 */
/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener{
    JButton bPlay, bExit;
    MyPanel() {

        bPlay = new JButton("");
        bExit = new JButton("");

        bPlay.addActionListener(e -> new SceneMenu());
        bExit.addActionListener(e -> new SceneMenu());

        bPlay.setIcon(new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/bPlay.png"));
        bExit.setIcon(new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/bExit.png"));

        bPlay.setBounds(100, 200, 256, 80);
        bExit.setBounds(100, 350, 256, 80);

        bPlay.setBorder(BorderFactory.createEmptyBorder());
        bExit.setBorder(BorderFactory.createEmptyBorder());

        bPlay.setContentAreaFilled(false);
        bExit.setContentAreaFilled(false);

        this.setLayout( new GridBagLayout() );
        this.add(bPlay, new GridBagConstraints());
        this.add(bExit, new GridBagConstraints());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bPlay) {
            new SceneMenu();
        } else if (e.getSource() == bExit) {
            System.out.println("bye!");
        }
    }
} */
