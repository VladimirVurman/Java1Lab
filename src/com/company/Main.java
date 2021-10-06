package com.company;

public class Main {

    public static void main(String[] args) {
        var employee = new Employee("Qwe", "middle", 1900, 2342234, "secondary");
        var employee1 = new Employee("Qdfwe", "junior", 2000, 2342234, "primary");
        var employee2 = new Employee("Qdgwe", "senior", 1934, 123, "nice");
        var employee3 = new Employee("Qwfe", "misddle", 1940, 2342234, "exellent");
        Employee.findEmployees();

        var movie = new Movie("Movie0", "12.12.2000 15:30", "sci fiction", 70, 2145);
        var movie1 = new Movie("Movie1", "12.12.2000 15:30", "drama", 100, 21445);
        var movie2 = new Movie("Movie2", "12.12.2000 15:30", "western", 66, 21245);
        var movie3 = new Movie("Movie3", "12.12.2000 15:30", "western", 119, 21415);
        var movie4 = new Movie("Movie4", "12.12.2000 15:30", "documentary", 123, 2166545);
        var movie5 = new Movie("Movie5", "12.12.2000 15:30", "cartoon", 50, 22134145);

        Movie.printFilteredMovies();

    }
}



