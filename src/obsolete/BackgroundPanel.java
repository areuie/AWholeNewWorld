package obsolete;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

    public static final int CENTERED = 0;
    public static final int SCALED   = 1;

    private BufferedImage backgroundImage = null;
    private int   backgroundType  = CENTERED;

    public BackgroundPanel() throws IOException {
        super();

        javax.swing.JFrame frame = new javax.swing.JFrame( "BackgroundPanelTest" );

        BackgroundPanel p = new BackgroundPanel();
        BufferedImage i = ImageIO.read(new File("src/img/bg.png"));
        p.setBackgroundImage( i );
        p.setBackgroundType( BackgroundPanel.SCALED );
        frame.getContentPane().add( p );
        javax.swing.JLabel label = new javax.swing.JLabel( "Name: " );
        p.add( label );
        javax.swing.JTextField text = new javax.swing.JTextField( 10 );
        p.add( text );
        javax.swing.JButton button = new javax.swing.JButton( "Enter" );
        p.add( button );

        frame.setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );
        frame.setSize( 800, 600);
        frame.setVisible( true );
    }

    public BackgroundPanel( boolean isDoubleBuffered ) {
        super( isDoubleBuffered );
    }

    public BackgroundPanel( LayoutManager layout ) {
        super( layout );
    }

    public BackgroundPanel( LayoutManager layout, boolean isDoubleBuffered ) {
        super( layout, isDoubleBuffered );
    }

    public void setBackgroundImage( BufferedImage image ) {
        backgroundImage = image;
        repaint();
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundType( int type ) {
        if ( type == CENTERED || type == SCALED ) {
            backgroundType = type;
            repaint();
        }
        else {
            throw new IllegalArgumentException( "background type should be SCALED or CENTERED." );
        }
    }

    public int getBackgroundType() {
        return backgroundType;
    }

    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        BufferedImage backgroundImage = (BufferedImage) getBackgroundImage();
        if (backgroundImage != null) {
            int x = (getWidth() - backgroundImage.getWidth()) / 2;
            int y = (getHeight() - backgroundImage.getHeight()) / 2;
            g.drawImage(backgroundImage, x, y, this);
        }
    }

}