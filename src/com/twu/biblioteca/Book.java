package com.twu.biblioteca;

import java.util.ArrayList;

public class Book extends LibraryItem {
    private String author;
    private static ArrayList<String> columnHeaders;

    public Book(String title, String author, String yearPublished) {
        super(title, yearPublished);
        this.author = author;
        createColumnHeaders();
    }

    protected void createColumnHeaders() {
        columnHeaders = new ArrayList<String>();
        columnHeaders.add("TITLE");
        columnHeaders.add("AUTHOR");
        columnHeaders.add("YEAR PUBLISHED");
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
        allDetails.add(author);
        allDetails.add(year);
        allDetails.add(available(user));
        return allDetails;
    }

    public String toString() {
        return "book";
    }

}
