package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    final public static ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>() {{
        add(new MenuOption(1, "List Books"));
        add(new MenuOption(2, "Checkout Book"));
        add(new MenuOption(3, "Return Book"));
    }};

    public static void displayMenu() {
        System.out.println("Enter a number to select the option.");
        System.out.println(generateMenuStringToDisplay());
    }

    public static String generateMenuStringToDisplay() {
        String output = "";
        for (MenuOption menuOption: menuOptions) {
            output += menuOption.getInt() + ": " + menuOption.getString() + "\n";
        }
        return output;
    }

}
