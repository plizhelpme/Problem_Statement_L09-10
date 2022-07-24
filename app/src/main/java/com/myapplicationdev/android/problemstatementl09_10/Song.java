package com.myapplicationdev.android.problemstatementl09_10;

import java.io.Serializable;

public class Song implements Serializable {

    private int id;
    private String songTitle;
    private String songSinger;
    private int songYear;
    private int songStars;

    public Song(int id, String songTitle, String songSinger, int songYear, int songStars) {
        this.id = id;
        this.songTitle = songTitle;
        this.songSinger = songSinger;
        this.songYear = songYear;
        this.songStars = songStars;
    }

    public int getId() { return id; }

    public String getSongTitle() { return songTitle; }

    public String getSongSinger() { return songSinger; }

    public int getSongYear() { return songYear; }

    public int getSongStars() { return songStars; }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setSongSinger(String songSinger) {
        this.songSinger = songSinger;
    }

    public void setSongYear(int songYear) {
        this.songYear = songYear;
    }

    public void setSongStars(int songStars) {
        this.songStars = songStars;
    }

    public void getAll(int id, String songTitle, String songSinger, int songYear, int songStars)
    {this.id = id; this.songTitle = songTitle; this.songSinger = songSinger; this.songYear = songYear;
        this.songStars = songStars;}

    @Override
    public String toString() { return "ID:" + id + ", " + songTitle + ", "
            + songSinger + ", " + songYear + ", " + songStars; }
}
