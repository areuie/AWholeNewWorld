import java.io.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javax.imageio.ImageIO;


public class Game extends Application{
    static final int WIDTH = 800;
    static final int LENGTH = 600;
    public static GameState gs;
    public Game() {

    }
    //Before the program
    @Override
    public void init() throws Exception {
        System.out.println("Before");
    }

    //Runs when it starts the program
    //A stage is a window
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello!");
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 800, 600);

        BackgroundImage myBI= new BackgroundImage(new Image("bg.png",800,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
        primaryStage.setScene(scene);

        primaryStage.show();

    }
    //After the program
    @Override
    public void stop() throws Exception {
        System.out.println("After");
    }
}
