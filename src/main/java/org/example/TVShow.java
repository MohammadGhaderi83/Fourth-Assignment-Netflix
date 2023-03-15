package org.example;

import java.util.ArrayList;

class TVShow {
    /*
    *The TVShow should have a title , genre, release year, duration and a rating.
     *The TVShow should have an ArrayList of the cast.
     */
    ArrayList<String> casts = new ArrayList<String>();
    ArrayList<TVShow> favorites = new ArrayList<TVShow>();
    private String title;
    private String genre;
    private int release_year;
    private int duration;
    private double rating;

    public TVShow(String title, String genre, int release_year, int duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.release_year = release_year;
        this.duration = duration;
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getRelease_year() {
        return release_year;
    }

    public int getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }
    public void getCasts(ArrayList<String> casts)
    {
        for (String cast : casts)
        {
            System.out.println(cast);
        }
    }
}
