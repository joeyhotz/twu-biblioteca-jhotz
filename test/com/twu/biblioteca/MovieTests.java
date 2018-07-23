package com.twu.biblioteca;

import com.twu.biblioteca.Cataloguing.MovieCatalogue;
import com.twu.biblioteca.Items.LibraryItem;
import com.twu.biblioteca.Items.Movie;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class MovieTests {
    @Test
    public void testReturnsAllMovies() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        ArrayList<Movie> actualAllMovies = movieCatalogue.getAll();
        ArrayList<Movie> expectedAllMovies = movies;
        assertEquals(expectedAllMovies, actualAllMovies);
    }

    @Test
    public void testReturnsAllAvailableMovies() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.getAllAvailable();
        ArrayList<Movie> expectedAllAvailableMovies = new ArrayList<>();
        expectedAllAvailableMovies.add(thisIsTheEndMovie);

        assertEquals(expectedAllAvailableMovies, actualAllAvailableMovies);
    }

    @Test
    public void testCanCheckoutMovieAndCatalogueReflectsThis() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        movieCatalogue.checkOut(thisIsTheEndMovie.getName());

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.getAllAvailable();
        ArrayList<Movie> expectedAllAvailableMovies = new ArrayList<Movie>();

        assertEquals(expectedAllAvailableMovies, actualAllAvailableMovies);
    }

/*    @Test
    public void testCantCheckoutInvalidMovie() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        movieCatalogue.checkOut(thisIsTheEndMovie.getName() + "makesitinvalid");
        assertEquals("That movie is not available.", outputString);
    }*/

    @Test
    public void testCanCheckinMovieAndCatalogueReflectsThis() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        movieCatalogue.checkIn(itMovie.getName());

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.getAllAvailable();
        ArrayList<Movie> expectedAllAvailableMovies = movies;

        assertEquals(expectedAllAvailableMovies, actualAllAvailableMovies);
    }

    /*@Test
    public void testCantCheckInInvalidMovie() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        movieCatalogue.checkIn(itMovie.getName() + "makesitinvalid");
        assertEquals("That is not a valid movie to return.", outputString);
    }*/

/*    @Test
    public void testGeneratedStringAllAvailableMovies() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        String actualOutputString = movieCatalogue.generateFormattedStringAllAvailableMovies();
        String format = "%-" + movieCatalogue.getMoviesMaxNameLengthForPrintFormatting() + "s %-30s %-20s %-10s\n";
        String expectedOutputString = "Available Movies\n----------------\n" + String.format(format, "MOVIE NAME", "DIRECTOR", "YEAR", "RATING") + "\n";

        for(Movie movie: movieCatalogue.returnAllAvailableMovies()) {
            expectedOutputString = expectedOutputString.concat(String.format(format, movie.name, movie.director, movie.year, movie.rating));
        }

        assertEquals(expectedOutputString, actualOutputString);
    }*/


    @Test
    public void testFindMovieByMovieTitle() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        LibraryItem movieFound = movieCatalogue.findByTitle("I.T.");
        assertEquals("I.T.", movieFound.getName());
    }


    /*@Test
    public void testMenuListMovies() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        BibliotecaApp app = new BibliotecaApp(null, movieCatalogue);
        assertEquals(movieCatalogue.generateFormattedStringAllAvailableMovies(), app.getMenu().handleMenuInputAndReturnResponse("4"));
    }*/
}
