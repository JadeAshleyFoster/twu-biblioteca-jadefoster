package com.twu.biblioteca;

import java.util.ArrayList;

public class Interpreter {
    ConsoleUI ui;

    public Interpreter() {
        ui = new ConsoleUI();
    }

    public String processInput(String input, BibliotecaApp bib) {
        if (input.equals("list books")) {
            ui.printBookList(bib.getBookList());
            return "list books";
        } else {
            ui.printInvalidMenuOptionMessage();
            ui.printPrompt();
            return "invalid option";
        }
    }

}
