package com.twu.biblioteca;

public abstract class LibraryItem {
    protected String title, year, type;
    protected String[] columnHeaders, allDetails;

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

    public String getType() {
        return type;
    }

}
