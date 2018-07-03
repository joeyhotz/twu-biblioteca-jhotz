package com.twu.biblioteca;

import java.util.ArrayList;

public class Book {
    public String name;

    public static void main(String[] args){

    }

    public static ArrayList<Book> listOfBooksForDemo() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book harryPotterBook = new Book(){{ name = "Harry Potter"; }};
        Book gameOfThronesBook = new Book(){{ name = "Game of Thrones"; }};
        listOfBooks.add(harryPotterBook);
        listOfBooks.add(gameOfThronesBook);
        return listOfBooks;
    }
}
