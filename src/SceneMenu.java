import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneMenu extends JFrame{
    JButton bPlay, bExit;
    SceneMenu() {
        ImageIcon logo = new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/mallowicon.png");
        this.setIconImage(logo.getImage());

        this.setLayout(new GridBagLayout());
        this.setTitle("A Whole New World");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.add(panel);

        JLabel contentPane = new JLabel();
        contentPane.setIcon(new ImageIcon("/Users/Alisa/Documents/GitHub/AWholeNewWorld/src/img/bg.png"));
        contentPane.setLayout( new BorderLayout() );
        this.setContentPane(contentPane);

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

        contentPane.setLayout( new GridBagLayout() );
        contentPane.add(bPlay, new GridBagConstraints());
        contentPane.add(bExit, new GridBagConstraints());

        this.pack();
        this.setVisible(true);

    }


}
