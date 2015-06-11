package com.twu.biblioteca;

import java.util.ArrayList;

public abstract class LibraryItem {
    protected String title, year;

    public LibraryItem(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public abstract ArrayList<String> getAllDetails();

    protected abstract void createColumnHeaders();

    public abstract String toString();

}
