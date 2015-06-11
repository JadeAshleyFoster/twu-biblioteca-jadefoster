package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> items;
    private ArrayList<Loginable> users;

    public Library() {
        items = new ArrayList<LibraryItem>();
        users = new ArrayList<Loginable>();
    }

    public ArrayList<LibraryItem> getCheckedOut(String typeOfItem) {
        ArrayList<LibraryItem> checkedOutItems = new ArrayList<LibraryItem>();
        for (LibraryItem item:getAll(typeOfItem)) {
            if(item.isCheckedOut()) {
                checkedOutItems.add(item);
            }
        }
        return checkedOutItems;
    }

    public ArrayList<LibraryItem> getAll(String typeOfItem) {
        ArrayList<LibraryItem> someItems = new ArrayList<LibraryItem>();
        for (LibraryItem item:items) {
            if(item.toString().equals(typeOfItem)) {
                someItems.add(item);
            }
        }
        return someItems;
    }

    public Loginable isValidUserID(String userID) {
        for (Loginable user:users) {
            if (userID.equals(user.getID())) {
                return user;
            }
        }
        return null;
    }

    public void checkOutItem(LibraryItem item, Loginable user) {
        item.setCheckedOutBy(user);
    }

    public void returnItem(LibraryItem item) {
        item.setCheckedOutBy(null);
    }

    public LibraryItem isALibraryItem(String input) {
        for (LibraryItem item:items) {
            if (item.getTitle().toLowerCase().equals(input)) {
                return item;
            }
        }
        return null;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addUser(Loginable user) {
        users.add(user);
    }

    public ArrayList<LibraryItem> getItems() {
        return items;
    }

    public ArrayList<Loginable> getUsers() {
        return users;
    }
}
