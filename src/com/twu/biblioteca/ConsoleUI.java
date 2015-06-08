package com.twu.biblioteca;
import java.util.ArrayList;

public class ConsoleUI {
    private static final int MAX_DETAIL_LENGTH = 23;

    public void printWelcome() {
        System.out.println(getWelcomeMessage());
        printMainMenu();
    }

    public void printMainMenu() {
        System.out.println(getMainMenu());
        System.out.println(getPrompt());
    }

    public void printBookList(ArrayList<Book> bookList) {
        System.out.println();
        printTableLine();
        System.out.println(getHeaders());
        printTableLine();
        if(!bookList.isEmpty()) {
            System.out.println(getFormattedListOfBooks(bookList));
            printTableLine();
        }
        System.out.println();
    }

    public void printPrompt() {
        System.out.println(getPrompt());
    }

    public void printInvalidMenuOptionMessage() {
        System.out.println("Sorry that is not a valid option. Please choose another.\n");
    }

    public String getMainMenu() {
       return "Main Menu:\tList Books\tQuit";
    }

    public String getPrompt() {
        return "Please choose an option ...> ";
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!\n";
    }

    public String getFormattedListOfBooks(ArrayList<Book> bookList) {
        String listOfBooks = "";
        for (Book book:bookList) {
            listOfBooks += getFormattedBookDetails(book);
        }
        return listOfBooks.substring(0, listOfBooks.length()-1);    //to format next line
    }

    private String getFormattedBookDetails(Book book) {
        String title = formatDetail(book.getTitle());
        String author = formatDetail(book.getAuthor());
        String yearPublished = formatDetail(Integer.toString(book.getYearPublished()));
        return "# " + title + " # " + author + " # " + yearPublished + " #\n";
    }

    private String formatDetail(String detail) {
        if (detailIsTooLong(detail)) {
            return shortenDetail(detail);
        }
        return formatDetailLength(detail);
    }

    private String formatDetailLength(String detail) {
        return detail += getJustifier(MAX_DETAIL_LENGTH - detail.length());
    }

    private String getJustifier(int justifierLength) {
        String justifier = "";
        for (int i = 0; i < justifierLength; i++) {
            justifier += " ";
        }
        return justifier;
    }

    private String shortenDetail(String detail) {
        return detail = detail.substring(0, MAX_DETAIL_LENGTH - 3) + "...";
    }

    private boolean detailIsTooLong(String detail) {
        return detail.length() > MAX_DETAIL_LENGTH;
    }

    public String getHeaders() {
        return "#          TITLE          #          AUTHOR         #      YEAR PUBLISHED     #";
    }

    private void printTableLine() {
        System.out.println("###############################################################################");
    }


}
