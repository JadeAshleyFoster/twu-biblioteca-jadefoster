package com.twu.biblioteca;

public class Librarian extends Loginable{

    public Librarian(String ID, String password) {
        super(ID, password);
    }

    public boolean isLibrarian() {
        return true;
    }


}
