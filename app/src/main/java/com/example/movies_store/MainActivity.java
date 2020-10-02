package com.example.movies_store;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import model.IMovieData;
import model.movie;
import model.movieFactory;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layoutMovies;
    private EditText title;
    private Spinner yearsSpinner;
    private Spinner genresSpinner;
    private CheckBox titleCheckBox;
    private CheckBox yearCheckBox;
    private CheckBox genreCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide title bar
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_main);
        layoutMovies = findViewById(R.id.layoutMovies);
        yearsSpinner = findViewById(R.id.spinYears);
        yearsSpinner.setEnabled(false);
        genresSpinner = findViewById(R.id.spinGenres);
        genresSpinner.setEnabled(false);
        title = findViewById(R.id.editTitle);
        title.setEnabled(false);

        titleCheckBox = findViewById(R.id.boxTitle);
        yearCheckBox = findViewById(R.id.boxYear);
        genreCheckBox = findViewById(R.id.boxGenre);
        this.populateAllMovies();
        this.populateYearsSpinner();
        this.populateGenresSpinner();
    }

    public void populateYearsSpinner() {
        movieFactory factory = new movieFactory();
        IMovieData objMovie = factory.getModel();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, objMovie.getYears());
        yearsSpinner.setAdapter(adapter);
    }

    public void populateGenresSpinner() {
        movieFactory factory = new movieFactory();
        IMovieData objMovie = factory.getModel();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, objMovie.getGenres());
        genresSpinner.setAdapter(adapter);
    }

    @SuppressLint("ResourceAsColor")
    public void populateAllMovies() {
        layoutMovies.removeAllViews();
        movieFactory factory = new movieFactory();
        IMovieData objMovie = factory.getModel();
        ArrayList<movie> movieList = objMovie.getMovies();
        for (movie m : movieList) {

            TextView singleMovie = new TextView(this);
            singleMovie.setText(m.getTitle());
            singleMovie.setText(m.getTitle() + " " + m.getGene() + " " + m.getYear());
            singleMovie.setBackgroundColor(R.color.colorAccent);
            singleMovie.setHeight(200);
            singleMovie.setTextColor(Color.WHITE);
            singleMovie.setTextSize(20);
            singleMovie.setPadding(100, 50, 100, 50);
            layoutMovies.addView(singleMovie);

        }
    }

    @SuppressLint("ResourceAsColor")
    public void searchButtonOnClick(View view) {
        String title = "";
        String genre = "";
        int year = 0;
        layoutMovies.removeAllViews();
        if (titleCheckBox.isChecked()) {
            title = this.title.getText().toString();
        }

        if (genreCheckBox.isChecked()) {
            genre = genresSpinner.getSelectedItem().toString();
        }

        if (yearCheckBox.isChecked()) {
            year = Integer.parseInt(yearsSpinner.getSelectedItem().toString());
        }


        movieFactory factory = new movieFactory();
        IMovieData objMovie = factory.getModel();
        ArrayList<movie> movieList = objMovie.searchMovies(title, genre, year);
        layoutMovies.removeAllViews();
        for (movie m : movieList) {
            TextView singleMovie = new TextView(this);
            singleMovie.setText(m.getTitle() + " " + m.getGene() + " " + m.getYear());
            singleMovie.setBackgroundColor(R.color.colorAccent);
            singleMovie.setHeight(200);
            singleMovie.setTextColor(Color.WHITE);
            singleMovie.setTextSize(20);
            singleMovie.setPadding(100, 50, 100, 50);
            layoutMovies.addView(singleMovie);

        }


    }


    public void boxGenreOnClick(View view) {
        genresSpinner.setEnabled(!genresSpinner.isEnabled());
    }

    public void boxYearOnClick(View view) {
        yearsSpinner.setEnabled(!yearsSpinner.isEnabled());
    }

    public void boxTitleOnClick(View view) {
        title.setEnabled(!title.isEnabled());
    }
}