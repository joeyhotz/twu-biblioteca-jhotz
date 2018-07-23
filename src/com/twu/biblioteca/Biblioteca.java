package com.twu.biblioteca;

import com.twu.biblioteca.Cataloguing.BookCatalogue;
import com.twu.biblioteca.Cataloguing.MovieCatalogue;

import java.util.ArrayList;

public class Biblioteca {
    private static BookCatalogue bookCatalogue = new BookCatalogue(new ArrayList<>());
    private static MovieCatalogue movieCatalogue = new MovieCatalogue(new ArrayList<>());

    public Biblioteca(BookCatalogue bookCatalogue, MovieCatalogue movieCatalogue) {
        if (bookCatalogue != null) this.bookCatalogue = bookCatalogue;
        if (movieCatalogue != null) this.movieCatalogue = movieCatalogue;
    }

    public BookCatalogue getBookCatalogue() {
        return bookCatalogue;
    }

    public MovieCatalogue getMovieCatalogue() {
        return movieCatalogue;
    }
}