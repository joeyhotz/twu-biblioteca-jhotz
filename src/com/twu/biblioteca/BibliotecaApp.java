package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.print("Hello! Welcome to Biblioteca.\n\nHere are our list of books: \n");
        System.out.print(availableBooksAsString());
    }

    public static ArrayList<Book> getAvailableBooks(){
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        Book harryPotterBook = new Book(){{ name = "Harry Potter"; }};
        Book gameOfThronesBook = new Book(){{ name = "Game of Thrones"; }};
        availableBooks.add(harryPotterBook);
        availableBooks.add(gameOfThronesBook);
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
