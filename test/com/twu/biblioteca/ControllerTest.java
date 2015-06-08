package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ControllerTest {
    BibliotecaApp bibTest;
    ArrayList<Book> testBookList;
    Controller testController;


    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();

        testBookList = new ArrayList<Book>();
        testBookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        testBookList.add( new Book("Snow Crash", "Neal Stephenson", 1992));
        testBookList.add( new Book("The Nature of Code", "Daniel Shiffman", 2012));
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
        String bookToCheckOut = "snow crash";
        testController.checkOutABook(bookToCheckOut);
        assertFalse(bibTest.getBookList().contains(bookToCheckOut));
        assertTrue(bibTest.getCheckedOutBooks().contains(bookToCheckOut));
    }

    @Test
    public void testInvalidCheckOutBook() {
        String invalidBook = "2+2=5";
        testController.checkOutABook(invalidBook);
        assertFalse(bibTest.getCheckedOutBooks().contains(invalidBook));
    }

    @Test
    public void testReturnABook() {
        String bookToReturn = "the nature of code";
        testController.checkOutABook(bookToReturn);
        testController.returnABook(bookToReturn);
        assertFalse(bibTest.getCheckedOutBooks().contains(bookToReturn));
        assertTrue(bibTest.getBookList().contains(bookToReturn));
    }

    @Test
    public void testInvalidReturnBook() {
        String invalidBook = "finkleburger";
        testController.returnABook(invalidBook);
        assertFalse(bibTest.getBookList().contains(invalidBook));
    }


}
