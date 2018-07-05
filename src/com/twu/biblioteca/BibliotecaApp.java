package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    public static BookCatalogue bookCatalogue = new BookCatalogue();
    public static MovieCatalogue movieCatalogue = new MovieCatalogue();
    private static Scanner sc = new Scanner(System.in);
    public static UserAccount loggedInAccount = null;

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayLogin() {
        if (loggedInAccount == null) {
            printToConsole("\n\nPlease login with your credentials:\n\n");
            printToConsole("Library Number: ");
            String enteredLibraryNumber = returnUserInput();
            printToConsole("Password: ");
            String enteredPassword = returnUserInput();
            clearScreen();
            String output = handleLogin(enteredLibraryNumber, enteredPassword) ? "\nSuccessful login\n\n-----------------\n" : "\nUnsuccessful login.";
            printToConsole(output);
        }
    }

    public static boolean handleLogin(String enteredLibraryNumber, String enteredPassword) {
        loggedInAccount = UserAccount.loginValid(enteredLibraryNumber, enteredPassword);
        return (loggedInAccount != null);
    }

    public static void displayMenu() {
        printToConsole("Hello! Welcome to Biblioteca.\n\nWhat would you like to do?\n\n");
        String res = "";
        while (res != "Goodbye!") {
            printToConsole(generateMenuStringToDisplay());
            printToConsole("Enter a number here to select an option: ");
            res = handleMenuInputAndReturnResponse(returnUserInput());
            printToConsole("\n" + res + "\n\n");
        }
    }

    public static String handleMenuInputAndReturnResponse(String input) {
        switch (input) {
            case "1": return handleListBooks();
            case "2":
                displayLogin();
                return handleBookCheckOut();
            case "3":
                displayLogin();
                return handleBookCheckIn();
            case "4":
                return handleListMovies();
            case "5":
                displayLogin();
                return handleMovieCheckOut();
            case "6":
                displayLogin();
                return handleMovieCheckIn();
            case "7":
                displayLogin();
                return handleLoginOrViewAccount();
            case "8": return "Goodbye!";

            default:  return "Select a valid option! Try again:";
        }
    }

    private static String handleLoginOrViewAccount() {
        if (!loggedIn()) return "Please try again.";
        return loggedInAccount.buildCustomerInformationString();
    }

    private static String handleListBooks() {
        return bookCatalogue.generateFormattedStringAllAvailableBooks();
    }

    private static String handleBookCheckIn() {
        if (!loggedIn()) return "You must be logged in to continue";
        printToConsole("Enter your book title here: ");
        return bookCatalogue.handleCheckIn(returnUserInput());
    }

    private static String handleBookCheckOut() {
        if (!loggedIn()) return "You must be logged in to continue";
        printToConsole("Enter your book title here: ");
        return bookCatalogue.handleCheckOut(returnUserInput());
    }

    private static String handleListMovies() {
        return movieCatalogue.generateFormattedStringAllAvailableMovies();
    }

    private static String handleMovieCheckIn() {
        if (!loggedIn()) return "You must be logged in to continue";
        printToConsole("Enter your movie title here: ");
        return movieCatalogue.handleCheckIn(returnUserInput());
    }

    private static String handleMovieCheckOut() {
        if (!loggedIn()) return "You must be logged in to continue";
        printToConsole("Enter your movie title here: ");
        return movieCatalogue.handleCheckOut(returnUserInput());
    }

    public static boolean loggedIn() {
        return loggedInAccount != null;
    }

    public static String returnUserInput() {
        return String.format(sc.nextLine());
    }

    public static String generateMenuStringToDisplay() {
        String accountString = loggedInAccount != null ? "My Account" : "Login";
        String output = "1: List Books\n" +
                "2: Checkout Book\n" +
                "3: Return Book\n" +
                "4: List Movies\n" +
                "5: Checkout Movie\n" +
                "6: Return Movie\n" +
                "7: " + accountString + "\n" +
                "8: Quit\n\n";
        return output;
    }

    public static void printToConsole(String out) {
        System.out.print(out);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}