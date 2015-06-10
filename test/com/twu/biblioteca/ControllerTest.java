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
        LibraryItem itemToCheckOut = testController.checkOutAnItem(input);
        assertFalse(library.getLibraryItems().contains(itemToCheckOut));
        assertTrue(library.getCheckedOutItems().contains(itemToCheckOut));
    }

    @Test
    public void testInvalidCheckOutBook() throws Exception {
        String input = "2+2=5";
        LibraryItem invalidItem = testController.checkOutAnItem(input);
        assertFalse(library.getCheckedOutItems().contains(invalidItem));
    }

    @Test
    public void testReturnABook() throws Exception {
        String input = "the nature of code";
        testController.checkOutAnItem(input);
        LibraryItem itemToReturn = testController.returnAnItem(input);
        assertFalse(library.getCheckedOutItems().contains(itemToReturn));
        assertTrue(library.getLibraryItems().contains(itemToReturn));
    }

    @Test
    public void testInvalidReturnBook() throws Exception {
        String input = "finkleburger";
        LibraryItem invalidItem = testController.returnAnItem(input);
        assertFalse(library.getLibraryItems().contains(invalidItem));
    }


}
