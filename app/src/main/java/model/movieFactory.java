package model;

public class movieFactory {
    public IMovieData getModel() {
        return new movieData();
    }
}
