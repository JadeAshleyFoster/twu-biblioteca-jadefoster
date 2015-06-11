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
    private Library testLibrary;
    private Book testBook;
    private Movie testMovie;


    @Before
    public void setUp() {
        testLibrary = new Library();
        testUser = new User("123-4567", "IAmCool", "Dave Smith", "davesmith@something.com", "00123456789");
        testMovie = new Movie("Akira", "1988", "Katsuhiro Otomo", "8");
        testBook = new Book("Perdido Street Station", "China Mieville", "2000");
        testLibrary.addItem(testBook);
        testLibrary.addItem(testMovie);
        testLibrary.addUser(testUser);
        testController = new Controller(testLibrary);
    }

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
    public void testEnterValidPassword() {
        assertTrue(testController.isCorrectPasswordFromUser(testUser, "IAmCool"));
    }

    @Test
    public void testEnterInvalidPassword() {
        assertFalse(testController.isCorrectPasswordFromUser(testUser, "IAMNOTCOOL"));
    }

    @Test
    public void testCheckOutABook() throws Exception {
        String input = "perdido street station";
        LibraryItem bookToCheckOut = testController.checkOutAnItem(input, testUser);
        assertTrue(bookToCheckOut.isCheckedOut());
    }

    @Test
    public void testReturnABook() throws Exception {
        String input = "perdido street station";
        testController.checkOutAnItem(input, testUser);
        LibraryItem bookToReturn = testController.returnAnItem(input);
        assertFalse(testLibrary.getCheckedOut("book").contains(bookToReturn));
    }

    @Test
    public void testCheckOutAMovie() throws Exception {
        String input = "akira";
        LibraryItem movieToCheckOut = testController.checkOutAnItem(input, testUser);
        assertTrue(movieToCheckOut.isCheckedOut());
    }

    @Test
    public void testReturnAMovie() throws Exception {
        String input = "akira";
        testController.checkOutAnItem(input, testUser);
        LibraryItem movieToReturn = testController.returnAnItem(input);
        assertFalse(testLibrary.getCheckedOut("movie").contains(movieToReturn));
    }

}
