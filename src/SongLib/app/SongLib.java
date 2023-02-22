/*
 * Ashhad Siddiqui	(as3475)
 * John Bailon (jlb671)
 *
 */

package SongLib.app;

import SongLib.view.SongLibController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SongLib extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception { //TODO: Boilerplate from class, please edit

        // create FXML loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/SongLib/view/songlib.fxml"));

        // load fmxl, root layout manager in fxml file is GridPane
        VBox root = (VBox)loader.load();

        //Create Controller
        SongLibController controller = loader.getController();
        controller.start();

        // set scene to root
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //TODO: Program starts here
    public static void main(String[] args) {
        launch(args);
    }
}
