package model;

import java.util.ArrayList;


public class movieData implements IMovieData {
    private ArrayList<movie> movieList = new ArrayList<>();

    public movieData() {
        movieList.add(new movie("Tenet", 2020, "Action"));
        movieList.add(new movie("Bill and Ted", 2004, "Music"));
        movieList.add(new movie("Your Name", 2016, "Animation"));
        movieList.add(new movie("Deadpool", 2015, "comedy"));
        movieList.add(new movie("LA 92", 2017, "Documentary"));
    }

    @Override
    public ArrayList<movie> getMovies() {
        return this.movieList;
    }

    @Override
    public String[] getYears() {
        String[] years = new String[movieList.size()];
        int counter = 0;
        for (movie m : movieList) {
            years[counter] = String.valueOf(m.getYear());
            counter++;
        }
        return years;
    }

    @Override
    public String[] getGenres() {
        String[] genres = new String[movieList.size()];
        int counter = 0;
        for (movie m : movieList) {
            genres[counter] = m.getGene();
            counter++;
        }
        return genres;
    }

    @Override
    public ArrayList<movie> searchMovies(String title, String genre, int year) {

        ArrayList<movie> resultSet = new ArrayList<>();
        resultSet.clear();
        boolean searchByTitle = !title.equals("");
        boolean searchByGenre = !genre.equals("");
        boolean searchByYear = year != 0;


        if (searchByTitle && searchByGenre && searchByYear) {
            for (movie m : movieList) {
                if (m.getTitle().contains(title) && m.getGene().equals(genre) && m.getYear() == year) {
                    resultSet.add(m);
                }
            }
            return resultSet;
        }
        if (searchByTitle && searchByGenre) {
            for (movie m : movieList) {
                if (m.getTitle().contains(title) && m.getGene().equals(genre)) {
                    resultSet.add(m);
                }
            }
            return resultSet;
        }
        if (searchByTitle && searchByYear) {
            for (movie m : movieList) {
                if (m.getTitle().contains(title) && m.getYear() == year) {
                    resultSet.add(m);
                }
            }
            return resultSet;
        }
        if (searchByYear && searchByGenre) {
            for (movie m : movieList) {
                if (m.getGene().equals(genre) && m.getYear() == year) {
                    resultSet.add(m);
                }
            }
            return resultSet;
        }
        if (searchByTitle) {
            for (movie m : movieList) {
                if (m.getTitle().contains(title)) {
                    resultSet.add(m);
                }
            }
            return resultSet;
        }
        if (searchByGenre) {
            for (movie m : movieList) {
                if (m.getGene().equals(genre)) {
                    resultSet.add(m);
                }
            }
            return resultSet;
        }
        if (searchByYear) {
            for (movie m : movieList) {
                if (m.getYear() == year) {
                    resultSet.add(m);
                }
            }
            return resultSet;
        }

        return movieList;
    }


}
