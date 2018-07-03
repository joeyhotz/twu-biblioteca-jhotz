package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.print(stringWelcomeMessage());
        System.out.print(stringListOfBooks(Book.listOfBooksForDemo()));
    }

    public static String stringWelcomeMessage() {
        return "Hello! Welcome to Biblioteca.\n\nHere are our list of books: \n";
    }

    public static String stringListOfBooks(ArrayList<Book> books) {
        return availableBooksAsString(books);
    }

    public static String availableBooksAsString(ArrayList<Book> books){
        ArrayList<Book> availableBooks = books;
        String output = "";
        for (Book book: availableBooks) {
            output += book.name + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }
}
