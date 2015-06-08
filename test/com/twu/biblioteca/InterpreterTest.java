package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InterpreterTest {
    BibliotecaApp bibTest;
    ArrayList<Book> testBookList;
    Interpreter testInterpreter;


    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();

        testBookList = new ArrayList<Book>();
        testBookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        testBookList.add( new Book("Snow Crash", "Neal Stephenson", 1992));
        testBookList.add( new Book("The Nature of Code", "Daniel Shiffman", 2012));
        bibTest.setBookList(testBookList);

        testInterpreter = new Interpreter(bibTest);
    }

    @Test
    public void testUserInputListBooks() {
        String output = testInterpreter.processMenuInput("list books");
        assertEquals("list books", output);
    }

    @Test
    public void testInvalidMenuChoice() {
        String output = testInterpreter.processMenuInput("gobbledigoop");
        assertEquals("invalid option", output);
    }

    @Test
    public void testQuit() {
        String output = testInterpreter.processMenuInput("quit");
        assertEquals("quit", output);
    }

    @Test
    public void testCheckOutBookMenuOption() {
        String output = testInterpreter.processMenuInput("check out a book");
        assertEquals("check out a book", output);
    }

    @Test
    public void testCheckOutABook() {
        Book book = testInterpreter.processBookInput("perdido street station", testBookList);
        assertEquals(testBookList.get(0), book);
    }

    @Test
    public void testReturnBookMenuOption() {
        String output = testInterpreter.processMenuInput("return a book");
        assertEquals("return a book", output);
    }

}
