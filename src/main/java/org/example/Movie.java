package org.example;

import java.util.ArrayList;

class Movie extends TVShow {

    public Movie()
    {
        super();
    }

    public Movie(String title, String genre, int releaseYear, int duration, double rating, int length) {
        super(title, genre, releaseYear, duration, rating);
        this.length = length;
    }

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + "->" + " movie {" +
                " length: " + length + " }";
    }
}
