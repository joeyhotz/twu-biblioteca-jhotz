package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    final public static ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>() {{
        add(new MenuOption(1, "List Books"));
        add(new MenuOption(2, "Checkout Book"));
        add(new MenuOption(3, "Return Book"));
        add(new MenuOption(4, "Quit"));
    }};

    public static void displayMenu() {
        String input = "";
        while (!input.equals("4")) {
            System.out.println(generateMenuStringToDisplay());
            System.out.print("Enter a number here to select an option: ");
            input = String.format(sc.nextLine());
            handleInput(input);

        }
    }

    private static void handleInput(String input) {
        switch (input) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4": System.out.print("Goodbye!");
                break;
            default: System.out.println("Select a valid option! Try again.");
                break;
        }
    }

    public static String generateMenuStringToDisplay() {
        String output = "";
        for (MenuOption menuOption: menuOptions) {
            output += menuOption.getInt() + ": " + menuOption.getString() + "\n";
        }
        return output;
    }
}
