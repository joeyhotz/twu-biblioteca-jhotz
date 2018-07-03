package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTests {

    @Test
    public void testWelcomeMessage() {
        String expectedWelcomeMessage = "Hello! Welcome to Biblioteca.";
        String actualWelcomeMessage = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            BibliotecaApp.main(new String[]{});
            capture.flush();
            actualWelcomeMessage = os.toString();
        } catch (Exception ex){
            System.err.println("Test unable to get output from main");
        }

        assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
    }
}
