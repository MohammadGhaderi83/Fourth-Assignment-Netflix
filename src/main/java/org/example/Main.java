package org.example;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("** Welcome to the Netflix service **!");
        NetflixService netflixService = new NetflixService();

        TVShow tvShow1 = new TVShow("show1", "genre1", 2020, 5, 8.1);
        TVShow tvShow2 = new TVShow("show2", "genre2", 2021, 6, 8.0);
        netflixService.addTVShow(tvShow1);
        netflixService.addTVShow(tvShow2);

        Movie movie1 = new Movie("movie1", "genre1", 2018, 4, 7.8,7);
        Movie movie2 = new Movie("movie2", "genre2", 2019, 5, 6.8,8);
        netflixService.addMovie(movie1);
        netflixService.addMovie(movie2);

        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        netflixService.createAccount(user1);
        netflixService.createAccount(user2);

        runMenu(netflixService);
    }

    public static void runMenu(NetflixService netflixService){
        boolean runFlag = true;
        while (runFlag) {
            System.out.println("PLease choose from option\n" +
                    "1-Create an account\n" +
                    "2-Login\n" +
                    "3-Exit");
            int userChoice = input.nextInt();
            User user = new User();
            if (userChoice == 1) {
                System.out.println("username : ");
                String username = input.next();
                System.out.println("password : ");
                String password = input.next();
                user.setUsername(username);
                user.setPassword(password);
                netflixService.createAccount(user);
                System.out.println("a user with this " + username + " and this " + password + "created");
            } else if (userChoice == 2) {
                System.out.println("username : ");
                String username = input.next();
                System.out.println("password : ");
                String password = input.next();
                user = netflixService.searchUser(password).get();
                if (user.getUsername().equals(username)) {
                    System.out.println("Login successfully!");
                } else {
                    System.out.println("Wrong username!!!");
                }
                user_menu(netflixService, user, username);
            } else if (userChoice == 3)
            {
                runFlag = false;
                System.out.println("I am glad to have served");
            } else {
                System.out.println("Invalid input please try again!");
            }
        }
    }

    public static void user_menu(NetflixService netflixService, User user, String username)
    {
        System.out.println("** Welcome dear " + username + " **");
        boolean runFlag = true;
        while (runFlag)
        {
            System.out.println("1- Search by title(In General)\n" +
                    "2- Search by genre(In General)\n" +
                    "3- Search by release year(In General)\n" +
                    "4- Search by title(in favorites)\n" +
                    "5- Search by genre(in favorites)\n" +
                    "6- Search by release year(in favorites)\n" +
                    "7- Add to favorites\n" +
                    "8- Add to recommended\n" +
                    "9- Add a TVShow\n" +
                    "10- Add a Movie\n" +
                    "11- View favorites list \n" +
                    "12- View recommended list\n" +
                    "13- View Watched History\n" +
                    "14- Exit");

            int option = input.nextInt();
            if (option == 1)
            {
                System.out.println("Input a title:");
                String title = input.next();
                System.out.println("Here is the result :");
                netflixService.searchByTitle(title);
            } else if (option == 2){
                System.out.println("Input a genre:");
                String genre = input.next();
                System.out.println("Here is the result :");
                netflixService.searchByGenre(genre);
            } else if (option == 3){
                System.out.println("Input a year:");
                int year = input.nextInt();
                System.out.println("Here is the result :");
                netflixService.searchByReleaseYear(year);
            } else if (option == 4){
                System.out.println("Input a title:");
                String title = input.next();
                System.out.println("Here is the result :");
                user.searchByTitle(title);
            } else if (option == 5)
            {
                System.out.println("Input a genre:");
                String genre = input.next();
                System.out.println("Here is the result :");
                user.searchByGenre(genre);
            } else if (option == 6){
                System.out.println("Input a year:");
                int year = input.nextInt();
                System.out.println("Here is the result :");
                user.searchByReleaseYear(year);
            } else if (option == 7){
                System.out.println("Please enter a title: ");
                String title = input.next();
                System.out.println("Please enter a genre: ");
                String genre = input.next();
                System.out.println("Please enter the release year: ");
                int releaseYear = input.nextInt();
                System.out.println("Please enter the duration: ");
                int duration = input.nextInt();
                System.out.println("Please enter the rating: ");
                double rating = input.nextDouble();
                TVShow tvShow = new TVShow(title, genre, releaseYear, duration, rating);
                String massage = user.addToFavorites(tvShow) ? title + " successfully added" : "This TVShow is already exists.";
                System.out.println(massage);
            } else if (option == 8){
                System.out.println("Please enter a title: ");
                String title = input.next();
                System.out.println("Please enter a genre: ");
                String genre = input.next();
                System.out.println("Please enter the release year: ");
                int releaseYear = input.nextInt();
                System.out.println("Please enter the duration: ");
                int duration = input.nextInt();
                System.out.println("Please enter the rating: ");
                double rating = input.nextDouble();
                TVShow tvShow = new TVShow(title, genre, releaseYear, duration, rating);
                String massage = user.addToRecommended(tvShow) ? title + " successfully added" : "This TVShow is already exists.";
                System.out.println(massage);
            } else if (option == 9){
                System.out.println("Please enter a title: ");
                String title = input.next();
                System.out.println("Please enter a genre: ");
                String genre = input.next();
                System.out.println("Please enter the release year: ");
                int releaseYear = input.nextInt();
                System.out.println("Please enter the duration: ");
                int duration = input.nextInt();
                System.out.println("Please enter the rating: ");
                double rating = input.nextDouble();
                TVShow tvShow = new TVShow(title, genre, releaseYear, duration, rating);
                String massage = netflixService.addTVShow(tvShow) ? title + " successfully added" : "This TVShow is already exists.";
                System.out.println(massage);
            } else if (option == 10){
                System.out.println("Please enter a title: ");
                String title = input.next();
                System.out.println("Please enter a genre: ");
                String genre = input.next();
                System.out.println("Please enter the release year: ");
                int releaseYear = input.nextInt();
                System.out.println("Please enter the duration: ");
                int duration = input.nextInt();
                System.out.println("Please enter the rating: ");
                double rating = input.nextDouble();
                System.out.println("Please enter the length of the movie: ");
                int length = input.nextInt();
                Movie movie = new Movie(title, genre, releaseYear, duration, rating, length);
                String massage = netflixService.addMovie(movie) ? title + " successfully added" : "This Movie is already exists.";
                System.out.println(massage);
            } else if (option == 11){
                user.viewFavorites();
            } else if (option == 12){
               user.getRecommendations();
            } else if (option == 13) {
                user.watchedHistory();
            } else if (option == 14){
                runFlag = false;
                System.out.println("I am glad to have served");
            } else {
                System.out.println("Invalid input please try again!");
            }
        }
    }
}
