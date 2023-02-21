package SongLib.app;

import java.awt.*;

//TODO: Check if variables should be private or public
public class Songs implements Comparable<Songs>{
    public String name;
    public String artist;
    public String album;
    public String year;

    public Songs(String name, String artist, String album, String year){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }

    public Songs(String name){
        this.name = name;
        this.artist = "";
        this.album = "";
        this.year =  "";
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }


    public String getAlbum() {
        return album;
    }

    public String getYear() {
        return year;
    }

    @Override
    /*
        Compares songname then artistname alphabetically
        < 0 if after the second string
        > 0 if before the second string
     */
    public int compareTo(Songs o) {

        String firstSongInfo = this.getName();
        String secondSongInfo = this.getName();

        if(firstSongInfo.equals(secondSongInfo)){
            firstSongInfo = this.getArtist();
            secondSongInfo = this.getArtist();
        }

         return firstSongInfo.compareTo(secondSongInfo);
    }
}