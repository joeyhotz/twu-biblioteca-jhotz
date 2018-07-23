package com.twu.biblioteca.Items;

import com.twu.biblioteca.Items.LibraryItem;

public class Book extends LibraryItem {
    private String author;

    public Book(String name, String author, String year, boolean checkedOut) {
        super(name, year, checkedOut);
        this.author = author;
    }

    public String getAuthor() { return this.author; }
}
