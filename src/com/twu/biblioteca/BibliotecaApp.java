package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private ArrayList<Book> bookList, checkedOutBooks;
    private ArrayList<Movie> movieList;
    private String[] menuOptions;


    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        bib.go();
    }

    public void go() {
        createBookList();
        createMovieList();

        Controller controller = new Controller(this);
        createMenuOptions();

        ConsoleUI ui = new ConsoleUI();
        ui.printWelcome(menuOptions);

        boolean quit = false;
        while (!quit) {

            String processedInput = controller.processUserInput();
            if (processedInput.equals("quit")) {
                quit = true;
            } else {
                System.out.println();
                ui.printMainMenu(menuOptions);
            }
        }

    }

    public void createMenuOptions() {
        menuOptions = new String[5];     //TODO: Where should menu options go? It's own class?
        menuOptions[0] = "List Books";
        menuOptions[1] = "List Movies";
        menuOptions[2] = "Check Out a Book";
        menuOptions[3] = "Return a Book";
        menuOptions[4] = "Quit";
    }

    public void createMovieList() {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Akira", "1988", "Katsuhiro Otomo", "8"));
        movieList.add(new Movie("Planet Terror", "2007", "Robert Rodriguez", "7"));
        movieList.add(new Movie("Interstellar", "2014", "Christopher Nolan", "8"));
    }


    public void createBookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Perdido Street Station", "China Mieville", "2000"));
        bookList.add(new Book("Snow Crash", "Neal Stephenson", "1992"));
        bookList.add(new Book("The Nature of Code", "Daniel Shiffman", "2012"));
        checkedOutBooks = new ArrayList<Book>();
    }

    public void checkOutBook(Book book) {
        bookList.remove(book);
        checkedOutBooks.add(book);
    }

    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
        bookList.add(book);
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

}
