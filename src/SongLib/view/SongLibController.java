package SongLib.view;

import SongLib.app.Songs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.util.*;


public class SongLibController {
    PriorityQueue<Songs> pq;
    @FXML
    ListView<Songs> listView;
    private ObservableList<Songs> obsList;

    private Stage mainStage;


    /*
       New songs must have at least a name and artist
       User may not add a song that has the same name and artist (NO Duplicates)
    */
    public void add(String name, String artist, String album, String year){ //TODO: Change to merge with UI
        if(name.isEmpty() || artist.isEmpty()){
            showAlert("Name or Artist cannot be empty", "Enter a song title or artist");
            return;
        }

        Songs newSong = new Songs(name, artist, album, year);

        if(isDuplicate(newSong)){
            showAlert("Song is a Duplicate",
                    "This song already exists");
            return;
        }

        pq.add(newSong);
        updateSongList();
    }

    /*
        User may not edit a song that has the same name and artist (NO Duplicates)
        Name and artist field may not be empty
     */
    public void remove(){ //TODO: Finish Method

    }

    /*
        Only the selected song in the list can be deleted. After deletion, the next song in the list should be selected, and the details displayed.
        If there is no next song, the previous song should be selected, and if there is no previous song either, then the list is empty and the detail info is all blanks.
     */
    public void edit(){ //TODO: Finish Method

    }

    //TODO: Finish Method
    public String cleanString(){
        String output = "";

        return output;
    }

    public boolean isDuplicate(Songs newSong){
        for(Songs s: obsList){
            if(s.getName().equals(newSong.getName()) && s.getArtist().equals(newSong.getArtist())){
                return true;
            }
        }

        return false;
    }

    private void updateSongList() {
        PriorityQueue<Songs> pqCopy = new PriorityQueue<Songs>(pq);
        ObservableList<Songs> output = FXCollections.observableArrayList();

        Songs s = pqCopy.poll();

        while(s != null){
            output.add(s);
            s = pqCopy.poll();
        }

        obsList = output;
        listView.setItems(output);
    }

    public void start(){
        //Create obs list from ArrayList TODO: Change to load from JSON
        obsList = FXCollections.observableArrayList();
        pq = new PriorityQueue<Songs>();
        listView.setItems(obsList);

        add("Kachow1", "Kachow1", "", "");
        add("Kachow1", "Kachow1", "", "");
        add("Kachow2", "Kachow2", "", "");

    }

    private void showAlert(String header, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(mainStage);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
