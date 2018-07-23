package com.twu.biblioteca;

import com.twu.biblioteca.Cataloguing.BookCatalogue;
import com.twu.biblioteca.Cataloguing.MovieCatalogue;

public class Biblioteca {
    private static BookCatalogue bookCatalogue = new BookCatalogue();
    private static MovieCatalogue movieCatalogue = new MovieCatalogue();

    public Biblioteca(BookCatalogue bookCatalogue, MovieCatalogue movieCatalogue) {
        if (bookCatalogue != null) this.bookCatalogue = bookCatalogue;
        if (movieCatalogue != null) this.movieCatalogue = movieCatalogue;
    }

    public Biblioteca() { }


    public static void main(String[] args) {

    }

    public BookCatalogue getBookCatalogue() {
        return bookCatalogue;
    }

    public MovieCatalogue getMovieCatalogue() {
        return movieCatalogue;
    }
}