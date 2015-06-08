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
            } else if (processedInput.equals("check out a book")) {
                checkOutABook();
            } else if(processedInput.equals("return a book")) {
                returnABook();
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

    private void checkOutABook() {
        String input = scanner.nextLine().toLowerCase();
        Book bookChosen = controller.processBookInput(input, bookList);
        if (bookChosen == null) {
            ui.printInvalidBookMessage();
        } else {
            ui.printBookCheckedOutMessage(bookChosen);
            bookList.remove(bookChosen);
            checkedOutBooks.add(bookChosen);
        }
    }

    private void returnABook() {
        String input = scanner.nextLine().toLowerCase();
        Book bookReturned = controller.processBookInput(input, checkedOutBooks);
        if (bookReturned == null) {
            ui.printInvalidBookToReturnMessage();
        } else {
            ui.printBookReturnedMessage(bookReturned);
            bookList.add(bookReturned);
            checkedOutBooks.remove(bookReturned);
        }
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

}
