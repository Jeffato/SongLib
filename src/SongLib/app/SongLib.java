package SongLib.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class SongLib extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception { //TODO: Boilerplate from class, please edit

        // create FXML loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/f2c/view/f2C.fxml"));

        // load fmxl, root layout manager in fxml file is GridPane
        GridPane root = (GridPane)loader.load();

        // set scene to root
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //TODO: Program starts here
    public static void main(String[] args) {

    }

    //TODO: SceneBuilder UI, create scene and tie with controller

}
