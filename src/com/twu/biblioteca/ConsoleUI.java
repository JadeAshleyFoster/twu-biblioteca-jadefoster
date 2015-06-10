package com.twu.biblioteca;

import java.util.ArrayList;

public class ConsoleUI {
    private static final int MAX_DETAIL_LENGTH = 23;

    //TODO: use printf instead

//Printers:

    public void printWelcome(ArrayList<String> menuOptions) {
        System.out.println(getWelcomeMessage());
        printMainMenu(menuOptions);
    }

    public void printMainMenu(ArrayList<String> menuOptions) {
        System.out.println(getMainMenu(menuOptions));
        System.out.println(getPrompt());
    }

    public void printTableOfLibraryItems(ArrayList<? extends LibraryItem> libraryItems, String itemType) {
        System.out.println();
        printTableLine(libraryItems.get(0).getColumnHeaders().length);
        printTableHeaders(libraryItems.get(0).getColumnHeaders());
        printTableLine(libraryItems.get(0).getColumnHeaders().length);
        if(!libraryItems.isEmpty()) {
            printTableItems(libraryItems, itemType);
            printTableLine(libraryItems.get(0).getColumnHeaders().length);
        }
        System.out.println();
    }

    private void printTableHeaders(String[] headers) {
        System.out.println(getFormattedHeaders(headers));
    }

    private void printTableItems(ArrayList<? extends LibraryItem> items, String itemType) {
        System.out.println(getFormattedListOfItems(items, itemType));
    }

    public void printInvalidMenuOptionMessage() {
        System.out.println("Sorry that is not a valid option. Please choose another.\n");
    }

    public void printGoodBye() {
        System.out.println("Thank you for using Biblioteca, goodbye.");
    }

    public void printQueryWhichItemToCheckOut() {
        System.out.println("What would you like to check out?");
    }

    public void printQueryWhichItemToReturn() {
        System.out.println("What would you like to return?");
    }

    public void printInvalidItemMessage() {
        System.out.println("That item is not available.");
    }

    public void printInvalidItemToReturnMessage() {
        System.out.println("That is not a valid item to return.");
    }

    public void printItemReturnedMessage(LibraryItem item) {
        System.out.println("Thank you for returning the" + item.getType() + ".");
    }

    public void printItemCheckedOutMessage(LibraryItem item) {
        System.out.println("Thank you! Enjoy the " + item.getType() + ".");
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

    public String getFormattedListOfItems(ArrayList<? extends LibraryItem> libraryItems, String itemType) {
        String formattedItemsList = "";
        for (LibraryItem item:libraryItems) {
            if (item.getType().equals(itemType)) {
                formattedItemsList += getFormattedItemDetails(item) + "\n";        //TODO: this method
            }
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

    public String getMainMenu(ArrayList<String> menuOptions) {
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
