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
            ui.printTableOfLibraryItems(library.getLibraryItems(), "book");
            return input;
        } else if (input.equals("list movies")) {
            ui.printTableOfLibraryItems(library.getLibraryItems(), "movie");
            return input;
        } else if (input.equals("quit")) {
            return input;
        } else if (input.equals("check out a book")) {
            ui.printQueryWhichItemToCheckOut();
            checkOutAnItem(scanner.nextLine().toLowerCase());
            return input;
        } else if (input.equals("return a book")) {
            ui.printQueryWhichItemToReturn();
            returnAnItem(scanner.nextLine().toLowerCase());
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


    public LibraryItem checkOutAnItem(String input) {
        LibraryItem itemToCheckOut = checkItemIsInList(input, library.getLibraryItems());
        if (itemToCheckOut == null) {
            ui.printInvalidItemMessage();
        } else {
            library.checkOutItem(itemToCheckOut);
            ui.printItemCheckedOutMessage(itemToCheckOut);
        }
        return itemToCheckOut;
    }

    public LibraryItem returnAnItem(String input) {
        LibraryItem itemToReturn = checkItemIsInList(input, library.getCheckedOutItems());
        if (itemToReturn == null) {
            ui.printInvalidItemToReturnMessage();
        } else {
            library.returnItem(itemToReturn);
            ui.printItemReturnedMessage(itemToReturn);
        }
        return itemToReturn;
    }

    public ArrayList<String> getMenuOptions() {
        return menuOptions;
    }
}
