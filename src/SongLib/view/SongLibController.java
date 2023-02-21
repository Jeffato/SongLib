package SongLib.view;

import SongLib.app.Songs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


public class SongLibController {

    @FXML
    ListView<Songs> listView;
    private ObservableList<Songs> obsList;

    public void start(){
        //Create obs list from ArrayList TODO: Change to JSON/PrioQ

        obsList = FXCollections.observableArrayList(
               new Songs("September"),
               new Songs("Notion")
        );

        listView.setItems(obsList);
    }

}
