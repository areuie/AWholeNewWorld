import javax.swing.*;
import java.awt.event.ActionEvent;

public class PressedAction extends AbstractAction {
    Direction dir;
    boolean pressed;

    public PressedAction(Direction dir, boolean pressed) {
        this.dir = dir;
        this.pressed = pressed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SceneLanguageClassGame.dirMap.put(dir,pressed);
    }

}
