package model;

import java.util.ArrayList;

public interface IMovieData {
    ArrayList<movie> getMovies();

    String[] getYears();

    String[] getGenres();

    ArrayList<movie> searchMovies(String title, String genre, int year);

}
