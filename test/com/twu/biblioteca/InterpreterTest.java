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

        testInterpreter = new Interpreter();
    }

    @Test
    public void testUserInputListBooks() {
        String output = testInterpreter.processInput("list books", bibTest);
        assertEquals("list books", output);
    }

    @Test
    public void testInvalidMenuChoice() {
        String output = testInterpreter.processInput("gobbledigoop", bibTest);
        assertEquals("invalid option", output);
    }

    @Test
    public void testQuit() {
        String output = testInterpreter.processInput("quit", bibTest);
        assertEquals("quit", output);
    }

}
