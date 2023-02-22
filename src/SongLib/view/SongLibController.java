/*
 * Ashhad Siddiqui	(as3475)
 * John Bailon (jlb671)
 *
 */

package SongLib.view;

import SongLib.app.Songs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class SongLibController {
    PriorityQueue<Songs> pq;
    @FXML
    ListView<Songs> listView;
    @FXML Text nameDetailText;
    @FXML Text artistDetailText;
    @FXML Text albumDetailText;
    @FXML Text yearDetailText;
    @FXML TextField nameTxtField;
    @FXML TextField artistTxtField;
    @FXML TextField albumTxtField;
    @FXML TextField yearTxtField;
    @FXML Button confirmAddBtn;
    @FXML Button cancelAddBtn;
    @FXML Button remove;
    @FXML TextField editNameTxtField;
    @FXML TextField editArtistTxtField;
    @FXML TextField editAlbumTxtField;
    @FXML TextField editYearTxtField;
    private ObservableList<Songs> obsList;
    private Stage mainStage;

    public void buttonListener(ActionEvent e) {
        Button b = (Button) e.getSource();
        if (b == confirmAddBtn) {
            add();
            showSongDetails();
        }
        else if(b == remove){
            remove();
            showSongDetails();
        }
    }

    private void showSongDetails() {
        Songs currentSong = listView.getSelectionModel().getSelectedItem();
        if(null != currentSong) {
            String name = currentSong.getName().length() > 25 ?
                    currentSong.getName().substring(0, 21) + "..." : currentSong.getName();
            String artist = currentSong.getArtist().length() > 25 ?
                    currentSong.getArtist().substring(0, 21) + "..." : currentSong.getArtist();
            String album = currentSong.getAlbum().length() > 35 ?
                    currentSong.getAlbum().substring(0, 31) + "..." : currentSong.getAlbum();

            nameDetailText.setText(name);
            artistDetailText.setText(artist);
            albumDetailText.setText(album);
            yearDetailText.setText(currentSong.getYear());
        }
    }
    /*
       New songs must have at least a name and artist
       User may not add a song that has the same name and artist (NO Duplicates)
    */
    public void add(){

        String name = nameTxtField.getText();
        String artist = artistTxtField.getText();
        String album = albumTxtField.getText();
        String year = yearTxtField.getText();

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
        nameTxtField.clear();
        artistTxtField.clear();
        albumTxtField.clear();
        yearTxtField.clear();
        updateSongList();
    }

    /*
        User may not edit a song that has the same name and artist (NO Duplicates)
        Name and artist field may not be empty
     */
    public void remove(){ //TODO: Finish Method
        obsList.remove(listView.getSelectionModel().getSelectedItem());
        updateSongList();
    }

    /*
        Only the selected song in the list can be deleted. After deletion, the next song in the list should be selected, and the details displayed.
        If there is no next song, the previous song should be selected, and if there is no previous song either, then the list is empty and the detail info is all blanks.
     */
    public void edit() {
        Songs selection = listView.getSelectionModel().getSelectedItem();
        if (null != selection) {
            editNameTxtField.setText(selection.getName());
            editArtistTxtField.setText(selection.getArtist());
            editAlbumTxtField.setText(selection.getAlbum());
            editYearTxtField.setText(selection.getYear());
        }
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
        showSongDetails();
    }

    public void start(){
        //Create obs list from ArrayList TODO: Change to load from JSON
        obsList = FXCollections.observableArrayList();
        pq = new PriorityQueue<Songs>();
        listView.setItems(obsList);

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
