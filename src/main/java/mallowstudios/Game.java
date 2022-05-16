package mallowstudios;

import java.io.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
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
    public void start(Stage stage) throws Exception {
        Image image=new Image("file:src/main/resources/img/bg.png");
        ImageView mv=new ImageView(image);

        Group root=new Group();
        root.getChildren().addAll(mv);

        Scene scene=new Scene(root,800,600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    //After the program
    @Override
    public void stop() throws Exception {
        System.out.println("After");
    }
}
