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
    public void test() {
        String output = bibTest.getWelcome();
        assertEquals("Welcome to Biblioteca!", output);
    }
}
