package com.twu.biblioteca;

import java.util.ArrayList;

public abstract class LibraryItem {
    protected String title, year;
    protected Loginable checkedOutBy;

    public LibraryItem(String title, String year) {
        this.title = title;
        this.year = year;
        checkedOutBy = null;
    }

    public String getTitle() {
        return title;
    }

    public abstract ArrayList<String> getAllDetails(Loginable user);

    protected abstract void createColumnHeaders();

    public abstract String toString();

    public void setCheckedOutBy(Loginable user) {
        checkedOutBy = user;
    }

    public boolean isCheckedOut() {
        return checkedOutBy != null;
    }

    public Loginable getCheckedOutBy() {
        return checkedOutBy;
    }

    public String available(Loginable user) {
        if (isCheckedOut()) {
            if (user.isLibrarian()) {
                return "Checked Out By: " + checkedOutBy.getID();
            } else {
                return "Checked Out";
            }
        }
        return "Available";
    }
}
