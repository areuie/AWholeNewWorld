import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LanguageClass extends JFrame{
    ArrayList<String> dialogue = new ArrayList<String>();
    private JTextArea textArea;
    String t="Hello";
    public static JLabel size = new JLabel();

    public static JLabel three = new JLabel();
    public static JFrame one = new JFrame();
    public static JButton four = new JButton();
    JLabel label = new JLabel("This is a label!");

    LanguageClass() {

        ImageIcon logo = new ImageIcon("src/img/mallowicon.png");
        this.setIconImage(logo.getImage());

        this.setLayout(new GridBagLayout());
        this.setTitle("Language Class");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //this.add(panel);

        JLabel contentPane = new JLabel();
        contentPane.setIcon(new ImageIcon("src/img/beigeBackground.png"));
        contentPane.setLayout( new BorderLayout() );
        this.setContentPane(contentPane);

        this.pack();
        this.setVisible(true);

        /*textArea = new JTextArea(100, 100);
        //printTextField(t);

        one.setVisible(true);
        one.setResizable(true);

        one.setDefaultCloseOperation(one.EXIT_ON_CLOSE);
        one.setTitle("Hello! Welcome to my window. You Shall Never Leave.");
        three.setText("Dont");
        one.add(three);
        three.setFont(new Font("Courier", Font.BOLD,300));
        one.add(four);*/


        label.setFont(new Font("Serif", Font. BOLD, 20));
        label.setForeground(Color.RED);
        label. setBackground(Color. ORANGE);
    }

    public void printTextField(String text) {
        textArea.setText(text);
    }

    public void createConvo(){
        dialogue.add("Hello everyone! Welcome to Language Class!");
    }

    public void readConvo(){
        //JOptionPane.showMessageDialog(frame, "Press ENTER to continue");
    }
}
