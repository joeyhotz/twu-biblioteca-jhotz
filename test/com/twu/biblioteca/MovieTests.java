package com.twu.biblioteca;

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

        ArrayList<Movie> actualAllMovies = movieCatalogue.returnAllMovies();
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

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.returnAllAvailableMovies();
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

        String outputString = movieCatalogue.handleCheckOut(thisIsTheEndMovie.name);

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.returnAllAvailableMovies();
        ArrayList<Movie> expectedAllAvailableMovies = new ArrayList<Movie>();

        ArrayList<Movie> actualCheckedOutMovies = movieCatalogue.returnAllCheckedOutMovies();
        ArrayList<Movie> expectedCheckedOutMovies = movies;

        assertEquals(expectedAllAvailableMovies, actualAllAvailableMovies);
        assertEquals(expectedCheckedOutMovies, actualCheckedOutMovies);
        assertEquals("Thank you! Enjoy the movie.", outputString);
    }

    @Test
    public void testCantCheckoutInvalidMovie() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        String outputString = movieCatalogue.handleCheckOut(thisIsTheEndMovie.name + "makesitinvalid");
        assertEquals("That movie is not available.", outputString);
    }

    @Test
    public void testCanCheckinMovieAndCatalogueReflectsThis() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        String outputString = movieCatalogue.handleCheckIn(itMovie.name);

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.returnAllAvailableMovies();
        ArrayList<Movie> expectedAllAvailableMovies = movies;

        ArrayList<Movie> actualCheckedOutMovies = movieCatalogue.returnAllCheckedOutMovies();
        ArrayList<Movie> expectedCheckedOutMovies = new ArrayList<Movie>();

        assertEquals(expectedAllAvailableMovies, actualAllAvailableMovies);
        assertEquals(expectedCheckedOutMovies, actualCheckedOutMovies);
        assertEquals("Thank you for returning the movie.", outputString);
    }

    @Test
    public void testCantCheckInInvalidMovie() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        String outputString = movieCatalogue.handleCheckIn(itMovie.name + "makesitinvalid");
        assertEquals("That is not a valid movie to return.", outputString);
    }

    @Test
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
    }

    @Test
    public void testMaxNameLengthFunction() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        int actualMaxLength = movieCatalogue.getMoviesMaxNameLengthForPrintFormatting();
        int expectedMaxLength = 25; //this is the end + 10
        assertEquals(expectedMaxLength, actualMaxLength);
    }

    @Test
    public void testFindMovieByMovieTitle() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        Movie movieFound = movieCatalogue.findMovieByMovieTitle("I.T.");
        assertEquals("I.T.", movieFound.name);
    }

    @Test
    public void testMenuGoodbye() {
        assertEquals("Goodbye!", BibliotecaApp.handleMenuInputAndReturnResponse("8"));
    }

    @Test
    public void testMenuInvalidInput() {
        assertEquals("Select a valid option! Try again:", BibliotecaApp.handleMenuInputAndReturnResponse("invalidoption"));
    }

    @Test
    public void testMenuListMovies() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
        MovieCatalogue movieCatalogue = new MovieCatalogue(movies);

        BibliotecaApp app = new BibliotecaApp(null, movieCatalogue);
        assertEquals(movieCatalogue.generateFormattedStringAllAvailableMovies(), BibliotecaApp.handleMenuInputAndReturnResponse("4"));
    }
}
