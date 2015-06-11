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
        runProgram(user);
    }

    private void runProgram(Loginable user) {
        ui.printMainMenu(menuOptions);

        boolean quit = false;
        while (!quit) {
            String userInput = scanner.nextLine().toLowerCase();
            String processedInput = processInput(userInput, user);
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

    public Loginable loginUser() {
        Loginable user = null;
        boolean loggedIn = false;
        while(!loggedIn) {
            user = getLogInIDFromUser();
            if (user != null) {
                loggedIn = getValidPasswordFromUser(user);
            }else {
                ui.printIncorrectLoginIDMessage();
            }
        }
        return user;
    }

    private boolean getValidPasswordFromUser(Loginable user) {
        ui.printAskForPassword();
        String userPassword = scanner.nextLine();
        if (user.getPassword().equals(userPassword)) {
            ui.printSuccessfulLogin();
            return true;
        } else {
            ui.printIncorrectPasswordMessage();
        }
        return false;
    }

    private Loginable getLogInIDFromUser() {
        ui.printAskForLoginID();
        String userLoginId = scanner.nextLine();
        return library.isValidUserID(userLoginId);
    }

    private void createMenuOptions(Loginable user) {
        menuOptions = new ArrayList<String>();
        menuOptions.add("List Books");
        menuOptions.add("List Movies");
        menuOptions.add("Check Out a Book");
        menuOptions.add("Check Out a Movie");
        menuOptions.add("Return a Book");
        menuOptions.add("Return a Movie");
        if (user.isLibrarian()) {
            menuOptions.add("List Checked Out Books");
            menuOptions.add("List Checked Out Movies");
        }
        menuOptions.add("Quit");
    }

    public String processInput(String input, Loginable user) {
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
        } else if(input.equals("check out a movie")) {
            ui.printQueryWhichItemToCheckOut();
            checkOutAMovie(scanner.nextLine().toLowerCase());
            return input;
        } else if (input.equals("return a book")) {
            ui.printQueryWhichItemToReturn();
            returnABook(scanner.nextLine().toLowerCase());
            return input;
        } else {
            if (user.isLibrarian()) {
                return processLibrarianOnlyInput(input);
            }
            ui.printInvalidMenuOptionMessage();
            return "invalid option";
        }
    }

    private String processLibrarianOnlyInput(String input) {
        if (input.equals("List Checked Out Books")) {
            ui.printTableOfBooks(library.getCheckedOutBooks());
        } else if (input.equals("List Checked Out Movies")) {
            ui.printTableOfMovies(library.getCheckedOutMovies());
        }
        return input;
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

    public Movie checkOutAMovie(String input) {
        Movie movieToCheckOut = (Movie) checkItemIsInList(input, library.getMovies());
        if (movieToCheckOut == null) {
            ui.printInvalidItemMessage();
        } else {
            library.checkOutMovie(movieToCheckOut);
            ui.printItemCheckedOutMessage(movieToCheckOut);
        }
        return movieToCheckOut;
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

    public Movie returnAMovie(String input) {
        Movie movieToReturn = (Movie) checkItemIsInList(input, library.getCheckedOutMovies());
        if (movieToReturn == null) {
            ui.printInvalidItemToReturnMessage();
        } else {
            library.returnMovie(movieToReturn);
            ui.printItemReturnedMessage(movieToReturn);
        }
        return movieToReturn;
    }

    public ArrayList<String> getMenuOptions() {
        return menuOptions;
    }
}
