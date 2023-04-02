package org.example;

import java.util.ArrayList;
import java.util.Optional;

class NetflixService {

    private ArrayList<User> users;
    private ArrayList<TVShow> tvShows;
    private ArrayList<Movie> movies;

    NetflixService()
    {
        users = new ArrayList<>();
        tvShows = new ArrayList<>();
        movies = new ArrayList<>();
    }

    public boolean addTVShow(TVShow tvShow){
        if (!doseTVShowExists(tvShow))
        {
            tvShows.add(tvShow);
            return true;
        }
        return false;
    }

    public boolean addMovie(Movie movie){
        if (!doseMovieExists(movie))
        {
            movies.add(movie);
            return true;
        }
        return false;
    }

    public boolean createAccount(User user) {
        if (login(user.getPassword()))
        {
            return false;
        }
        users.add(user);
        return true;
    }

    public boolean login(String password) {
        return users.stream().anyMatch(user -> user.getPassword().equals(password));
    }

    public Optional<User> searchUser(String password)
    {
        return users.stream()
                .filter(user -> user.getPassword().equals(password)).findFirst();
    }

    public boolean logout(String password) {
        if (!login(password))
        {
            return false;
        }
        User user = users.stream().filter(user1 -> user1.getPassword().equals(password))
                .findFirst().get();
        users.remove(user);
        return true;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow show : tvShows)
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
        for (TVShow show : tvShows)
        {
            if (show.getGenre().equals(genre))
            {
                result.add(show);
            }
        }
        return result;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> result = new ArrayList<>();
        for (TVShow show : tvShows)
        {
            if (show.getReleaseYear() == year)
            {
                result.add(show);
            }
        }
        return result;
    }

    public boolean doseTVShowExists (TVShow tvShow)
    {
        return tvShows.contains(tvShow);
    }

    public boolean doseMovieExists (Movie movie)
    {
        return movies.contains(movie);
    }

}

