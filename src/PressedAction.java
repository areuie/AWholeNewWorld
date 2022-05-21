/**
 * The PressedAction class maps the key pressed to the corresponding direction.
 *
 * <p>
 * Version 1 - 30 min
 * Added constructor, instance variables and direction mapping
 * - Alisa
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

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PressedAction extends AbstractAction {
    Direction dir;
    boolean pressed;

    /**
     * Constructor that stores the direction and whether the button was pressed
     * @param dir Direction of the button
     * @param pressed If the button was pressed
     */
    public PressedAction(Direction dir, boolean pressed) {
        this.dir = dir;
        this.pressed = pressed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SceneLanguageClassGame.dirMap.put(dir,pressed);
    }

}
