package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsoleUITest {
    BibliotecaApp bibTest;
    ConsoleUI testUI;
    Controller testController;

    @Before
    public void setUp() {
        bibTest = new BibliotecaApp();
        testController = new Controller(bibTest);
        bibTest.createBookList();
        bibTest.createMovieList();
        testUI = new ConsoleUI();
    }

    @Test
    public void testWelcomeMessage() {
        String output = testUI.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca!\n", output);
    }

    @Test
    public void testListOfBooks() {
        String output = testUI.getFormattedListOfItems(bibTest.getBookList());
        assertEquals("# Perdido Street Station  # China Mieville          # 2000                    #\n" +
                "# Snow Crash              # Neal Stephenson         # 1992                    #\n" +
                "# The Nature of Code      # Daniel Shiffman         # 2012                    #", output);
    }

    @Test
    public void testBookListColumnHeaders() {
        String output = testUI.getFormattedHeaders(bibTest.getBookList().get(0).getColumnHeaders());
        assertEquals("#          TITLE          #          AUTHOR         #      YEAR PUBLISHED     #", output);
    }

    @Test
    public void testMainMenuList() {
        String output = testUI.getMainMenu(testController.getMenuOptions());
        assertEquals("Main Menu:\t-\tList Books\t-\tCheck Out A Book\t-\tReturn A Book\t-\tList Movies\t-\tQuit\t-\t", output);
    }

    @Test
    public void testUserPrompt() {
        String output = testUI.getPrompt();
        assertEquals("Please choose an option ...> ", output);
    }

    @Test
    public void testMovieListColumnHeaders() {
        String output = testUI.getFormattedHeaders(bibTest.getMovieList().get(0).getColumnHeaders());
        assertEquals("#           NAME          #           YEAR          #         DIRECTOR        #          RATING         #", output);
    }

    @Test
    public void testListOfMovies() {
        String output = testUI.getFormattedListOfItems(bibTest.getMovieList());
        assertEquals("#          Akira          #           1988          #     Katsuhiro Otomo     #           8             #\n" +
                "#      Planet Terror      #           2007          #     Robert Rodriguez    #          7              #\n" +
                "#       Interstellar      #           2014          #    Christopher Nolan    #          8              #\n", output);
    }
}
