package com.twu.biblioteca.Cataloguing;

import com.twu.biblioteca.Items.Movie;

import java.util.ArrayList;

public class MovieCatalogue extends Catalogue {
    private ArrayList<Movie> movies;

    public MovieCatalogue(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getAll() {
        return movies;
    }

    public ArrayList<Movie> getAllAvailable() {
        ArrayList<Movie> availableMovies = new ArrayList<>();
        for(Movie movie: movies) { if (movie.isAvailable()) availableMovies.add(movie); }
        return availableMovies;
    }

    public void listAllAvailable() {
        String format = "%-100s %-30s %-20s %-10s\n";
        System.out.print(buildHeader(format) + buildContent(format));
    }

    private String buildHeader(String format) {
        return "Available Movies\n----------------\n" + String.format(format, "MOVIE NAME", "DIRECTOR", "YEAR", "RATING") + "\n";
    }

    private String buildContent(String format) {
        String content = "";
        for (Movie movie: getAllAvailable()) {
            content = content.concat(String.format(format, movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating()));
        }
        return content;
    }
}
