package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.print("Hello! Welcome to Biblioteca.\n\nHere are our list of books: \n");
        System.out.print(availableBooksAsString());
    }

    public static ArrayList<Book> getAvailableBooks(){
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        Book harryPotter = new Book();
        harryPotter.name = "Harry Potter";
        availableBooks.add(harryPotter);
        return availableBooks;
    }

    public static String availableBooksAsString(){
        ArrayList<Book> availableBooks = getAvailableBooks();
        String output = "";
        for (Book book: availableBooks) {
            output += book.name + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }
}
