package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryItemTest {
    private Book testBook;
    private Movie testMovie;

    @Before
    public void setUp() {
        testBook = new Book("The Hollow Chocolate Bunnies of The Apocalypse", "Robert Rankin", "2002");
        testMovie = new Movie("Princess Mononoke", "1997", "Hayao Miyazaki", "9");
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
        ArrayList<String> output = testBook.getAllDetails();
        ArrayList<String> expectedDetails = new ArrayList<String>();
        expectedDetails.add("The Hollow Chocolate Bunnies of The Apocalypse");
        expectedDetails.add("Robert Rankin");
        expectedDetails.add("2002");
        assertEquals(expectedDetails, output);
    }

    @Test
    public void testMovieAllDetails() throws Exception {
        ArrayList<String> output = testMovie.getAllDetails();
        ArrayList<String> expectedDetails = new ArrayList<String>();
        expectedDetails.add("Princess Mononoke");
        expectedDetails.add("1997");
        expectedDetails.add("Hayao Miyazaki");
        expectedDetails.add("9");
        assertEquals(expectedDetails, output);
    }

    @Test
    public void testBookGetHeaders() throws Exception {
        ArrayList<String> output = testBook.getColumnHeaders();
        ArrayList<String> expectedColumnHeaders = new ArrayList<String>();
        expectedColumnHeaders.add("TITLE");
        expectedColumnHeaders.add("AUTHOR");
        expectedColumnHeaders.add("YEAR PUBLISHED");
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
        assertEquals(expectedColumnHeaders, output);
    }

    @Test
    public void testBookGetNumberOfColumns() throws Exception {
        int output = testBook.getNumberOfColumns();
        assertEquals(3, output);
    }

    @Test
    public void testMovieGetNumberOfCOlumns() throws Exception {
        int output = testMovie.getNumberOfColumns();
        assertEquals(4, output);
    }
}
