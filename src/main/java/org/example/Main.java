package org.example;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static User user = new User();
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        NetflixService service = new NetflixService();
        System.out.println("Welcome!");
        boolean runFlag = true;
        while (runFlag) {
            System.out.println("PLease choose from option\n" +
                    "1-Create an account\n" +
                    "2-Login\n" +
                    "3-Exit");
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    service.createAccount();
                    break;
                case 2:
                    System.out.println("please enter your username : ");
                    String username = input.next();

                    System.out.println("please enter your password : ");
                    String password = input.next();
                    if (service.login(username,password))
                    {
                        user_menu(username);
                    }
                    else
                    {
                        System.out.println("User with this username and password doesn't exist!");
                    }
                    break;
                case 3:
                    runFlag = false;
                    break;
                default:
                    System.out.println("Invalid input! please try again");
            }
        }
    }
    public static void user_menu(String username)
    {
        System.out.println("Welcome dear " + username);
        boolean runFLug = true;
        int userChoice;
        NetflixService netflixService = new NetflixService();
        while (runFLug)
        {

            System.out.println("Please choose from options below :\n" +
                    "1- Add TVShow\n" +
                    "2- Add Movie\n" +
                    "3- Search by title\n" +
                    "4- Search by genre\n" +
                    "5- Search by release year\n" +
                    "6- Show favorites\n" +
                    "7- Add to favorites\n" +
                    "8- Update profile\n" +
                    "9- Logout\n" +
                    "10- Back to main menu");

            userChoice = input.nextInt();
            switch (userChoice)
            {
                case 1:
                    netflixService.addTVShow();
                    break;
                case 2:
                    netflixService.addMovie();
                    break;
                case 3:
                    System.out.println("Here is the result : \n" +
                            netflixService.searchByTitle());
                    break;
                case 4:
                    System.out.println("Here is the result : \n" +
                            netflixService.searchByGenre());
                    break;
                case 5:
                    System.out.println("Here is the result : \n" +
                            netflixService.searchByReleaseYear());
                    break;
                case 6:
                    user.viewFavorites();
                    break;
                case 7:
                    user.addToFavorites();
                    break;
                case 8:
                    user.updateUser();
                    break;
                case 9:
                    netflixService.logout();
                    runFLug = false;
                    break;
                case 10:
                    runFLug = false;
                    runMenu();
                    break;
                default:
                    System.out.println("Invalid input! please try again");
            }
        }
    }
}
