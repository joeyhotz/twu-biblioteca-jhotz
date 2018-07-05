package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieCatalogue {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieCatalogue() {
        //for demo
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
    }

    public MovieCatalogue(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> returnAllMovies() {
        return movies;
    }
    
    public ArrayList<Movie> returnAllAvailableMovies() {
        ArrayList<Movie> availableMovies = new ArrayList<>();
        for(Movie movie: movies) {
            if (!movie.checkedOut) availableMovies.add(movie);
        }
        return availableMovies;
    }


    public ArrayList<Movie> returnAllCheckedOutMovies() {
        ArrayList<Movie> checkedOutMovies = new ArrayList<>();
        for(Movie movie: movies) {
            if (movie.checkedOut) checkedOutMovies.add(movie);
        }
        return checkedOutMovies;
    }

    public String generateFormattedStringAllAvailableMovies() {
        String format = "%-" + getMoviesMaxNameLengthForPrintFormatting() + "s %-30s %-20s %-10s\n";
        String output = "Available Movies\n----------------\n" + String.format(format, "MOVIE NAME", "DIRECTOR", "YEAR", "RATING") + "\n";

        for (Movie movie: returnAllAvailableMovies()) {
            output = output.concat(String.format(format, movie.name, movie.director, movie.year, movie.rating));
        }
        return output;
    }

    public String handleCheckOut(String movieTitle) {
        Movie movie = findMovieByMovieTitle(movieTitle);
        if (movie == null) return("That movie is not available.");
        if (!movie.checkedOut) {
            movie.toggleCheckedOutStatus();
            return("Thank you! Enjoy the movie.");
        } else {
            return("That movie is not available.");
        }
    }

    public String handleCheckIn(String movieTitle) {
        Movie movie = findMovieByMovieTitle(movieTitle);
        if (movie == null) return("That is not a valid movie to return.");
        if (movie.checkedOut) {
            movie.toggleCheckedOutStatus();
            return("Thank you for returning the movie.");
        } else {
            return("That is not a valid movie to return.");
        }
    }

    public Movie findMovieByMovieTitle(String movieTitle) {
        for (Movie movie: returnAllMovies()) {
            if (movie.name.equals(movieTitle)) {
                return movie;
            }
        }
        return null;
    }

    public int getMoviesMaxNameLengthForPrintFormatting() {
        int max = 0;
        for (Movie movie: returnAllAvailableMovies()) {
            if (movie.name.length() > max) max = movie.name.length();
        }
        return max + 10;
    }
}