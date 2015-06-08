package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class ConsoleUITest {
    BibliotecaApp bibTest;
    ConsoleUI testUI;
    ArrayList<Book> testBookList;

    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();

        testBookList = new ArrayList<Book>();
        testBookList.add(new Book("Perdido Street Station", "China Mieville", 2000));
        testBookList.add( new Book("Snow Crash", "Neal Stephenson", 1992));
        testBookList.add( new Book("The Nature of Code", "Daniel Shiffman", 2012));
        bibTest.setBookList(testBookList);

        testUI = new ConsoleUI();
    }

    @Test
    public void testWelcomeMessage() {
        String output = testUI.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca!\n", output);
    }

    @Test
    public void testListOfBooks() {
        String output = testUI.getFormattedListOfBooks(testBookList);
        assertEquals("# Perdido Street Station  # China Mieville          # 2000                    #\n" +
                "# Snow Crash              # Neal Stephenson         # 1992                    #\n" +
                "# The Nature of Code      # Daniel Shiffman         # 2012                    #", output);
    }

    @Test
    public void testBookListColumnHeaders() {
        String output = testUI.getHeaders();
        assertEquals("#          TITLE          #          AUTHOR         #      YEAR PUBLISHED     #", output);
    }

    @Test
    public void testMainMenuList() {
        String output = testUI.getMainMenu();
        assertEquals("Main Menu:\tList Books", output);
    }

    @Test
    public void testUserPrompt() {
        String output = testUI.getPrompt();
        assertEquals("Please choose an option ...> ", output);
    }
}
