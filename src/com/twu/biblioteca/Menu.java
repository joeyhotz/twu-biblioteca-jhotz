package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    private UserManager userm;
    private Biblioteca biblioteca;
    Scanner sc = new Scanner(System.in);

    public Menu(Biblioteca biblioteca, UserManager userm) {
        this.biblioteca = biblioteca;
        this.userm = userm;
    }

    public void run() {
        System.out.println("What would you like to do?\n");
        String res = "";
        while (res != "Goodbye!") {
            displayMenu();
            System.out.println("Enter a number here to select an option: ");
            handleMenuInputAndReturnResponse(returnUserInput());
            System.out.println("\n\n");
        }

    }

    public void handleMenuInputAndReturnResponse(String input) {
        switch (input) {
            case "1":
                biblioteca.getBookCatalogue().listAllAvailable();
                break;
            case "2":
                userm.displayLogin();
                handleBookCheckOut();
                break;
            case "3":
                userm.displayLogin();
                handleBookCheckIn();
                break;
            case "4":
                handleListMovies();
                break;
            case "5":
                userm.displayLogin();
                handleMovieCheckOut();
                break;
            case "6":
                userm.displayLogin();
                handleMovieCheckIn();
                break;
            case "7":
                userm.displayLogin();
                handleLoginOrViewAccount();
                break;
            case "8":
                System.out.print("Goodbye!");
                break;
            default:
                System.out.print("Select a valid option! Try again:");
                break;
        }
    }

    private void handleLoginOrViewAccount() {
        if (!userm.loggedIn()) {
            System.out.print("Please try again.");
            return;
        }
        System.out.print(userm.getLoggedInUser().buildCustomerInformationString());
    }

    private void handleBookCheckIn() {
        if (!userm.loggedIn()) {
            System.out.print("You must be logged in to continue");
            return;
        }
        System.out.print("Enter your book title here: ");
        biblioteca.getBookCatalogue().checkIn(returnUserInput());
    }

    private void handleBookCheckOut() {
        if (!userm.loggedIn()) {
            System.out.print("You must be logged in to continue");
            return;
        }
        System.out.print("Enter your book title here: ");
        biblioteca.getBookCatalogue().checkOut(returnUserInput());
    }

    private void handleListMovies() {
        biblioteca.getMovieCatalogue().listAllAvailable();
    }

    private void handleMovieCheckIn() {
        if (!userm.loggedIn()) {
            System.out.print("You must be logged in to continue");
            return;
        }
        System.out.print("Enter your movie title here: ");
        biblioteca.getMovieCatalogue().checkIn(returnUserInput());
    }

    private void handleMovieCheckOut() {
        if (!userm.loggedIn()) {
            System.out.print("You must be logged in to continue");
            return;
        }
        System.out.print("Enter your movie title here: ");
        biblioteca.getMovieCatalogue().checkOut(returnUserInput());
    }

    public String returnUserInput() {
        return String.format(sc.nextLine());
    }

    public void displayMenu() {
        String accountString = userm.loggedIn() ? "My Account" : "Login";
        String output = "1: List Books\n" +
                "2: Checkout Book\n" +
                "3: Return Book\n" +
                "4: List Movies\n" +
                "5: Checkout Movie\n" +
                "6: Return Movie\n" +
                "7: " + accountString + "\n" +
                "8: Quit\n\n";
        System.out.print(output);
    }

}
