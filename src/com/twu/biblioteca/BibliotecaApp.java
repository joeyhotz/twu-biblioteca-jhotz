package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    public static BookCatalogue bookCatalogue = new BookCatalogue();
    private static Scanner sc = new Scanner(System.in);
    final public static ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>() {{
        add(new MenuOption(1, "List Books"));
        add(new MenuOption(2, "Checkout Book"));
        add(new MenuOption(3, "Return Book"));
        add(new MenuOption(4, "Quit"));
    }};

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        printToConsole(returnWelcomeMessage());
        String input = "";
        String output = "";
        while (!input.equals("4")) {
            BibliotecaApp.printToConsole(generateMenuStringToDisplay());
            input = returnUserInput("Enter a number here to select an option: ");
            output = handleInput(input);
            BibliotecaApp.printToConsole("\n" + output + "\n");
        }
    }

    private static String handleInput(String input) {
        String res = null;
        switch (input) {
            case "1": res = bookCatalogue.generateFormattedStringAllAvailableBooks();
                break;
            case "2": res = bookCatalogue.checkOutBook(returnUserInput("Enter your book title here: "));
                break;
            case "3": res = bookCatalogue.checkInBook(returnUserInput("Enter your book title here: "));
                break;
            case "4": res = "Goodbye!";
                break;
            default: res = "Select a valid option! Try again:";
                break;
        }
        return res;
    }

    public static String returnUserInput(String prompt) {
        printToConsole(prompt);
        return String.format(sc.nextLine());
    }

    public static String generateMenuStringToDisplay() {
        String output = "";
        for (MenuOption menuOption : menuOptions) {
            output += menuOption.getInt() + ": " + menuOption.getString() + "\n";
        }
        return output;
    }


    public static String returnWelcomeMessage() {
        return "Hello! Welcome to Biblioteca.\n\nWhat would you like to do?\n\n";
    }

    public static void printToConsole(String out) {
        System.out.print(out);
    }
}