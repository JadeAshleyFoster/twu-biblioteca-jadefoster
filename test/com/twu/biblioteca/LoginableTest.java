package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LoginableTest {

    @Test
    public void testIsALibrarian () throws Exception {
        User testUser = new User("123-4567", "IAmCool", "Dave Smith", "davesmith@something.com", "00123456789");
        assertFalse(testUser.isLibrarian());
        Librarian testLibrarian = new Librarian("XXX-XXXX", "librarian'saregreat");
        assertTrue(testLibrarian.isLibrarian());
    }


}
