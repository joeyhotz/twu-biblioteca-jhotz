package com.twu.biblioteca.Items;

import com.twu.biblioteca.Items.LibraryItem;

public class Movie extends LibraryItem {
    private String director;
    private int rating;

    public Movie(String name, String director, String year, int rating, boolean checkedOut) {
        super(name, year, checkedOut);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() { return this.director; }
    public int getRating() { return this.rating; }
}
