package com.twu.biblioteca;

public abstract class LibraryItem {
    protected String title, year;
    protected String[] columnHeaders, allDetails;

    public LibraryItem(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String[] getColumnHeaders() {
        return columnHeaders;
    }

    protected void setColumnHeaders(String[] columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public String[] getAllDetails() {
        return allDetails;
    }

    protected void setAllDetails(String[] allDetails) {
        this.allDetails = allDetails;
    }


}
