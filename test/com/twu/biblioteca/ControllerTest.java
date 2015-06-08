package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ControllerTest {
    BibliotecaApp bibTest;
    Controller testController;


    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();

        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        testBookList.add(new Book("Snow Crash", "Neal Stephenson", 1992));
        testBookList.add(new Book("The Nature of Code", "Daniel Shiffman", 2012));
        bibTest.setBookList(testBookList);

        bibTest.setCheckedOutBooks(new ArrayList<Book>());

        testController = new Controller(bibTest);
    }

    @Test
    public void testUserInputListBooks() {
        String output = testController.processMenuInput("list books");
        assertEquals("list books", output);
    }

    @Test
    public void testInvalidMenuChoice() {
        String output = testController.processMenuInput("gobbledigoop");
        assertEquals("invalid option", output);
    }

    @Test
    public void testQuit() {
        String output = testController.processMenuInput("quit");
        assertEquals("quit", output);
    }


    @Test
    public void testCheckOutABook() {
        String input = "snow crash";
        Book bookToCheckOut = testController.checkOutABook(input);
        assertFalse(bibTest.getBookList().contains(bookToCheckOut));
        assertTrue(bibTest.getCheckedOutBooks().contains(bookToCheckOut));
    }

    @Test
    public void testInvalidCheckOutBook() {
        String input = "2+2=5";
        Book invalidBookToCheckOut = testController.checkOutABook(input);
        assertFalse(bibTest.getCheckedOutBooks().contains(invalidBookToCheckOut));
    }

    @Test
    public void testReturnABook() {
        String input = "the nature of code";
        testController.checkOutABook(input);
        Book returnedBook = testController.returnABook(input);
        assertFalse(bibTest.getCheckedOutBooks().contains(returnedBook));
        assertTrue(bibTest.getBookList().contains(returnedBook));
    }

    @Test
    public void testInvalidReturnBook() {
        String input = "finkleburger";
        Book invalidBookToReturn = testController.returnABook(input);
        assertFalse(bibTest.getBookList().contains(invalidBookToReturn));
    }


}
