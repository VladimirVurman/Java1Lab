package com.company;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Employee {
    private String surname;
    private String workingPosition;
    private int birthYear;
    private double salary;
    private String education;

    private static final ArrayList<Employee> employees = new ArrayList<>();

    public Employee(String surname, String workingPosition, int birthYear, double salary, String education) {
        try {
            if (Pattern.matches("^[A-Z]?[a-z]+$", surname)) {
                this.surname = surname;
            } else {
                throw new IllegalArgumentException();
            }

            if (Pattern.matches("^[A-Z]?[a-z]+$", workingPosition)) {
                this.workingPosition = workingPosition;
            } else {
                throw new IllegalArgumentException();
            }

            if (Pattern.matches("^\\d{4}$", Integer.toString(birthYear))) {
                this.birthYear = birthYear;
            } else {
                throw new IllegalArgumentException();
            }

            if (salary > 0) {
                this.salary = salary;
            } else {
                throw new IllegalArgumentException();
            }

            if (Pattern.matches("^[A-Z]?[a-z]{4,}", education)) {
                this.education = education;
            } else {
                throw new IllegalArgumentException();
            }

            employees.add(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (Pattern.matches("^[A-Z][a-z]+$", surname)) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getWorkingPosition() {
        return workingPosition;
    }

    public void setWorkingPosition(String workingPosition) {
        if (Pattern.matches("^[A-Z][a-z]+", workingPosition)) {
            this.workingPosition = workingPosition;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthDate(int birthYear) {
        if (Pattern.matches("^\\d{4}$", Integer.toString(birthYear))) {
            this.birthYear = birthYear;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        if (Pattern.matches("^[A-Z][a-z]{4,}", education)) {
            this.education = education;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void findEmployees() {
        if (employees.size() == 0) {
            System.out.println("Add employees");
            return;
        }

        ArrayList<Employee> suitableEmployees = employees.stream().filter(employee ->
                2021 - employee.getBirthYear() >= 60).collect(Collectors.toCollection(ArrayList::new));

        System.out.printf("Amount of employees elder than 60: %d\n", suitableEmployees.size());
        suitableEmployees.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", workingPosition='" + workingPosition + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", salary=" + salary +
                ", education='" + education + '\'' +
                '}';
    }
}