package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    ArrayList<Book> bookList, checkedOutBooks;
    ArrayList<Movie> movieList;


    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        bib.go();
    }

    public void go() {
        createBookList();
        createMovieList();

        Controller controller = new Controller(this);

        ConsoleUI ui = new ConsoleUI();
        ui.printWelcome(controller.getMenuOptions());

        boolean quit = false;
        while (!quit) {

            String processedInput = controller.processUserInput();
            if (processedInput.equals("quit")) {
                quit = true;
            } else {
                System.out.println();
                ui.printMainMenu(controller.getMenuOptions());
            }
        }

    }

    public void createMovieList() {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Akira", "1998", "Katsuhiro Otomo", "8"));
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
