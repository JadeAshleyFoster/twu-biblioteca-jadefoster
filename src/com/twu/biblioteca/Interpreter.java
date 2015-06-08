package com.twu.biblioteca;

import java.util.ArrayList;

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
        } else if (input.equals("return a book")) {
            ui.printQueryWhichBookToReturn();
            return input;
        } else {
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
    }

    public Book processBookInput(String input, ArrayList<Book> bookList) {
        for (Book book:bookList) {
            if (book.getTitle().toLowerCase().equals(input)) {
                return book;
            }
        }
        return null;
    }

}
