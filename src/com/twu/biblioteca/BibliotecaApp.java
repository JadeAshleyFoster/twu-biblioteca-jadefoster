package com.twu.biblioteca;
import java.util.ArrayList;

public class BibliotecaApp {
    private static final int MAX_DETAIL_LENGTH = 23;
    ArrayList<Book> bookList;

    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        bib.go();
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void go() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        bookList.add( new Book("Snow Crash", "Neal Stephenson", 1992));
        bookList.add( new Book("The Nature of Code", "Daniel Shiffman", 2012));
        setBookList(bookList);

        printWelcome();
    }

    private void printWelcome() {
        System.out.println(getWelcomeMessage());
        printTableLine();
        System.out.println(getHeaders());
        printTableLine();
        if(!bookList.isEmpty()) {
            System.out.println(getListOfBooks());
            printTableLine();
        }
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca!\n";
    }

    public String getListOfBooks() {
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
