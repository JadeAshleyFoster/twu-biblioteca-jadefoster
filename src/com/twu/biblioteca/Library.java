package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books, checkedOutBooks;
    private ArrayList<Movie> movies, checkedOutMovies;

    public Library() {
        createBooks();
        createMovies();
    }

    private void createMovies() {
        movies = new ArrayList<Movie>();
        movies.add(new Movie("Akira", "1988", "Katsuhiro Otomo", "8"));
        movies.add(new Movie("Planet Terror", "2007", "Robert Rodriguez", "7"));
        movies.add(new Movie("Interstellar", "2014", "Christopher Nolan", "8"));
        checkedOutMovies = new ArrayList<Movie>();
    }

    private void createBooks() {
        books = new ArrayList<Book>();
        books.add(new Book("Perdido Street Station", "China Mieville", "2000"));
        books.add(new Book("Snow Crash", "Neal Stephenson", "1992"));
        books.add(new Book("The Nature of Code", "Daniel Shiffman", "2012"));
        checkedOutBooks = new ArrayList<Book>();
    }

    public ArrayList<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }


    public void checkOutBook(Book book) {
        books.remove(book);
        checkedOutBooks.add(book);
    }

    public void returnBook(Book book) {
        books.add(book);
        checkedOutBooks.remove(book);
    }

    public void checkOutMovie(Movie movie) {
        movies.remove(movie);
        checkedOutMovies.add(movie);
    }
}
