package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private ConsoleUI ui;
    private BibliotecaApp bib;
    private Scanner scanner;
    private String[] menuOptions;

    public Controller(BibliotecaApp bib) {
        ui = new ConsoleUI();
        this.bib = bib;
        scanner = new Scanner(System.in);
        createMenuOptions();
    }

    private void createMenuOptions() {
        menuOptions = new String[4];     //TODO: Where should menu options go? It's own class?
        menuOptions[0] = "List Books";
        menuOptions[1] = "List Movies";
        menuOptions[2] = "Check Out a Book";
        menuOptions[3] = "Return a Book";
        menuOptions[4] = "Quit";
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public String processUserInput() {
        String input = scanner.nextLine().toLowerCase();
        return processMenuInput(input);
    }

    public String processMenuInput(String input) {
        if (input.equals("list books")) {
            ui.printTableOfLibraryItems(bib.getBookList());
            return input;
        } else if (input.equals("list movies")) {
            ui.printTableOfLibraryItems(bib.getMovieList());
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

    public Book checkOutABook(String input) {
        Book bookChosen = checkBookIsInList(input, bib.getBookList());
        if (bookChosen == null) {
            ui.printInvalidBookMessage();
        } else {
            ui.printBookCheckedOutMessage(bookChosen);
            bib.checkOutBook(bookChosen);
        }
        return bookChosen;
    }

    public Book returnABook(String input) {
        Book bookReturned = checkBookIsInList(input, bib.getCheckedOutBooks());
        if (bookReturned == null) {
            ui.printInvalidBookToReturnMessage();
        } else {
            ui.printBookReturnedMessage(bookReturned);
            bib.returnBook(bookReturned);
        }
        return bookReturned;
    }

}
