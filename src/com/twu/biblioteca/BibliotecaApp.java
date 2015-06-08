package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    ArrayList<Book> bookList;

    public static void main(String[] args) {
        BibliotecaApp bib = new BibliotecaApp();
        bib.go();
    }

    public void go() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        bookList.add(new Book("Snow Crash", "Neal Stephenson", 1992));
        bookList.add(new Book("The Nature of Code", "Daniel Shiffman", 2012));
        setBookList(bookList);

        ConsoleUI ui = new ConsoleUI();
        ui.printWelcome();

        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            String input = scanner.nextLine().toLowerCase();

            Interpreter interpreter = new Interpreter();
            String processedInput = interpreter.processInput(input, this);
            if (processedInput.equals("quit")) {
                quit = true;
            }

            ui.printMainMenu();
        }
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

}
