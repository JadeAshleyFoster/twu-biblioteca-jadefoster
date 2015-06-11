package com.twu.biblioteca;

import java.util.ArrayList;

public class User extends Loginable {
    private String name, email, phoneNumber;

    public User(String ID, String password, String name, String email, String phoneNumber) {
        super(ID, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean isLibrarian() {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
