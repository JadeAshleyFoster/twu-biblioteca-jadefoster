package com.twu.biblioteca;

import java.util.ArrayList;

public class ConsoleUI {
    private static final int MAX_DETAIL_LENGTH = 26;

    public String printWelcome() {
        String toPrint = "Welcome to Biblioteca!\n";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printAskForLoginID() {
        String toPrint = "Please enter your library number:\n" + getPrompt();
        System.out.println(toPrint);
        return toPrint;
    }

    public String printAskForPassword() {
        String toPrint = "Please enter your password:\n" + getPrompt();
        System.out.println(toPrint);
        return toPrint;
    }

    public String printIncorrectPasswordMessage() {
        String toPrint = "That password is incorrect.";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printSuccessfulLogin() {
        String toPrint = "Successful login.\n";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printIncorrectLoginIDMessage() {
        String toPrint = "That is not a valid library number. A library number is in the format XXX-XXXX.\n";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printMainMenu(ArrayList<String> menuOptions) {
        String mainMenu = "Main Menu:\t-\t";
        for (String option:menuOptions) {
            mainMenu += option + "\t-\t";
        }
        String toPrint = "\n" + mainMenu + "\nPlease enter an option.\n" + getPrompt();
        System.out.println(toPrint);
        return toPrint;

    }

    private String getPrompt() {
        return "...>";
    }

    public String printInvalidMenuOptionMessage() {
        String toPrint = "Sorry that is not a valid option. Please choose another.\n";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printGoodBye() {
        String toPrint = "Thank you for using Biblioteca, goodbye.";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printQueryWhichItemToCheckOut() {
        String toPrint = "Please enter the title of the item you would like to check out.\n" + getPrompt();
        System.out.println(toPrint);
        return toPrint;
    }

    public String printQueryWhichItemToReturn() {
        String toPrint = "Please enter the title of the item you would like to return.\n" + getPrompt();
        System.out.println(toPrint);
        return toPrint;
    }

    public String printInvalidItemMessage() {
        String toPrint = "That item is not available.";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printInvalidItemToReturnMessage() {
        String toPrint = "That is not a valid item to return.";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printItemReturnedMessage(LibraryItem item) {
        String toPrint = "Thank you for returning the " + item.toString() + ".";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printItemCheckedOutMessage(LibraryItem item) {
        String toPrint = "Thank you! Enjoy the " + item.toString() + ".";
        System.out.println(toPrint);
        return toPrint;
    }

    public String printUserInformation(Loginable user) {
        String toPrint = "";
        if (user.isLibrarian()) {
            toPrint = "No Information available for librarian user.";
        } else {
            User userX = (User) user;
            toPrint = "\nName: " + userX.getName() + "\ne-mail: " + userX.getEmail() + "\nPhone: " + userX.getPhoneNumber();
        }
        return toPrint;
    }

    public String printTableOfBooks(ArrayList<LibraryItem> books, Loginable user) {
        String toPrint = "";
        toPrint += getTableLine(Book.getNumberOfColumns());
        toPrint += getTableHeaders(Book.getColumnHeaders());
        toPrint += getTableLine(Book.getNumberOfColumns());
        if(!books.isEmpty()) {
            toPrint += getTableItems(books, user);
            toPrint += getTableLine(Book.getNumberOfColumns());
        }
        System.out.println(toPrint);
        return toPrint;
    }

    public String printTableOfMovies(ArrayList<LibraryItem> movies, Loginable user) {
        String toPrint = "";
        toPrint += getTableLine(Movie.getNumberOfColumns());
        toPrint += getTableHeaders(Movie.getColumnHeaders());
        toPrint += getTableLine(Movie.getNumberOfColumns());
        if(!movies.isEmpty()) {
            toPrint += getTableItems(movies, user);
            toPrint += getTableLine(Movie.getNumberOfColumns());
        }
        System.out.println(toPrint);
        return toPrint;
    }

    private String getTableLine(int columns) {
        String column = "#############################";
        String tableLine = "";
        for (int i = 0; i < columns; i++) {
            tableLine += column;
        }
        return tableLine + "#\n";
    }

    private String getTableHeaders(ArrayList<String> headers) {
        String formattedHeaders = "#";
        for (String header:headers) {
            formattedHeaders += " " + formatDetail(header) + "#";
        }
        return formattedHeaders + "\n";
    }

    private String getTableItems(ArrayList<? extends LibraryItem> items, Loginable user) {
        String formattedItemsList = "";
        for (LibraryItem item:items) {
            formattedItemsList += getFormattedItemDetails(item, user) + "\n";
        }
        return formattedItemsList;
    }

    private String getFormattedItemDetails(LibraryItem item, Loginable user) {
        String formattedItemDetails = "#";
        for (String detail:item.getAllDetails(user)) {
            formattedItemDetails += " " + formatDetail(detail) + "#";
        }
        return formattedItemDetails;
    }

    private String formatDetail(String detail) {
        if (detailIsTooLong(detail)) {
            return shortenDetail(detail);
        }
        return addJustifierToDetail(detail);
    }

    private boolean detailIsTooLong(String detail) {
        return detail.length() > MAX_DETAIL_LENGTH;         //TODO: use printf instead
    }

    private String shortenDetail(String detail) {
        return detail.substring(0, MAX_DETAIL_LENGTH - 3) + "...";
    }

    private String addJustifierToDetail(String detail) {
        return detail + getColumnJustifier(MAX_DETAIL_LENGTH - detail.length() + 1);
    }

    private String getColumnJustifier(int justifierLength) {
        String justifier = "";
        for (int i = 0; i < justifierLength; i++) {
            justifier += " ";
        }
        return justifier;
    }

}
