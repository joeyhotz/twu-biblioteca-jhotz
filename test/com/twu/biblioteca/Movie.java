package com.twu.biblioteca;

public class Movie extends LibraryItem {
    public String director;
    public int rating;

    public Movie(String name, String director, String year, boolean checkedOut) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.checkedOut = checkedOut;
    }
}
