package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class MovieTests {
    @Test
    public void testReturnsAllMovies() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();

        ArrayList<Movie> actualAllMovies = movieCatalogue.returnAllMovies();
        ArrayList<Movie> expectedAllMovies = returnListOfMovies();
        assertEquals(expectedAllMovies.size(), actualAllMovies.size());
    }

    @Test
    public void testReturnsAllAvailableMovies() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.returnAllAvailableMovies();
        ArrayList<Movie> expectedAllAvailableMovies = new ArrayList<>();
        expectedAllAvailableMovies.add(thisIsTheEndMovie);

        assertTrue(checkIfTwoListOfMoviesAreEqual(expectedAllAvailableMovies, actualAllAvailableMovies));
    }

    @Test
    public void testCanCheckoutMovieAndCatalogueReflectsThis() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        var outputString = movieCatalogue.handleCheckOut(thisIsTheEndMovie.name);

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.returnAllAvailableMovies();
        ArrayList<Movie> expectedAllAvailableMovies = new ArrayList<Movie>();

        ArrayList<Movie> actualCheckedOutMovies = movieCatalogue.returnAllCheckedOutMovies();
        ArrayList<Movie> expectedCheckedOutMovies = returnListOfMovies();

        assertTrue(checkIfTwoListOfMoviesAreEqual(expectedAllAvailableMovies, actualAllAvailableMovies));
        assertTrue(checkIfTwoListOfMoviesAreEqual(expectedCheckedOutMovies, actualCheckedOutMovies));
        assertEquals("Thank you! Enjoy the movie.", outputString);
    }

    @Test
    public void testCantCheckoutInvalidMovie() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        var outputString = movieCatalogue.handleCheckOut(thisIsTheEndMovie.name + "makesitinvalid");
        assertEquals("That movie is not available.", outputString);
    }

    @Test
    public void testCanCheckinMovieAndCatalogueReflectsThis() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);

        var outputString = movieCatalogue.handleCheckIn(itMovie.name);

        ArrayList<Movie> actualAllAvailableMovies = movieCatalogue.returnAllAvailableMovies();
        ArrayList<Movie> expectedAllAvailableMovies = returnListOfMovies();

        ArrayList<Movie> actualCheckedOutMovies = movieCatalogue.returnAllCheckedOutMovies();
        ArrayList<Movie> expectedCheckedOutMovies = new ArrayList<Movie>();

        assertTrue(checkIfTwoListOfMoviesAreEqual(expectedAllAvailableMovies, actualAllAvailableMovies));
        assertTrue(checkIfTwoListOfMoviesAreEqual(expectedCheckedOutMovies, actualCheckedOutMovies));
        assertEquals("Thank you for returning the movie.", outputString);
    }

    @Test
    public void testCantCheckInInvalidMovie() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);

        var outputString = movieCatalogue.handleCheckIn(itMovie.name + "makesitinvalid");
        assertEquals("That is not a valid movie to return.", outputString);
    }

    @Test
    public void testGeneratedStringAllAvailableMovies() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();

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
        MovieCatalogue movieCatalogue = fillMovieCatalogue();

        int actualMaxLength = movieCatalogue.getMoviesMaxNameLengthForPrintFormatting();
        int expectedMaxLength = 25; //this is the end + 10
        assertEquals(expectedMaxLength, actualMaxLength);
    }

    @Test
    public void testFindMovieByMovieTitle() {
        MovieCatalogue movieCatalogue = fillMovieCatalogue();

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
        MovieCatalogue movieCatalogue = fillMovieCatalogue();

        BibliotecaApp app = new BibliotecaApp();
        app.movieCatalogue = movieCatalogue;
        assertEquals(movieCatalogue.generateFormattedStringAllAvailableMovies(), BibliotecaApp.handleMenuInputAndReturnResponse("4"));
    }

    public MovieCatalogue fillMovieCatalogue() {
        MovieCatalogue movieCatalogue = new MovieCatalogue(returnListOfMovies());

        return movieCatalogue;
    }

    public ArrayList<Movie> returnListOfMovies() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);

        return movies;
    }

    public boolean checkIfTwoListOfMoviesAreEqual(ArrayList<Movie> one, ArrayList<Movie> two) {
        ArrayList<Movie> checkList = new ArrayList<Movie>();
        int count = 0;
        checkList.addAll(one);

        for (Movie movie: checkList) {
            for (Movie movie2: two) {
                if (movie.name == movie2.name) {
                    count++;
                    break;
                }
            }
        }
        return (checkList.size() == count);
    }

    @Test
    public void testcheckIfTwoListOfMoviesAreEqual() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);

        Movie itMovie2 = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie2 = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);

        ArrayList<Movie> movies2 = new ArrayList<>();
        movies2.add(itMovie);
        movies2.add(thisIsTheEndMovie);

        assertTrue(checkIfTwoListOfMoviesAreEqual(movies, movies2));
    }
}
