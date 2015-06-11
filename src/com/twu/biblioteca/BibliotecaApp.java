package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();

        library.addItem(new Movie("Akira", "1988", "Katsuhiro Otomo", "8"));
        library.addItem(new Movie("Planet Terror", "2007", "Robert Rodriguez", "unrated"));
        library.addItem(new Movie("Interstellar", "2014", "Christopher Nolan", "8"));
        library.addItem(new Book("Perdido Street Station", "China Mieville", "2000"));
        library.addItem(new Book("Snow Crash", "Neal Stephenson", "1992"));
        library.addItem(new Book("The Nature of Code", "Daniel Shiffman", "2012"));

        library.addUser(new User("123-4567", "IAmCool", "Dave Smith", "davesmith@something.com", "00123456789"));
        library.addUser(new User("567-8910", "ilovebunnierabbits", "Bunny Rabbit", "bunnyrabbit@something.com", "00987654321"));
        library.addUser(new Librarian("XXX-XXXX", "librarian'saregreat"));

        Controller controller = new Controller(library);
        controller.go();
    }


}
