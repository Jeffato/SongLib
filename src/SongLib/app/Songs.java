package SongLib.app;

//TODO: Check if variables should be private or public
public class Songs {
    public String name;
    public String artist;
    public String album;
    public String year;

    //TODO: Create Constructor
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

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
