package com.twu.biblioteca;

import com.twu.biblioteca.Cataloguing.BookCatalogue;
import com.twu.biblioteca.Cataloguing.MovieCatalogue;
import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.Movie;

import java.util.ArrayList;

/*

THIS FILE CREATES DEMO CATALOGUES FOR TESTING THE USER INTERFACE VISUALLY

*/

public class Demo {
    public static MovieCatalogue demoMovieCatalogue() {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        return new MovieCatalogue(movies);
    }

    public static BookCatalogue demoBookCatalogue() {
        ArrayList<Book> books = new ArrayList<>();
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", true);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", true);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", false);
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);
        return new BookCatalogue(books);
    }

}
