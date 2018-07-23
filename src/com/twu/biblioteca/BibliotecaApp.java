package com.twu.biblioteca;


import com.twu.biblioteca.Cataloguing.BookCatalogue;
import com.twu.biblioteca.Cataloguing.MovieCatalogue;

public class BibliotecaApp {
    private Biblioteca biblioteca;
    private Menu menu;
    private UserManager userm;

    public BibliotecaApp() {
        biblioteca = new Biblioteca();
        userm = new UserManager();
        menu = new Menu(biblioteca, userm);
    }

    public BibliotecaApp(BookCatalogue bc, MovieCatalogue mc) {
        biblioteca = new Biblioteca(bc, mc);
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

    public Menu getMenu() {
        return menu;
    }
}