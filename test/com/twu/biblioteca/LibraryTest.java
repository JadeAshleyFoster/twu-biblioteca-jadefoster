package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LibraryTest {
    private Library testLibrary;
    private LibraryItem testLibraryItem;

    @Before
    public void setUp() {
        testLibrary = new Library();
        testLibraryItem = testLibrary.getLibraryItems().get(0);
    }

    @Test
    public void testCheckOutItem() throws Exception {
        testLibrary.checkOutItem(testLibraryItem);
        assertTrue(testLibrary.getCheckedOutItems().contains(testLibraryItem));
        assertFalse(testLibrary.getLibraryItems().contains(testLibraryItem));
    }

    @Test
    public void testReturnItem() throws Exception {
        testLibrary.checkOutItem(testLibraryItem);
        testLibrary.returnItem(testLibraryItem);
        assertTrue(testLibrary.getLibraryItems().contains(testLibraryItem));
        assertFalse(testLibrary.getCheckedOutItems().contains(testLibraryItem));
    }


}
