package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> libraryItems, checkedOutItems;

    public Library() {
        libraryItems = new ArrayList<LibraryItem>();
        createBooks();
        createMovies();
        checkedOutItems = new ArrayList<LibraryItem>();
    }

    private void createMovies() {
        libraryItems.add(new Movie("Akira", "1988", "Katsuhiro Otomo", "8"));
        libraryItems.add(new Movie("Planet Terror", "2007", "Robert Rodriguez", "7"));
        libraryItems.add(new Movie("Interstellar", "2014", "Christopher Nolan", "8"));
    }

    private void createBooks() {
        libraryItems.add(new Book("Perdido Street Station", "China Mieville", "2000"));
        libraryItems.add(new Book("Snow Crash", "Neal Stephenson", "1992"));
        libraryItems.add(new Book("The Nature of Code", "Daniel Shiffman", "2012"));
    }

    public ArrayList<LibraryItem> getCheckedOutItems() {
        return checkedOutItems;
    }

    public ArrayList<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public void checkOutItem(LibraryItem item) {
        libraryItems.remove(item);
        checkedOutItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        libraryItems.add(item);
        checkedOutItems.remove(item);
    }
}
