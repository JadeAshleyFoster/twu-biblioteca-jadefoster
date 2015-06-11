package com.twu.biblioteca;

import java.util.ArrayList;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LibraryTest {
    Library testLibrary;
    Movie testMovie;
    Book testBook;
    User testUser;

    @Before
    public void setUp() {
        testLibrary = new Library();
        testMovie = new Movie("Akira", "1988", "Katsuhiro Otomo", "8");
        testBook = new Book("Perdido Street Station", "China Mieville", "2000");
        testUser = new User("123-4567", "IAmCool", "Dave Smith", "davesmith@something.com", "00123456789");
        testLibrary.addItem(testMovie);
        testLibrary.addItem(testBook);
        testLibrary.addUser(testUser);
    }

    @Test
    public void testGetCheckedOutMovies() throws Exception {
        ArrayList<LibraryItem> output = testLibrary.getCheckedOut("movie");
        assertTrue(output.isEmpty());
        testMovie.setCheckedOutBy(testUser);
        ArrayList<LibraryItem> output2 = testLibrary.getCheckedOut("movie");
        assertTrue(output2.contains(testMovie));
    }

    @Test
    public void testGetCheckedOutBooks() throws Exception {
        ArrayList<LibraryItem> output = testLibrary.getCheckedOut("book");
        assertTrue(output.isEmpty());
        testBook.setCheckedOutBy(testUser);
        ArrayList<LibraryItem> output2 = testLibrary.getCheckedOut("book");
        assertTrue(output2.contains(testBook));
    }

    @Test
    public void testGetAllMovies() throws Exception {
        ArrayList<LibraryItem> output = testLibrary.getAll("movie");
        assertTrue(output.contains(testMovie));
        assertTrue(output.size() == 1);
    }

    @Test
    public void testGetAllBooks() throws Exception {
        ArrayList<LibraryItem> output = testLibrary.getAll("book");
        assertTrue(output.contains(testBook));
        assertTrue(output.size() == 1);
    }

    @Test
    public void testValidUserID() throws Exception {
        Loginable output = testLibrary.isValidUserID("123-4567");
        assertEquals(output, testUser);
    }

    @Test
    public void testInvalidUserID() throws Exception {
        Loginable output = testLibrary.isValidUserID("111-1111");
        assertEquals(output, null);
    }

    @Test
    public void testCheckOutAnItem() throws Exception {
        testLibrary.checkOutItem(testBook, testUser);
        assertTrue(testBook.isCheckedOut());
        assertEquals(testBook.getCheckedOutBy(), testUser);
        testLibrary.checkOutItem(testMovie, testUser);
        assertTrue(testMovie.isCheckedOut());
        assertEquals(testMovie.getCheckedOutBy(), testUser);
    }

    @Test
    public void testReturnAnItem() throws Exception {
        testLibrary.checkOutItem(testBook, testUser);
        testLibrary.returnItem(testBook);
        assertFalse(testBook.isCheckedOut());
        testLibrary.checkOutItem(testMovie, testUser);
        testLibrary.returnItem(testMovie);
        assertFalse(testMovie.isCheckedOut());
    }

    @Test
    public void testIsALibraryItem() throws Exception {
        LibraryItem output = testLibrary.isALibraryItem("akira");
        assertEquals(output, testMovie);
        LibraryItem output2 = testLibrary.isALibraryItem("perdido street station");
        assertEquals(output2, testBook);
    }

    @Test
    public void testInvalidItemIsALibraryItem () throws Exception {
        LibraryItem output = testLibrary.isALibraryItem("lalala");
        assertEquals(output, null);
    }

    @Test
    public void testAddItemToLibrary () throws Exception {
        Book book = new Book("Book", "Book", "Book");
        testLibrary.addItem(book);
        assertTrue(testLibrary.getItems().contains(book));
        Movie movie = new Movie("Movie", "Movie", "Movie", "Movie");
        testLibrary.addItem(movie);
        assertTrue(testLibrary.getItems().contains(movie));
    }

    @Test
    public void testAddUserToLibrary() throws Exception {
        User user = new User("User", "User", "User", "User", "User");
        testLibrary.addUser(user);
        assertTrue(testLibrary.getUsers().contains(user));
        Librarian librarian = new Librarian("librarian", "librarian");
        testLibrary.addUser(librarian);
        assertTrue(testLibrary.getUsers().contains(librarian));
    }


}
