package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class BibliotecaAppTest {
    BibliotecaApp bibTest;

    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();
        ArrayList<Book> testBookList = new ArrayList<Book>();
        testBookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        testBookList.add( new Book("Snow Crash", "Neal Stephenson", 1992));
        testBookList.add( new Book("The Nature of Code", "Daniel Shiffman", 2012));
        bibTest.setBookList(testBookList);
    }

    @Test
    public void testWelcomeMessage() {
        String output = bibTest.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca!\n", output);
    }

    @Test
    public void testListOfBooks() {
        String output = bibTest.getListOfBooks();
        assertEquals("# Perdido Street Station  # China Mieville          # 2000                    #\n" +
                "# Snow Crash              # Neal Stephenson         # 1992                    #\n" +
                "# The Nature of Code      # Daniel Shiffman         # 2012                    #", output);
    }

    @Test
    public void testBookListColumnHeaders() {
        String output = bibTest.getHeaders();
        assertEquals("#          TITLE          #          AUTHOR         #      YEAR PUBLISHED     #", output);
    }
}
