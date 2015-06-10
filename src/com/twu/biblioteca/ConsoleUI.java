package com.twu.biblioteca;
import java.util.ArrayList;

public class ConsoleUI {
    private static final int MAX_DETAIL_LENGTH = 23;

    //TODO: use printf instead

//Printers:

    public void printWelcome(String[] menuOptions) {
        System.out.println(getWelcomeMessage());
        printMainMenu(menuOptions);
    }

    public void printMainMenu(String[] menuOptions) {
        System.out.println(getMainMenu(menuOptions));
        System.out.println(getPrompt());
    }

    public void printTableOfLibraryItems(ArrayList<? extends LibraryItem> libraryItems) {
        System.out.println();
        printTableLine(libraryItems.get(0).getColumnHeaders().length);
        printTableHeaders(libraryItems.get(0).getColumnHeaders());
        printTableLine(libraryItems.get(0).getColumnHeaders().length);
        if(!libraryItems.isEmpty()) {
            printTableItems(libraryItems);
            printTableLine(libraryItems.get(0).getColumnHeaders().length);
        }
        System.out.println();
    }

    private void printTableHeaders(String[] headers) {
        System.out.println(getFormattedHeaders(headers));
    }

    private void printTableItems(ArrayList<? extends LibraryItem> items) {
        System.out.println(getFormattedListOfItems(items));
    }

    public void printInvalidMenuOptionMessage() {
        System.out.println("Sorry that is not a valid option. Please choose another.\n");
    }

    public void printGoodBye() {
        System.out.println("Thank you for using Biblioteca, goodbye.");
    }

    public void printQueryWhichBookToCheckOut() {
        System.out.println("Which book would you like to check out?");
    }

    public void printQueryWhichBookToReturn() {
        System.out.println("Which book would you like to return?");
    }

    public void printInvalidBookMessage() {
        System.out.println("That book is not available.");
    }

    public void printInvalidBookToReturnMessage() {
        System.out.println("That is not a valid book to return.");
    }

    public void printBookReturnedMessage(Book book) {
        System.out.println("Thank you for returning the book.");
    }

    public void printBookCheckedOutMessage(Book book) {
        System.out.println("Thank you! Enjoy the book.");
    }

    private void printTableLine(int columns) {
        String column = "###########################";
        String tableLine = "";
        for (int i = 0; i < columns; i++) {
            tableLine += column;
        }
        System.out.println(tableLine);
    }



//Getters:

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!\n";
    }

    public String getFormattedListOfItems(ArrayList<? extends LibraryItem> libraryItems) {
        String formattedItemsList = "";
        for (LibraryItem item:libraryItems) {
            formattedItemsList += getFormattedItemDetails(item) + "\n";        //TODO: this method
        }
        return removeLastCharacter(formattedItemsList);
    }

    public String getFormattedHeaders(String[] headers) {
        String formattedHeaders = "";
        for (String header:headers) {
            formattedHeaders += "# " + formatDetail(header) + " ";
        }
        return formattedHeaders + "#";
    }

    public String getPrompt() {
        return "Please choose an option ...> ";
    }

    public String getMainMenu(String[] menuOptions) {
        String mainMenu = "Main Menu:\t-\t";
        for (String option:menuOptions) {
            mainMenu += option + "\t-\t";
        }
        return mainMenu;
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
        return formatDetailLength(detail);
    }

    private String formatDetailLength(String detail) {
        return detail + getColumnJustifier(MAX_DETAIL_LENGTH - detail.length() + 1);
    }

    private String getColumnJustifier(int justifierLength) {
        String justifier = "";
        for (int i = 0; i < justifierLength; i++) {
            justifier += " ";
        }
        return justifier;
    }




//Other methods:

    private String removeLastCharacter(String stringToShorten) {
        return stringToShorten.substring(0, stringToShorten.length()-1);
    }

    private String shortenDetail(String detail) {
        return detail.substring(0, MAX_DETAIL_LENGTH - 3) + "...";
    }

    private boolean detailIsTooLong(String detail) {
        return detail.length() > MAX_DETAIL_LENGTH;
    }















}
