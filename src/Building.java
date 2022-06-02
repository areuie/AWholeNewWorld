import java.awt.*;
import java.awt.image.BufferedImage;

public class Building {
    private BufferedImage type;
    private int x, y, w, h;

    Building(int x, int y, BufferedImage type) {
        this.x = x;
        this.y = y;
        this.type = type;

        w = type.getWidth();
        h = type.getHeight();
    }

    public BufferedImage getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
