package com.twu.biblioteca;

import java.util.ArrayList;

public abstract class LibraryItem {
    protected String title, year, type;

    public LibraryItem(String title, String year, String typeOfItem) {
        this.title = title;
        this.year = year;
        type = typeOfItem;
    }

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getAllDetails() {
        ArrayList<String> allDetails = new ArrayList<String>();
        allDetails.add(title);
        allDetails.add(year);
        return allDetails;
    }

}
