package com.example.a16022916.p05_ndpsongs;

public class Song {

    private int id;
    private String title;
    private String singer;
    private int year;
    private int rating;

    public Song(int id, String title, String singer, int year, int rating) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.rating = rating;
    }
    public Song(String title, String singer, int year, int rating) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
