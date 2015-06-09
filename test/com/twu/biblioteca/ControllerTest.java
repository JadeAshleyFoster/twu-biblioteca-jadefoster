package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ControllerTest {
    BibliotecaApp bibTest;
    Controller testController;


    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();
        bibTest.createBookList();
        bibTest.createMovieList();
        testController = new Controller(bibTest);
    }

    @Test
    public void testUserInputListBooks() {
        String output = testController.processMenuInput("list books");
        assertEquals("list books", output);
    }

    @Test
    public void testUserInputListMovies() {
        String output = testController.processMenuInput("list movies");
        TestCase.assertEquals("list movies", output);
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
