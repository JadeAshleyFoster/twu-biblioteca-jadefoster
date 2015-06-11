package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ControllerTest {
    private Controller testController;
    private User testUser;
    private Library library;


    @Before
    public void setUp() {
        library = new Library();
        testUser = (User) library.getLoginableMembers().get(0);
        testController = new Controller(library);
    }

    //TODO: Test check out/return a movie or book input...

    @Test
    public void testUserInputListBooks() throws Exception {
        String output = testController.processInput("list books", testUser);
        assertEquals("list books", output);
    }

    @Test
    public void testUserInputListMovies() throws Exception {
        String output = testController.processInput("list movies", testUser);
        TestCase.assertEquals("list movies", output);
    }

    @Test
    public void testInvalidMenuChoice() throws Exception {
        String output = testController.processInput("gobbledigoop", testUser);
        assertEquals("invalid option", output);
    }

    @Test
    public void testQuit() throws Exception {
        String output = testController.processInput("quit", testUser);
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
        Book invalidBook = testController.checkOutABook(input);
        assertFalse(library.getCheckedOutBooks().contains(invalidBook));
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
        Book invalidItem = testController.returnABook(input);
        assertFalse(library.getBooks().contains(invalidItem));
    }

    @Test
    public void testCheckOutAMovie() throws Exception {
        String input = "planet terror";
        Movie movieToCheckOut = testController.checkOutAMovie(input);
        assertFalse(library.getMovies().contains(movieToCheckOut));
        assertTrue(library.getCheckedOutMovies().contains(movieToCheckOut));
    }

    @Test
    public void testInvalidCheckOutMovie() throws Exception {
        String input = "harry potter and the donkey from Aldgate";
        Movie invalidMovie = testController.checkOutAMovie(input);
        assertFalse(library.getCheckedOutMovies().contains(invalidMovie));
    }

    @Test
    public void testReturnAMovie() throws Exception {
        String input = "planet terror";
        testController.checkOutAMovie(input);
        Movie movieToReturn = testController.returnAMovie(input);
        assertFalse(library.getCheckedOutMovies().contains(movieToReturn));
        assertTrue(library.getMovies().contains(movieToReturn));
    }

    @Test
    public void testInvalidReturnMovie() throws Exception {
        String input = "fghfbg,fbg,fd";
        Movie invalidItem = testController.returnAMovie(input);
        assertFalse(library.getMovies().contains(invalidItem));
    }


}
