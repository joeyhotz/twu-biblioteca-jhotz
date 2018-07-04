package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class welcomeMessageTests {

    @Test
    public void testWelcomeMessageString() {
        String expectedWelcomeMessage = "Hello! Welcome to Biblioteca.\n\nWhat would you like to do?\n\n";
        String actualWelcomeMessage = BibliotecaApp.returnWelcomeMessage();
        assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
    }
}
