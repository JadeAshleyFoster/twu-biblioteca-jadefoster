package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ControllerTest {
    private Controller testController;
    private Library library;


    @Before
    public void setUp() {
        library = new Library();
        testController = new Controller(library);
    }

    @Test
    public void testUserInputListBooks() throws Exception {
        String output = testController.processInput("list books");
        assertEquals("list books", output);
    }

    @Test
    public void testUserInputListMovies() throws Exception {
        String output = testController.processInput("list movies");
        TestCase.assertEquals("list movies", output);
    }

    @Test
    public void testInvalidMenuChoice() throws Exception {
        String output = testController.processInput("gobbledigoop");
        assertEquals("invalid option", output);
    }

    @Test
    public void testQuit() throws Exception {
        String output = testController.processInput("quit");
        assertEquals("quit", output);
    }


    @Test
    public void testCheckOutABook() throws Exception {
        String input = "snow crash";
        Book bookToCheckOut = testController.checkOutABook(input);
        assertFalse(library.getBooks().contains(bookToCheckOut));
        assertTrue(library.getCheckedOutBooks().contains(bookToCheckOut));
    }

    @Test
    public void testInvalidCheckOutBook() throws Exception {
        String input = "2+2=5";
        LibraryItem invalidItem = testController.checkOutABook(input);
        assertFalse(library.getCheckedOutBooks().contains(invalidItem));
    }

    @Test
    public void testReturnABook() throws Exception {
        String input = "the nature of code";
        testController.checkOutABook(input);
        Book bookToReturn = testController.returnABook(input);
        assertFalse(library.getCheckedOutBooks().contains(bookToReturn));
        assertTrue(library.getBooks().contains(bookToReturn));
    }

    @Test
    public void testInvalidReturnBook() throws Exception {
        String input = "finkleburger";
        LibraryItem invalidItem = testController.returnABook(input);
        assertFalse(library.getBooks().contains(invalidItem));
    }


}
