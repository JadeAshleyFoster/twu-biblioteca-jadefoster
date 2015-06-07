package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        bib.go();
    }

    public void go() {
        printWelcome();
    }

    private void printWelcome() {
        System.out.println(getWelcomeMessage());
        printTableLine();
        System.out.println(getHeaders());
        printTableLine();
        System.out.println(getListOfBooks());
        printTableLine();
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!\n";
    }

    public String getListOfBooks() {
        return "# Perdido Street Station  #\n# China Mieville          #\n# 2000                    #\n" +
               "# Snow Crash              #\n# Neal Stephenson         #\n# 1992                    #\n" +
                "# The Nature of Code      #\n# Daniel Shiffman         #\n# 2012                    #";
    }

    public String getHeaders() {
        return "#          TITLE          #          AUTHOR         #      YEAR PUBLISHED     #";
    }

    private void printTableLine() {
        System.out.println("###############################################################################");
    }
}
