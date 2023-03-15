package org.example;
import java.util.ArrayList;

class Movie extends TVShow {
    /*
     *Movie is extended from TVShow and has extra attribute length.
     */
    public Movie(String title, String genre ,int releaseYear, int duration, double rating)
    {
        super(title,genre,releaseYear,duration,rating);
    }
}
