package com.twu.biblioteca;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LibraryItemTest {
    private Book testBook;
    private Movie testMovie;
    private User testUser;
    private Librarian testLibrarian;

    @Before
    public void setUp() {
        testBook = new Book("The Hollow Chocolate Bunnies of The Apocalypse", "Robert Rankin", "2002");
        testMovie = new Movie("Princess Mononoke", "1997", "Hayao Miyazaki", "9");
        testUser = new User("123-4567", "IAmCool", "Dave Smith", "davesmith@something.com", "00123456789");
        testLibrarian = new Librarian("XXX-XXXX", "librarian'saregreat");
    }

    @Test
    public void testIsCheckedOut() throws Exception {
        assertFalse(testBook.isCheckedOut());
        assertFalse(testMovie.isCheckedOut());
        testBook.setCheckedOutBy(testUser);
        assertTrue(testBook.isCheckedOut());
        testMovie.setCheckedOutBy(testUser);
        assertTrue(testMovie.isCheckedOut());
    }

    @Test
    public void testSetAndGetCheckedOutBy() throws Exception {
        testMovie.setCheckedOutBy(testUser);
        assertEquals(testMovie.getCheckedOutBy(), testUser);
        testBook.setCheckedOutBy(testUser);
        assertEquals(testBook.getCheckedOutBy(), testUser);
    }

    @Test
    public void testAvailable() throws Exception {
        assertEquals(testBook.available(testUser), "Available");
        assertEquals(testBook.available(testLibrarian), "Available");
        assertEquals(testMovie.available(testUser), "Available");
        assertEquals(testMovie.available(testLibrarian), "Available");
        testBook.setCheckedOutBy(testUser);
        assertEquals(testBook.available(testUser), "Checked Out");
        testMovie.setCheckedOutBy(testUser);
        assertEquals(testMovie.available(testUser), "Checked Out");
        assertEquals(testBook.available(testLibrarian), "Checked Out By: 123-4567");
        assertEquals(testMovie.available(testLibrarian), "Checked Out By: 123-4567");
    }

    @Test
    public void testBookToString() throws Exception {
        String output = testBook.toString();
        assertEquals("book", output);
    }

    @Test
    public void testMovieToString() throws Exception {
        String output = testMovie.toString();
        assertEquals("movie", output);
    }

    @Test
    public void testBookAllDetails() throws Exception {
        ArrayList<String> output = testBook.getAllDetails(testUser);
        ArrayList<String> expectedDetails = new ArrayList<String>();
        expectedDetails.add("The Hollow Chocolate Bunnies of The Apocalypse");
        expectedDetails.add("Robert Rankin");
        expectedDetails.add("2002");
        expectedDetails.add("Available");
        assertEquals(expectedDetails, output);
    }

    @Test
    public void testMovieAllDetails() throws Exception {
        ArrayList<String> output = testMovie.getAllDetails(testUser);
        ArrayList<String> expectedDetails = new ArrayList<String>();
        expectedDetails.add("Princess Mononoke");
        expectedDetails.add("1997");
        expectedDetails.add("Hayao Miyazaki");
        expectedDetails.add("9");
        expectedDetails.add("Available");
        assertEquals(expectedDetails, output);
    }

    @Test
    public void testBookGetHeaders() throws Exception {
        ArrayList<String> output = testBook.getColumnHeaders();
        ArrayList<String> expectedColumnHeaders = new ArrayList<String>();
        expectedColumnHeaders.add("TITLE");
        expectedColumnHeaders.add("AUTHOR");
        expectedColumnHeaders.add("YEAR PUBLISHED");
        expectedColumnHeaders.add("STATUS");
        assertEquals(expectedColumnHeaders, output);
    }

    @Test
    public void testMovieGetHeaders() throws Exception {
        ArrayList<String> output = testMovie.getColumnHeaders();
        ArrayList<String> expectedColumnHeaders = new ArrayList<String>();
        expectedColumnHeaders.add("NAME");
        expectedColumnHeaders.add("YEAR");
        expectedColumnHeaders.add("DIRECTOR");
        expectedColumnHeaders.add("RATING");
        expectedColumnHeaders.add("STATUS");
        assertEquals(expectedColumnHeaders, output);
    }

    @Test
    public void testBookGetNumberOfColumns() throws Exception {
        int output = testBook.getNumberOfColumns();
        assertEquals(4, output);
    }

    @Test
    public void testMovieGetNumberOfCOlumns() throws Exception {
        int output = testMovie.getNumberOfColumns();
        assertEquals(5, output);
    }
}
