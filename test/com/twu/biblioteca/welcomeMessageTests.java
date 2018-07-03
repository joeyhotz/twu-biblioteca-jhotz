package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class welcomeMessageTests {

    @Test
    public void testMenuDisplaysWelcomeMessage() {
        String expectedOutputWelcomeMessage = BibliotecaApp.stringWelcomeMessage();
        String actualOutput = getBibliotecaOutput.asString();
        assertTrue(actualOutput.contains(expectedOutputWelcomeMessage));
    }

    @Test
    public void testWelcomeMessageString() {
        String expectedWelcomeMessage = "Hello! Welcome to Biblioteca.\n\nHere are our list of books: \n";
        String actualWelcomeMessage = BibliotecaApp.stringWelcomeMessage();
        assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
    }
}
