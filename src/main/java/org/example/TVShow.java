package org.example;

import java.util.ArrayList;

class TVShow {

    private String title;
    private String genre;
    private int releaseYear;
    private int duration;
    private double rating;
    protected ArrayList<String> casts;

    public TVShow(String title, String genre, int releaseYear, int duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.rating = rating;
        casts = new ArrayList<>();
    }

    public TVShow() {
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    @Override
    public String toString()
    {
        return "{ title: " + title + ", genre: " + genre +
                ", release year: " + releaseYear + ",duration: " + duration +
                ",rating(IMDB): " + rating + " }";
    }
}
