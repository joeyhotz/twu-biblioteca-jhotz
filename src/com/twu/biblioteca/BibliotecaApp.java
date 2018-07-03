package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.print(returnWelcomeMessage());
        Menu menu = new Menu();
        menu.displayMenu();
    }

    public static String returnWelcomeMessage() {
        return "Hello! Welcome to Biblioteca.\nWhat would you like to do?\n";
    }
}