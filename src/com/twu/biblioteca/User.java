package com.twu.biblioteca;

import java.util.ArrayList;

public class User extends Loginable {
    private ArrayList<LibraryItem> checkedOutItems;

    public User(String ID, String password) {
        super(ID, password);
        checkedOutItems = new ArrayList<LibraryItem>();
    }

    public ArrayList<LibraryItem> getCheckedOutItems() {
        return checkedOutItems;
    }

    public void checkOutItem(LibraryItem item) {
        checkedOutItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        checkedOutItems.remove(item);
    }

    public boolean isLibrarian() {
        return false;
    }

}
