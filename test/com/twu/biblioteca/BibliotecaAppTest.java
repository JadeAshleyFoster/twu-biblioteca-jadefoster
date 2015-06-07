package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    BibliotecaApp bibTest;

    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();
    }

    @Test
    public void testWelcomeMessage() {
        String output = bibTest.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca!\n", output);
    }

    @Test
    public void testListOfBooks() {
        String output = bibTest.getListOfBooks();
        assertEquals("# Perdido Street Station  #\n# China Mieville          #\n# 2000                    #\n" +
                "# Snow Crash              #\n# Neal Stephenson         #\n# 1992                    #\n" +
                "# The Nature of Code      #\n# Daniel Shiffman         #\n# 2012                    #", output);
    }

    @Test
    public void testBookListColumnHeaders() {
        String output = bibTest.getHeaders();
        assertEquals("#          TITLE          #          AUTHOR         #      YEAR PUBLISHED     #", output);
    }
}
