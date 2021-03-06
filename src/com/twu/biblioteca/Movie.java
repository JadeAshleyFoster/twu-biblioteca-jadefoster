package com.twu.biblioteca;

import java.util.ArrayList;

public class Movie extends LibraryItem{
    private String director, rating;
    private static ArrayList<String> columnHeaders;


    public Movie(String name, String year, String director, String rating) {
        super(name, year);
        this.director = director;
        this.rating = rating;
        createColumnHeaders();
    }

    public void createColumnHeaders() {
        columnHeaders = new ArrayList<String>();
        columnHeaders.add("NAME");
        columnHeaders.add("YEAR");
        columnHeaders.add("DIRECTOR");
        columnHeaders.add("RATING");
        columnHeaders.add("STATUS");
    }

    public static ArrayList<String> getColumnHeaders() {
        return columnHeaders;
    }

    public static int getNumberOfColumns() {
        return columnHeaders.size();
    }

    public ArrayList<String> getAllDetails(Loginable user) {
        ArrayList<String> allDetails = new ArrayList<String>();
        allDetails.add(title);
        allDetails.add(year);
        allDetails.add(director);
        allDetails.add(rating);
        allDetails.add(available(user));
        return allDetails;
    }

    public String toString() {
        return "movie";
    }


}
