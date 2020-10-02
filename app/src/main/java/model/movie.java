package model;

public class movie {
    private String title;
    private int year;
    private String gene;

    public movie(String title, int year, String gene) {
        this.title = title;
        this.year = year;
        this.gene = gene;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

}
