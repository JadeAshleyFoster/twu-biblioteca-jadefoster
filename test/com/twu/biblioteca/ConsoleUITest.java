package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsoleUITest {
    private ConsoleUI testUI;
    private Library library;
    private Controller controller;

    @Before
    public void setUp() {
        library = new Library();
        testUI = new ConsoleUI();
        controller = new Controller(library);
    }

    @Test
    public void testWelcomeMessage() {
        String output = testUI.getWelcomeMessage();
        assertEquals("Welcome to Biblioteca!\n", output);
    }

    @Test
    public void testListOfBooks() {
        String output = testUI.getFormattedListOfItems(library.getLibraryItems(), "book");
        assertEquals("# Perdido Street Station  # China Mieville          # 2000                    #\n" +
                "# Snow Crash              # Neal Stephenson         # 1992                    #\n" +
                "# The Nature of Code      # Daniel Shiffman         # 2012                    #", output);
    }

    /*@Test
    public void testBookListColumnHeaders() {
        String output = testUI.getFormattedHeaders(library.getLibraryItems().get(0).getColumnHeaders());
        assertEquals("#          TITLE          #          AUTHOR         #      YEAR PUBLISHED     #", output);
    }

    @Test
    public void testMainMenuList() {
        String output = testUI.getMainMenu(controller.getMenuOptions());
        assertEquals("Main Menu:\t-\tList Books\t-\tList Movies\t-\tCheck Out a Book\t-\tReturn a Book\t-\tQuit\t-\t", output);
    }

    @Test
    public void testUserPrompt() {
        String output = testUI.getPrompt();
        assertEquals("Please choose an option ...> ", output);
    }

    @Test
    public void testMovieListColumnHeaders() {
        String output = testUI.getFormattedHeaders(library.getLibraryItems().get(0).getColumnHeaders());    //TODO: doesnt take into consideration type
        assertEquals("#           NAME          #           YEAR          #         DIRECTOR        #          RATING         #", output);
    }

    @Test
    public void testListOfMovies() {
        String output = testUI.getFormattedListOfItems(library.getLibraryItems(), "movie");
        assertEquals("# Akira                   # 1988                    # Katsuhiro Otomo         # 8                       #\n" +
                "# Planet Terror           # 2007                    # Robert Rodriguez        # 7                       #\n" +
                "# Interstellar            # 2014                    # Christopher Nolan       # 8                       #", output);
    }*/
}
