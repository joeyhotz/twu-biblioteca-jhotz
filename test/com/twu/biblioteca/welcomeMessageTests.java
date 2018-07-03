package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class welcomeMessageTests {

    @Test
    public void testWelcomeMessage() {
        String expectedWelcomeMessage = "Hello! Welcome to Biblioteca.\n\nHere are our list of books: \n";
        String actualWelcomeMessage = getBibliotecaOutput.asString();
        assertTrue(actualWelcomeMessage.contains(expectedWelcomeMessage));
    }
}
