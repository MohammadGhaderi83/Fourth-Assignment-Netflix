package org.example;

import java.util.ArrayList;

class User {

    ArrayList<TVShow> favorites;
    ArrayList<TVShow> watchHistory;
    ArrayList<TVShow> recommended;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        favorites = new ArrayList<>();
        watchHistory = new ArrayList<>();
        recommended = new ArrayList<>();
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow show : favorites)
        {
            if (show.getTitle().equals(title))
            {
                result.add(show);
            }
        }
        return result;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow show : favorites)
        {
            if (show.getTitle().equals(genre))
            {
                result.add(show);
            }
        }
        return result;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow show : favorites)
        {
            if (show.getReleaseYear() == year)
            {
                result.add(show);
            }
        }
        return result;
    }
    public boolean addToFavorites(TVShow show) {
        if (!doesExistsInFavorites(show))
        {
            favorites.add((Movie) show);
            Watched(show);
            return true;
        }
        return false;
    }
    public ArrayList<TVShow> viewFavorites() {
        return favorites;
    }
    public boolean addToRecommended(TVShow show)
    {
        if (!doesExistsInRecommended(show))
        {
            recommended.add(show);
            Watched(show);
            return true;
        }
        return false;
    }
    public ArrayList<TVShow> getRecommendations() {
        return recommended;
    }

    public boolean Watched(TVShow show)
    {
        if (!doesExistsInWatchedShow(show))
        {
            watchHistory.add(show);
            return true;
        }
        return false;
    }
    public ArrayList<TVShow> watchedHistory()
    {
        return watchHistory;
    }
    public boolean doesExistsInFavorites(TVShow tvShow)
    {
        return favorites.contains(tvShow);
    }

    public boolean doesExistsInRecommended(TVShow tvShow)
    {
        return recommended.contains(tvShow);
    }
    public boolean doesExistsInWatchedShow(TVShow tvShow)
    {
        return watchHistory.contains(tvShow);
    }
}
