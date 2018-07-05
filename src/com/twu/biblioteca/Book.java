package com.twu.biblioteca;

public class Book extends LibraryItem {
    public String author;

    public Book(String name, String author, String yearPublished, boolean checkedOut) {
        this.name = name;
        this.author = author;
        this.year = yearPublished;
        this.checkedOut = checkedOut;
    }
}
