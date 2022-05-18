import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    final int originalTileSize = 32; //default size of player sprites
    final int scale = 3;

    final int tileSize = originalTileSize * scale;  //96x96 tile
    final int maxScreenCol = 8;
    final int maxScreenRow = 6;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    public GamePanel() {
        //sets the size of the window
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.cyan);
        //better rendering performance
        this.setDoubleBuffered(true);
    }
}
