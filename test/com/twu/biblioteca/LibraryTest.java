package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LibraryTest {
    private Library testLibrary;
    private Book testBook;
    private Movie testMovie;

    @Before
    public void setUp() {
        testLibrary = new Library();
        testBook = testLibrary.getBooks().get(0);
        testMovie = testLibrary.getMovies().get(0);
    }

    @Test
    public void testCheckOutBook() throws Exception {
        testLibrary.checkOutBook(testBook);
        assertTrue(testLibrary.getCheckedOutBooks().contains(testBook));
        assertFalse(testLibrary.getBooks().contains(testBook));
    }

    @Test
    public void testCheckOutMovie() throws Exception {
        testLibrary.checkOutMovie(testMovie);
        assertTrue(testLibrary.getCheckedOutMovies().contains(testMovie));
        assertFalse(testLibrary.getMovies().contains(testMovie));
    }

    @Test
    public void testReturnBook() throws Exception {
        testLibrary.checkOutBook(testBook);
        testLibrary.returnBook(testBook);
        assertTrue(testLibrary.getBooks().contains(testBook));
        assertFalse(testLibrary.getCheckedOutBooks().contains(testBook));
    }

    @Test
    public void testReturnMovie() throws Exception {
        testLibrary.checkOutMovie(testMovie);
        testLibrary.returnMovie(testMovie);
        assertTrue(testLibrary.getMovies().contains(testMovie));
        assertFalse(testLibrary.getCheckedOutMovies().contains(testMovie));
    }

}
