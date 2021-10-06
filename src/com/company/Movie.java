package com.company;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Movie {
    private String name;
    private String date;
    private String genre;
    private int duration;
    private int budget;

    private static ArrayList<Movie> movies = new ArrayList<>();

    public Movie(String name, String date, String genre, int duration, int budget) {
        try {
            if (Pattern.matches("^[A-Z]?[a-z]+\\d?$", name)) {
                this.name = name;
            } else {
                throw new IllegalArgumentException();
            }

            if (Pattern.matches("^\\d{2}\\.\\d{2}\\.\\d{4} \\d{1,2}:\\d{1,2}$", date)) {
                this.date = date;
            } else {
                throw new IllegalArgumentException();
            }

            if (Pattern.matches("^[A-Z]?[a-z]+\s?[a-z]+?$", genre)) {
                this.genre = genre;
            } else {
                throw new IllegalArgumentException();
            }

            if (Pattern.matches("^\\d{2,}$", Integer.toString(duration))) {
                this.duration = duration;
            } else {
                throw new IllegalArgumentException();
            }

            if (Pattern.matches("^\\d{4,}$", Integer.toString(budget))) {
                this.budget = budget;
            } else {
                throw new IllegalArgumentException();
            }
            movies.add(this);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Pattern.matches("^[A-Z]?[a-z]+$", name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (Pattern.matches("^\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}$", date)) {
            this.date = date;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (Pattern.matches("^[A-Z]?[a-z]+ \s?[a-z]+?$", genre)) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (Pattern.matches("^\\d{2,}$", Integer.toString(duration))) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        if (Pattern.matches("^\\d{4,}$", Integer.toString(budget))) {
            this.budget = budget;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void printFilteredMovies() {
        if (movies.size() == 0) {
            System.out.println("Add movies first");
            return;
        }
        ArrayList<Movie> suitableMovies = new ArrayList<>();

        movies.forEach(movie -> {
            int movieDuration = movie.getDuration();
            int startHour = Integer.parseInt(movie.getDate().split(" ")[1].split(":")[0]);

            if (startHour < 18 && movieDuration < 90)
                suitableMovies.add(movie);
        });

        System.out.println("---filtered movies---");
        suitableMovies.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", budget=" + budget +
                '}';
    }
}
