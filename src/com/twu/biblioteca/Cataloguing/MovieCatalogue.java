package com.twu.biblioteca.Cataloguing;

import com.twu.biblioteca.Items.Movie;

import java.util.ArrayList;

public class MovieCatalogue extends Catalogue {
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieCatalogue() {
        Movie itMovie = new Movie("I.T.", "Andrés Muschietti", "2017", 8, true);
        Movie thisIsTheEndMovie = new Movie("This is the end", "Seth Rogen/Steven Goldberg", "2013", 6, false);
        movies.add(itMovie);
        movies.add(thisIsTheEndMovie);
    }

    public MovieCatalogue(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getAll() { return movies; }

    public ArrayList<Movie> getAllAvailable() {
        ArrayList<Movie> availableMovies = new ArrayList<>();
        for(Movie movie: movies) { if (movie.isAvailable()) availableMovies.add(movie); }
        return availableMovies;
    }

    public void listAllAvailable() {
        String format = "%-100s %-30s %-20s %-10s\n";
        String output = "Available Movies\n----------------\n" + String.format(format, "MOVIE NAME", "DIRECTOR", "YEAR", "RATING") + "\n";
        for (Movie movie: getAllAvailable()) {
            output = output.concat(String.format(format, movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating()));
        }
        System.out.print(output);
    }
}
