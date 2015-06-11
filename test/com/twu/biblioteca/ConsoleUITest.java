package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsoleUITest {
    private ConsoleUI testUI;
    private Library testLibrary;
    private Librarian testLibrarian;
    private User testUser;
    private Book testBook;
    private Movie testMovie;
    private Controller testController;


    @Before
    public void setUp() {
        testLibrary = new Library();
        testBook = new Book("Perdido Street Station", "China Mieville", "2000");
        testMovie = new Movie("Planet Terror", "2007", "Robert Rodriguez", "unrated");
        testLibrary.addItem(testMovie);
        testLibrary.addItem(new Movie("Interstellar", "2014", "Christopher Nolan", "8"));
        testLibrary.addItem(testBook);
        testLibrary.addItem(new Book("Snow Crash", "Neal Stephenson", "1992"));
        testUI = new ConsoleUI();
        testUser = new User("567-8910", "ilovebunnierabbits", "Bunny Rabbit", "bunnyrabbit@something.com", "00987654321");
        testLibrarian = new Librarian("XXX-XXXX", "librarian'saregreat");
        testController = new Controller(testLibrary);
    }

    @Test
    public void testWelcomeMessage() throws Exception{
        assertEquals("Welcome to Biblioteca!\n", testUI.printWelcome());
    }

    @Test
    public void testAskForLoginID() throws Exception{
        assertEquals("Please enter your library number:\n...>", testUI.printAskForLoginID());
    }

    @Test
    public void testAskForPassword() throws Exception{
        assertEquals("Please enter your password:\n...>", testUI.printAskForPassword());
    }

    @Test
    public void testIncorrectPassword() throws Exception{
        assertEquals("That password is incorrect.", testUI.printIncorrectPasswordMessage());
    }

    @Test
    public void testSuccessfulLogin() throws Exception{
        assertEquals("Successful login.\n", testUI.printSuccessfulLogin());
    }

    @Test
    public void testIncorrectLoginID() throws Exception{
        assertEquals("That is not a valid library number. A library number is in the format XXX-XXXX.\n", testUI.printIncorrectLoginIDMessage());
    }

    @Test
    public void testMainMenuForUser() throws Exception{
        testController.createMenuOptions(testUser);
        assertEquals("\nMain Menu:\t-\tList Books\t-\tList Movies\t-\tCheck Out an Item\t-\tReturn an Item\t-\tUser Information\t-\tQuit\t-\t\n" +
                "Please enter an option.\n...>", testUI.printMainMenu(testController.getMenuOptions()));
    }

    @Test
    public void testMainMenuForLibrarian() throws Exception {
        testController.createMenuOptions(testLibrarian);
        assertEquals("\nMain Menu:\t-\tList Books\t-\tList Movies\t-\tCheck Out an Item\t-\tReturn an Item\t-\tList Checked Out Books\t-\tList Checked Out Movies\t-\tUser Information\t-\tQuit\t-\t\n" +
                "Please enter an option.\n...>", testUI.printMainMenu(testController.getMenuOptions()));
    }

    @Test
    public void testInvalidItemMessage() throws Exception {
        assertEquals("That item is not available.", testUI.printInvalidItemMessage());
    }

    @Test
    public void testInvalidItemToReturn() throws Exception {
        assertEquals("That is not a valid item to return.", testUI.printInvalidItemToReturnMessage());
    }

    @Test
    public void testReturnItemMessage() throws Exception {
        assertEquals("Thank you for returning the book.", testUI.printItemReturnedMessage(testBook));
        assertEquals("Thank you for returning the movie.", testUI.printItemReturnedMessage(testMovie));
    }

    @Test
    public void testCheckOutItemMessae() throws Exception {
        assertEquals("Thank you! Enjoy the book.", testUI.printItemCheckedOutMessage(testBook));
        assertEquals("Thank you! Enjoy the movie.", testUI.printItemCheckedOutMessage(testMovie));
    }

    @Test
    public void tetPrintUserInformation() {
        assertEquals("No Information available for librarian user.", testUI.printUserInformation(testLibrarian));
        assertEquals("\nName: Bunny Rabbit\ne-mail: bunnyrabbit@something.com\nPhone: 00987654321", testUI.printUserInformation(testUser));
    }

    @Test
    public void testTableOfBooks() throws Exception{
        String output = testUI.printTableOfBooks(testLibrary.getAll("book"), testUser);
        assertEquals("#####################################################################################################################\n" +
                "# TITLE                      # AUTHOR                     # YEAR PUBLISHED             # STATUS                     #\n" +
                "#####################################################################################################################\n" +
                "# Perdido Street Station     # China Mieville             # 2000                       # Available                  #\n" +
                "# Snow Crash                 # Neal Stephenson            # 1992                       # Available                  #\n" +
                "#####################################################################################################################\n", output);
    }

    @Test
    public void testInvalidMenuOptionEntered() throws Exception{
        assertEquals("Sorry that is not a valid option. Please choose another.\n", testUI.printInvalidMenuOptionMessage());
    }

    @Test
    public void testGoodbyeMessage() throws Exception{
        assertEquals("Thank you for using Biblioteca, goodbye.", testUI.printGoodBye());
    }

    @Test
    public void testWhichItemToCheckOutQuery() throws Exception{
        assertEquals("Please enter the title of the item you would like to check out.\n...>", testUI.printQueryWhichItemToCheckOut());
    }

    @Test
    public void testWhichItemTOReturnQuery() throws Exception{
        assertEquals("Please enter the title of the item you would like to return.\n...>", testUI.printQueryWhichItemToReturn());
    }

    @Test
    public void testListOfMovies() throws Exception{
        String output = testUI.printTableOfMovies(testLibrary.getAll("movie"), testLibrarian);
        assertEquals("##################################################################################################################################################\n" +
                        "# NAME                       # YEAR                       # DIRECTOR                   # RATING                     # STATUS                     #\n" +
                        "##################################################################################################################################################\n" +
                "# Planet Terror              # 2007                       # Robert Rodriguez           # unrated                    # Available                  #\n" +
                "# Interstellar               # 2014                       # Christopher Nolan          # 8                          # Available                  #\n" +
                "##################################################################################################################################################\n", output);
    }

}
