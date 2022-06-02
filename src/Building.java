import java.awt.*;
import java.awt.image.*;

public class Building {
    private Image type;
    private int x, y, w, h;

    Building(int x, int y, BufferedImage type) {
        this.x = x;
        this.y = y;
        this.type = type.getScaledInstance(600, 600, Image.SCALE_DEFAULT);

        w = type.getWidth();
        h = type.getHeight();
    }

    public Image getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
