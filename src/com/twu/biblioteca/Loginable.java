package com.twu.biblioteca;

public abstract class Loginable {
    private String ID, password;

    public Loginable(String ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public abstract boolean isLibrarian();

}
