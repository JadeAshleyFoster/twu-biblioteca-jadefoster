package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> bookList, checkedOutBooks;
    Scanner scanner;
    Controller controller;
    ConsoleUI ui;


    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        bib.go();
    }

    public void go() {
        createBookList();

        checkedOutBooks = new ArrayList<Book>();

        ConsoleUI ui = new ConsoleUI();
        ui.printWelcome();

        Scanner scanner = new Scanner(System.in);

        Controller controller = new Controller(this);

        boolean quit = false;
        while (!quit) {
            String input = scanner.nextLine().toLowerCase();

            String processedInput = controller.processMenuInput(input);
            if (processedInput.equals("quit")) {
                quit = true;
                break;
            }

            System.out.println();
            ui.printMainMenu();
        }

        scanner.close();
    }

    private void createBookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        bookList.add(new Book("Snow Crash", "Neal Stephenson", 1992));
        bookList.add(new Book("The Nature of Code", "Daniel Shiffman", 2012));
        setBookList(bookList);
    }

    public void checkOutBook(Book book) {
        bookList.remove(book);
        checkedOutBooks.add(book);
    }

    public void returnBook(Book book) {
        checkedOutBooks.remove(book);
        bookList.remove(book);
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

}
