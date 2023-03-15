package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class NetflixService {
    /*
     *The NetflixService should have an Arraylist of users, tv shows and movies.
     *The NetflixService should have a User object which represents current user.
     */
    protected ArrayList<TVShow> tvShows = new ArrayList<TVShow>();
    protected ArrayList<Movie> movies = new ArrayList<Movie>();
    Scanner input = new Scanner(System.in);
    public void addTVShow(){
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
        TVShow tvShow = new TVShow(title, genre, year, duration, rating);
        tvShows.add(tvShow);
        System.out.println(title + " successfully added");
    }

    public void addMovie(){
        System.out.println("Please enter the title of the Movie : ");
        String title = input.next();
        System.out.println("PLease enter the genre of the Movie : ");
        String genre = input.next();
        System.out.println("Please enter the release year of the Movie : ");
        int year = input.nextInt();
        System.out.println("Please enter the duration time of the Movie : ");
        int duration = input.nextInt();
        System.out.println("Please enter the rating of the Movie : ");
        double rating = input.nextDouble();
        Movie movie = new Movie(title,genre,year,duration,rating);
        movies.add(movie);
        System.out.println(title + " successfully added");
    }

    public void createAccount() {
        System.out.println("Please make a username:");
        String username = input.nextLine();
        System.out.println("Please make a password:");
        String password = input.nextLine();
        System.out.println("Please confirm your password (For preventing make any mistake!):");
        String repeatPassword = input.nextLine();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true));
            if (!login(username, password)) {
                if (password.equals(repeatPassword)) {
                    writer.write(username + "," + password + "\n");
                    System.out.println("Sign Up successfully!:)");
                } else {
                    System.out.println("Passwords don't match!");
                }
            } else {
                System.out.println("This username is already exists :(");
            }
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            try {
                String line = reader.readLine();
                while (line != null)
                {
                    String users[] = line.split(",");
                    if (users[0].equals(username) && users[1].equals(password))
                    {
                        reader.close();;
                        return true;
                    }
                    line = reader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void logout() {
        System.out.println("Please enter your username:");
        String username = input.next();
        System.out.println("Please enter your password:");
        String password = input.next();
        File inputFile = new File("users.txt");
        if(!inputFile.isFile())
        {
            System.out.println("File doesn't exist!");
        }
        else
        {
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
            try {
                BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter(tempFile));
                    String line = reader.readLine();
                    while(line != null)
                    {
                        if (!line.trim().equals(username + "," + password))
                        {
                            writer.println(line);
                            writer.flush();
                        }
                        line = reader.readLine();
                    }
                    writer.close();
                    reader.close();

                    if (!inputFile.delete())
                    {
                        System.out.println("Could not delete file :(");
                        return;
                    }
                    else if (!tempFile.renameTo(inputFile))
                    {
                        System.out.println("Could not rename the temporary file :(");
                    }
                    else if (login(username, password))
                    {
                        System.out.println("User with this username and password doesn't exist! ");
                    }
                    else
                    {
                        System.out.println("\"" + username + "\"successfully got removed:)");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<String> searchByTitle() {
        System.out.println("Please enter a title :");
        String title = input.next();
        ArrayList<String> result = new ArrayList<String>();
        for (TVShow tvShow : tvShows)
        {
            if(tvShow.getTitle().equals(title))
            {
                result.add(String.valueOf(tvShow));
            }
        }
        return result;
    }

    public ArrayList<TVShow> searchByGenre() {
        System.out.println("Please enter a genre :");
        String genre = input.next();
        ArrayList<TVShow> result = new ArrayList<TVShow>();
        for (TVShow tvShow : tvShows)
        {
            if(tvShow.getGenre().equals(genre))
            {
                result.add(tvShow);
            }
        }
        return result;
    }

    public ArrayList<TVShow> searchByReleaseYear() {
        System.out.println("Please enter a year :");
        int year = input.nextInt();
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
}

