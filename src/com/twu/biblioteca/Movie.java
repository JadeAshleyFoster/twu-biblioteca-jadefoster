package com.twu.biblioteca;

public class Movie extends LibraryItem{
    private String director, rating;

    public Movie(String name, String year, String director, String rating) {
        super(name, year);
        this.director = director;
        this.rating = rating;
        createColumnHeaders();
        createAllDetails();
    }

    public void createColumnHeaders() {
        columnHeaders = new String[4];
        columnHeaders[0] = "NAME";
        columnHeaders[1] = "YEAR";
        columnHeaders[2] = "DIRECTOR";
        columnHeaders[3] = "RATING";
        super.setColumnHeaders(columnHeaders);
    }

    private void createAllDetails() {
        allDetails = new String[4];
        allDetails[0] = title;
        allDetails[1] = year;
        allDetails[2] = director;
        allDetails[3] = rating;
        super.setAllDetails(allDetails);
    }

    public String getRating() {
        return rating;
    }


    public String getDirector() {
        return director;
    }

}
