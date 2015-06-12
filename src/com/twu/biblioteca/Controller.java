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

    private Loginable loginUser() {
        Loginable user = null;
        boolean loggedIn = false;
        while(!loggedIn) {
            user = getLoginIDFromUser();
            loggedIn = getPasswordFromUser(user);
        }
        return user;
    }

    private Loginable getLoginIDFromUser() {
        ui.printAskForLoginID();
        return library.isValidUserID(getUserInput());
    }

    private boolean getPasswordFromUser(Loginable user) {
        if (user != null) {
            ui.printAskForPassword();
            return isCorrectPasswordFromUser(user, getUserInput());
        }
        ui.printIncorrectLoginIDMessage();
        return false;
    }

    private void executeUserRequests(Loginable user) {
        boolean quit = false;
        while (!quit) {
            ui.printMainMenu(menuOptions);
            String userRequest = processInput(getUserInput().toLowerCase(), user);
            quit = wantToQuit(userRequest);
        }
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    public boolean wantToQuit(String request) {
        if (request.equals("quit")) {
            shutDown();
            return true;
        }
        return false;
    }

    private void shutDown() {
        ui.printGoodBye();
        scanner.close();
    }

    public boolean isCorrectPasswordFromUser(Loginable user, String input) {
        if (user.getPassword().equals(input)) {
            ui.printSuccessfulLogin();
            return true;
        }
        ui.printIncorrectPasswordMessage();
        return false;
    }

    public String processInput(String input, Loginable user) {
        if (input.equals("list books") || input.equals("list movies")) {
            ui.printTableOfBooks(library.getAll(input.substring(5, input.length()-1)), user);
            return input;
        } else if (input.equals("check out an item")) {
            userWantsToCheckOutAnItem(user);
            return input;
        } else if (input.equals("return an item")) {
            userWantsToReturnAnItem(user);
            return input;
        } else if (input.equals("user information")) {
            ui.printUserInformation(user);
            return input;
        } else if (input.equals("quit")) {
            return input;
        } else {
            if (user.isLibrarian()) {
                return processLibrarianOnlyInput(input, user);
            }
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
    }

    private void userWantsToCheckOutAnItem(Loginable user) {
        if (getPasswordFromUser(user)) {
            ui.printQueryWhichItemToCheckOut();
            checkOutAnItemFromTheLibrary(getUserInput().toLowerCase(), user);
        }
    }

    private void userWantsToReturnAnItem(Loginable user) {
        if (getPasswordFromUser(user)) {
            ui.printQueryWhichItemToReturn();
            returnAnItemToTheLibrary(getUserInput().toLowerCase());
        }
    }

    private String processLibrarianOnlyInput(String input, Loginable user) {
        if (input.equals("list checked out books") || (input.equals("list checked out movies"))) {
            ui.printTableOfBooks(library.getCheckedOut(input.substring(17, input.length()-1)), user);
            return input;
        }
        ui.printInvalidMenuOptionMessage();
        return "invalid option";
    }

    public LibraryItem checkOutAnItemFromTheLibrary(String input, Loginable user) {
        LibraryItem itemToCheckOut = library.isALibraryItem(input);
        if (itemToCheckOut == null) {
            ui.printInvalidItemMessage();
        } else {
            library.checkOutItem(itemToCheckOut, user);
            ui.printItemCheckedOutMessage(itemToCheckOut);
        }
        return itemToCheckOut;
    }

    public LibraryItem returnAnItemToTheLibrary(String input) {
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
}
