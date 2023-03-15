package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class User {
    /*
    * The user should contain username password.
    * The user should contain an ArrayList of favorite shows and watch history.
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */
    ArrayList<TVShow> tvShows = new ArrayList<TVShow>();
    Scanner input = new Scanner(System.in);
    NetflixService netflixService = new NetflixService();

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> result = new ArrayList<TVShow>();
        for (TVShow tvShow : tvShows)
        {
            if (tvShow.getTitle().equals(title))
            {
                result.add(tvShow);
            }
        }
        return result;
    }
    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> result = new ArrayList<TVShow>();
        for (TVShow tvShow : tvShows)
        {
            if (tvShow.getGenre().equals(genre))
            {
                result.add(tvShow);
            }
        }
        return result;
    }
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> result = new ArrayList<TVShow>();
        for (TVShow tvShow : tvShows)
        {
            if (tvShow.getRelease_year() == year)
            {
                result.add(tvShow);
            }
        }
        return result;
    }
    public void addToFavorites() {
        System.out.println("Please enter the title of the TVShow : ");
        String title = input.next();
        System.out.println("PLease enter the genre of the TVShow : ");
        String genre = input.next();
        System.out.println("Please enter the release year of the TVShow : ");
        int year = input.nextInt();
        System.out.println("Please enter the duration time of the TVShow : ");
        int duration = input.nextInt();
        System.out.println("Please enter the rating of the TVShow : ");
        double rating = input.nextDouble();
        TVShow tvShow = new TVShow("","",0,0,0);
        TVShow favorite = new TVShow(title, genre, year, duration, rating);
        tvShow.favorites.add(favorite);
    }
    public void viewFavorites() {
        TVShow tvShow = new TVShow("","",0,0,0);
        for (TVShow tvShow1 : tvShow.favorites)
        {
            System.out.println(tvShow1);
        }
    }
//    public ArrayList<TVShow> getRecommendations() {
//        return tvShows
//    }
    public void updateUser(){
        System.out.println("Please enter your username:");
        String username = input.nextLine();
        System.out.println("Please enter your password:");
        String password = input.nextLine();
        System.out.println("Okay!\n" +
                "How can I help you? (1-2)");
        System.out.println("1-Change username\n2-Change password");
        int choice = input.nextInt();
        if (choice == 1)
        {
            changeUsername(username, password);
        }
        else if (choice == 2)
        {
            changePassword(username,password);
        }
        else
        {
            System.out.println("Invalid Input!");
        }
    }
    public void changeUsername(String username, String password)
    {
        String path = null;
        if (netflixService.login(username, password))
        {
            path = "users.txt";
        }
        else
        {
            System.err.println("This username doesn't exist!");
        }
        File myFile = new File(path);
        String filePath = myFile.getAbsolutePath();
        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuffer buffer = new StringBuffer();
            while(sc.hasNextLine())
            {
                buffer.append(sc.nextLine() + System.lineSeparator());
            }
            String fileContents = buffer.toString();
            sc.close();
            String oldLine = username + "," + password;
            String newUsername = newUsername();
            String newLine = newUsername + "," + password;
            fileContents = fileContents.replaceAll(oldLine,newLine);
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.append(fileContents);
                writer.flush();
                writer.close();
                System.out.println("Your username successfully changed:)");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void changePassword(String username, String password)
    {
        String path = null;
        if (netflixService.login(username, password))
        {
            path = "users.txt";
        }
        File myFile = new File(path);
        String filePath = myFile.getAbsolutePath();
        try {
            Scanner sc = new Scanner(new File(filePath));
            StringBuffer buffer = new StringBuffer();
            while(sc.hasNextLine())
            {
                buffer.append(sc.nextLine() + System.lineSeparator());
            }
            String fileContents = buffer.toString();
            sc.close();
            String oldLine = username + "," + password;
            String newPassword = newPassword();
            String newLine = username + "," + newPassword;
            fileContents = fileContents.replaceAll(oldLine,newLine);
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.append(fileContents);
                writer.flush();
                writer.close();
                System.out.println("Your password successfully changed:)");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String newPassword()
    {
        System.out.println("Please enter a new password:");
        String newPassword = input.next();
        System.out.println("PLease confirm your new password(for preventing make any mistake!):");
        String repeatPassword = input.next();
        if (newPassword.equals(repeatPassword))
        {
            return newPassword;
        }
        else
        {
            return "The password that you have entered in repeat username section doesn't match with new one!";
        }
    }
    public String newUsername()
    {
        System.out.println("Please enter a new username:");
        String newUsername = input.next();
        System.out.println("PLease confirm your new username(for preventing make any mistake!):");
        String repeatUsername = input.next();
        if (newUsername.equals(repeatUsername))
        {
            return newUsername;
        }
        else
        {
            return "The username that you have entered in repeat username section doesn't match with new one!";
        }
    }
}
