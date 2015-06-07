package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        bib.go();
    }

    public void go() {
        System.out.println(getWelcome());
    }

    public String getWelcome() {
        return "Welcome to Biblioteca!";
    }
}
