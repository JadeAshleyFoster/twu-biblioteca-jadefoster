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
    }

    public void go() {
        ui.printWelcome();
        Loginable user = loginUser();
        createMenuOptions(user);
        executeUserRequests(user);
    }

    private void executeUserRequests(Loginable user) {
        ui.printMainMenu(menuOptions);
        boolean quit = false;
        while (!quit) {
            String userInput = scanner.nextLine().toLowerCase();
            String userRequest = processInput(userInput, user);
            if (userRequest.equals("quit")) {
                ui.printGoodBye();
                scanner.close();
                quit = true;
            } else {
                System.out.println();
                ui.printMainMenu(menuOptions);
            }
        }
    }

    private Loginable loginUser() {
        Loginable user = null;
        boolean loggedIn = false;
        while(!loggedIn) {
            ui.printAskForLoginID();
            user = library.isValidUserID(scanner.nextLine());
            if (user != null) {
                ui.printAskForPassword();
                loggedIn = isCorrectPasswordFromUser(user, scanner.nextLine());
            }else {
                ui.printIncorrectLoginIDMessage();
            }
        }
        return user;
    }

    public boolean isCorrectPasswordFromUser(Loginable user, String input) {
        if (user.getPassword().equals(input)) {
            ui.printSuccessfulLogin();
            return true;
        } else {
            ui.printIncorrectPasswordMessage();
        }
        return false;
    }

    public void createMenuOptions(Loginable user) {
        menuOptions = new ArrayList<String>();
        menuOptions.add("List Books");
        menuOptions.add("List Movies");
        menuOptions.add("Check Out an Item");
        menuOptions.add("Return an Item");
        if (user.isLibrarian()) {
            menuOptions.add("List Checked Out Books");
            menuOptions.add("List Checked Out Movies");
        }
        menuOptions.add("User Information");
        menuOptions.add("Quit");
    }

    public String processInput(String input, Loginable user) {
        if (input.equals("list books")) {
            ui.printTableOfBooks(library.getAll("book"), user);
            return input;
        } else if (input.equals("list movies")) {
            ui.printTableOfMovies(library.getAll("movie"), user);
            return input;
        } else if (input.equals("quit")) {
            return input;
        } else if (input.equals("user information")) {
            ui.printUserInformation(user);
            return input;
        } else if (input.equals("check out an item")) {
            ui.printAskForPassword();
            if (isCorrectPasswordFromUser(user, scanner.nextLine())) {
                ui.printQueryWhichItemToCheckOut();
                checkOutAnItem(scanner.nextLine().toLowerCase(), user);
            }
            return input;
        } else if (input.equals("return an item")) {
            ui.printAskForPassword();
            if (isCorrectPasswordFromUser(user, scanner.nextLine())) {
                ui.printQueryWhichItemToReturn();
                returnAnItem(scanner.nextLine().toLowerCase());
            }
            return input;
        } else {
            if (user.isLibrarian()) {
                return processLibrarianOnlyInput(input, user);
            }
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
    }

    private String processLibrarianOnlyInput(String input, Loginable user) {
        if (input.equals("list checked out books")) {
            ui.printTableOfBooks(library.getCheckedOut("book"), user);
        } else if (input.equals("list checked out movies")) {
            ui.printTableOfMovies(library.getCheckedOut("movie"), user);
        } else {
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
        return input;
    }


    public LibraryItem checkOutAnItem(String input, Loginable user) {
        LibraryItem itemToCheckOut = library.isALibraryItem(input);
        if (itemToCheckOut == null) {
            ui.printInvalidItemMessage();
        } else {
            library.checkOutItem(itemToCheckOut, user);
            ui.printItemCheckedOutMessage(itemToCheckOut);
        }
        return itemToCheckOut;
    }

    public LibraryItem returnAnItem(String input) {
        LibraryItem itemToReturn = library.isALibraryItem(input);
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
