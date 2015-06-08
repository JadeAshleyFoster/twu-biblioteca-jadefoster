package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ConsoleUI ui;
    BibliotecaApp bib;
    Scanner scanner;

    public Controller(BibliotecaApp bib) {
        ui = new ConsoleUI();
        this.bib = bib;
        scanner = new Scanner(System.in);
    }

    public String processUserInput() {
        String input = scanner.nextLine().toLowerCase();
        String processMenuInput = processMenuInput(input);
        return processMenuInput;
    }

    public String processMenuInput(String input) {
        if (input.equals("list books")) {
            ui.printBookList(bib.getBookList());
            return input;
        } else if (input.equals("quit")) {
            ui.printGoodBye();
            scanner.close();
            return input;
        } else if (input.equals("check out a book")) {
            ui.printQueryWhichBookToCheckOut();
            checkOutABook(scanner.nextLine().toLowerCase());
            return input;
        } else if (input.equals("return a book")) {
            ui.printQueryWhichBookToReturn();
            returnABook(scanner.nextLine().toLowerCase());
            return input;
        } else {
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
    }

    private Book checkBookIsInList(String input, ArrayList<Book> bookList) {
        for (Book book:bookList) {
            if (book.getTitle().toLowerCase().equals(input)) {
                return book;
            }
        }
        return null;
    }

    public void checkOutABook(String input) {
        Book bookChosen = checkBookIsInList(input, bib.getBookList());
        if (bookChosen == null) {
            ui.printInvalidBookMessage();
        } else {
            ui.printBookCheckedOutMessage(bookChosen);
            bib.checkOutBook(bookChosen);
        }
    }

    public void returnABook(String input) {
        Book bookReturned = checkBookIsInList(input, bib.getCheckedOutBooks());
        if (bookReturned == null) {
            ui.printInvalidBookToReturnMessage();
        } else {
            ui.printBookReturnedMessage(bookReturned);
            bib.returnBook(bookReturned);
        }
    }

}
