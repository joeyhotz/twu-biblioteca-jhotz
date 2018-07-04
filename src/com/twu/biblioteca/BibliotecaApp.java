package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    public static BookCatalogue bookCatalogue = new BookCatalogue();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
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
            case "2": return handleBookCheckOut();
            case "3": return handleBookCheckIn();
            case "4": return "Goodbye!";
            default:  return "Select a valid option! Try again:";
        }
    }

    private static String handleListBooks() {
        return bookCatalogue.generateFormattedStringAllAvailableBooks();
    }

    private static String handleBookCheckIn() {
        printToConsole("Enter your book title here: ");
        return bookCatalogue.handleCheckInBook(returnUserInput());
    }

    private static String handleBookCheckOut() {
        printToConsole("Enter your book title here: ");
        return bookCatalogue.handleCheckOutBook(returnUserInput());
    }

    public static String returnUserInput() {
        return String.format(sc.nextLine());
    }

    public static String generateMenuStringToDisplay() {
        String output = "";
        for (MenuOption menuOption : MenuOptions.data) {
            output += menuOption.getInt() + ": " + menuOption.getString() + "\n";
        }
        return output;
    }

    public static void printToConsole(String out) {
        System.out.print(out);
    }
}