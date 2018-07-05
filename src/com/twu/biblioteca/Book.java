package com.twu.biblioteca;

public class Book extends LibraryItem {
    public String author;

    public Book(String name, String author, String year, boolean checkedOut) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.checkedOut = checkedOut;
    }
}
