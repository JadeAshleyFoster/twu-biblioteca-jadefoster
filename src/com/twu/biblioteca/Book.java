package com.twu.biblioteca;

public class Book extends LibraryItem {
    private String author;

    public Book(String title, String author, String yearPublished) {
        super(title, yearPublished);
        this.author = author;
        createColumnHeaders();
        createAllDetails();
    }

    private void createColumnHeaders() {
        columnHeaders = new String[2];
        columnHeaders[0] = "TITLE";
        columnHeaders[1] = "AUTHOR";
        columnHeaders[2] = "YEAR PUBLISHED";
        super.setColumnHeaders(columnHeaders);
    }

    private void createAllDetails() {
        allDetails = new String[2];
        allDetails[0] = title;
        allDetails[1] = author;
        allDetails[2] = year;
        super.setColumnHeaders(allDetails);
    }

    public String getAuthor() {
        return author;
    }

    public String[] getAllDetails() {
        return allDetails;
    }

}
