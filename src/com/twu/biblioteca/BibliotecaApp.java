package com.twu.biblioteca;


public class BibliotecaApp {
    private Biblioteca biblioteca;
    private Menu menu;
    private UserManager userm;

    public BibliotecaApp() {
        biblioteca = new Biblioteca(Demo.demoBookCatalogue(), Demo.demoMovieCatalogue()); //loads demo catalogues
        userm = new UserManager();
        menu = new Menu(biblioteca, userm);
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    private void start() {
        System.out.println("Welcome to Biblioteca");
        menu.run();
    }

    public UserManager getUserManager() {
        return userm;
    }
}