package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    public static BookCatalogue bookCatalogue = new BookCatalogue();
    private static Scanner sc = new Scanner(System.in);
    public static UserAccount loggedInAccount = null;

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayLogin() {
        printToConsole("\n\nPlease login with your credentials:\n\n");
        printToConsole("Library Number: ");
        String enteredLibraryNumber = returnUserInput();
        printToConsole("Password: ");
        String enteredPassword = returnUserInput();
        clearScreen();
        String output = handleLogin(enteredLibraryNumber, enteredPassword) ? "\nSuccessful login\n\n-----------------\n" : "\nUnsuccessful login." ;
        printToConsole(output);
    }

    public static boolean handleLogin(String enteredLibraryNumber, String enteredPassword) {
        loggedInAccount = UserAccount.loginValid(enteredLibraryNumber, enteredPassword);
        if (loggedInAccount != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void displayMenu() {
        printToConsole("Hello! Welcome to Biblioteca.\n\nWhat would you like to do?\n\n");
        String res = "";
        while (res != "Goodbye!") {
            printToConsole(generateMenuStringToDisplay());
            printToConsole("Enter a number here to select an option: ");
            res = handleInputAndReturnResponse(returnUserInput());
            printToConsole("\n" + res + "\n\n");
        }
    }

    public static String handleInputAndReturnResponse(String input) {
        switch (input) {
            case "1": return handleListBooks();
            case "2": displayLogin();
                return handleBookCheckOut();
            case "3": displayLogin();
                return handleBookCheckIn();
            case "4": displayLogin();
                return handleLoginOrViewAccount();
            case "5": return "Goodbye!";

            default:  return "Select a valid option! Try again:";
        }
    }

    private static String handleLoginOrViewAccount() {
        if (loggedInAccount == null) return "Please try again.";
        return loggedInAccount.buildCustomerInformationString();
    }

    private static String handleListBooks() {
        return bookCatalogue.generateFormattedStringAllAvailableBooks();
    }

    private static String handleBookCheckIn() {
        if (loggedInAccount == null) return "You must be logged in to continue";
        printToConsole("Enter your book title here: ");
        return bookCatalogue.handleCheckInBook(returnUserInput());
    }

    private static String handleBookCheckOut() {
        if (loggedIn()) return "You must be logged in to continue";
        printToConsole("Enter your book title here: ");
        return bookCatalogue.handleCheckOutBook(returnUserInput());
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
                "4: " + accountString + "\n" +
                "5: Quit\n\n";
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