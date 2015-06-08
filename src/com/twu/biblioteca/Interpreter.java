package com.twu.biblioteca;

public class Interpreter {
    ConsoleUI ui;
    BibliotecaApp bib;

    public Interpreter(BibliotecaApp bib) {
        ui = new ConsoleUI();
        this.bib = bib;
    }

    public String processMenuInput(String input) {
        if (input.equals("list books")) {
            ui.printBookList(bib.getBookList());
            return input;
        } else if (input.equals("quit")) {
            return input;
        } else if (input.equals("check out a book")) {
            ui.printQueryWhichBookToCheckOut();
            return input;
        } else {
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
    }

    public Book processBookInput(String input) {
        for (Book book:bib.getBookList()) {
            if (book.getTitle().toLowerCase().equals(input)) {
                return book;
            }
        }
        return null;
    }

}
