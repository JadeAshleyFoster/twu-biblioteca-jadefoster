package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private ArrayList<String> menuOptions;
    private ConsoleUI ui;
    private Library library;
    private Scanner scanner;

    public Controller(Library library) {
        ui = new ConsoleUI();
        this.library = library;
        scanner = new Scanner(System.in);
        createMenuOptions();
    }

    public void go() {
        ui.printWelcome(menuOptions);

        boolean quit = false;
        while (!quit) {

            String userInput = scanner.nextLine().toLowerCase();
            String processedInput = processInput(userInput);
            if (processedInput.equals("quit")) {
                ui.printGoodBye();
                scanner.close();
                quit = true;
            } else {
                System.out.println();
                ui.printMainMenu(menuOptions);
            }
        }


    }

    private void createMenuOptions() {
        menuOptions = new ArrayList<String>();
        menuOptions.add("List Books");
        menuOptions.add("List Movies");
        menuOptions.add("Check Out a Book");
        menuOptions.add("Return a Book");
        menuOptions.add("Quit");
    }

    public String processInput(String input) {
        if (input.equals("list books")) {
            ui.printTableOfBooks(library.getBooks());
            return input;
        } else if (input.equals("list movies")) {
            ui.printTableOfMovies(library.getMovies());
            return input;
        } else if (input.equals("quit")) {
            return input;
        } else if (input.equals("check out a book")) {
            ui.printQueryWhichItemToCheckOut();
            checkOutABook(scanner.nextLine().toLowerCase());
            return input;
        } else if (input.equals("return a book")) {
            ui.printQueryWhichItemToReturn();
            returnABook(scanner.nextLine().toLowerCase());
            return input;
        } else {
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
    }


    private LibraryItem checkItemIsInList(String input, ArrayList<? extends LibraryItem> libraryItems) {
        for (LibraryItem item:libraryItems) {
            if (item.getTitle().toLowerCase().equals(input)) {
                return item;
            }
        }
        return null;
    }


    public Book checkOutABook(String input) {
        Book bookToCheckOut = (Book) checkItemIsInList(input, library.getBooks());
        if (bookToCheckOut == null) {
            ui.printInvalidItemMessage();
        } else {
            library.checkOutBook(bookToCheckOut);
            ui.printItemCheckedOutMessage(bookToCheckOut);
        }
        return bookToCheckOut;
    }

    public Book returnABook(String input) {
        Book bookToReturn = (Book) checkItemIsInList(input, library.getCheckedOutBooks());
        if (bookToReturn == null) {
            ui.printInvalidItemToReturnMessage();
        } else {
            library.returnBook(bookToReturn);
            ui.printItemReturnedMessage(bookToReturn);
        }
        return bookToReturn;
    }

    public ArrayList<String> getMenuOptions() {
        return menuOptions;
    }
}
