package com.twu.biblioteca;

import java.util.ArrayList;

public class ConsoleUI {
    private static final int MAX_DETAIL_LENGTH = 23;

    public void printWelcome(ArrayList<String> menuOptions) {
        System.out.println(getWelcomeMessage());
        printMainMenu(menuOptions);
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!\n";
    }

    public void printMainMenu(ArrayList<String> menuOptions) {
        System.out.println(getMainMenu(menuOptions));
        System.out.println(getPrompt());
    }

    public String getMainMenu(ArrayList<String> menuOptions) {
        String mainMenu = "Main Menu:\t-\t";
        for (String option:menuOptions) {
            mainMenu += option + "\t-\t";
        }
        return mainMenu;
    }

    public String getPrompt() {
        return "Please choose an option ...> ";
    }

    public void printTableOfBooks(ArrayList<Book> books) {
        System.out.println();
        printTableLine(Book.getNumberOfColumns());
        printTableHeaders(Book.getColumnHeaders());
        printTableLine(Book.getNumberOfColumns());
        if(!books.isEmpty()) {
            printTableItems(books);
            printTableLine(Book.getNumberOfColumns());
        }
        System.out.println();
    }

    public void printTableOfMovies(ArrayList<Movie> movies) {
        System.out.println();
        printTableLine(Movie.getNumberOfColumns());
        printTableHeaders(Movie.getColumnHeaders());
        printTableLine(Movie.getNumberOfColumns());
        if(!movies.isEmpty()) {
            printTableItems(movies);
            printTableLine(Movie.getNumberOfColumns());
        }
        System.out.println();
    }

    private void printTableLine(int columns) {
        String column = "##########################";
        String tableLine = "";
        for (int i = 0; i < columns; i++) {
            tableLine += column;
        }
        System.out.println(tableLine + "#");
    }

    private void printTableHeaders(ArrayList<String> headers) {
        System.out.println(getFormattedHeaders(headers));
    }

    public String getFormattedHeaders(ArrayList<String> headers) {
        String formattedHeaders = "#";
        for (String header:headers) {
            formattedHeaders += " " + formatDetail(header) + "#";
        }
        return formattedHeaders;
    }

    private void printTableItems(ArrayList<? extends LibraryItem> items) {
        System.out.println(getFormattedListOfItems(items));
    }

    public String getFormattedListOfItems(ArrayList<? extends LibraryItem> libraryItems) {
        String formattedItemsList = "";
        for (LibraryItem item:libraryItems) {
            formattedItemsList += getFormattedItemDetails(item) + "\n";
        }
        return removeLastCharacter(formattedItemsList);
    }

    private String getFormattedItemDetails(LibraryItem item) {
        String formattedItemDetails = "#";
        for (String detail:item.getAllDetails()) {
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

    public void printInvalidMenuOptionMessage() {
        System.out.println("Sorry that is not a valid option. Please choose another.\n");
    }

    public void printGoodBye() {
        System.out.println("Thank you for using Biblioteca, goodbye.");
    }

    public void printQueryWhichItemToCheckOut() {
        System.out.println("Please enter the title of the item you would like to check out.");
        System.out.println(getPrompt());
    }

    public void printQueryWhichItemToReturn() {
        System.out.println("Please enter the title of the item you would like to return.");
        System.out.println(getPrompt());
    }

    public void printInvalidItemMessage() {
        System.out.println("That item is not available.");
    }

    public void printInvalidItemToReturnMessage() {
        System.out.println("That is not a valid item to return.");
    }

    public void printItemReturnedMessage(LibraryItem item) {
        System.out.println("Thank you for returning the " + item.toString() + ".");
    }

    public void printItemCheckedOutMessage(LibraryItem item) {
        System.out.println("Thank you! Enjoy the " + item.toString() + ".");
    }

    private String getColumnJustifier(int justifierLength) {
        String justifier = "";
        for (int i = 0; i < justifierLength; i++) {
            justifier += " ";
        }
        return justifier;
    }

    private String removeLastCharacter(String stringToShorten) {
        return stringToShorten.substring(0, stringToShorten.length()-1);
    }

}
