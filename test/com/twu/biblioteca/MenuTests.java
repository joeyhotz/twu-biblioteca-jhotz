package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MenuTests {

    @Test
    public void testPrintToConsole() {
        String stringToTest = "Hello world!\nTestTest\n\n";

        String actualOutput = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            System.out.println(stringToTest);
            capture.flush();
            actualOutput = os.toString();
        } catch (Exception ex) {
            System.err.println("Test unable to get output from main");
        }

        assertEquals(stringToTest, actualOutput);
    }

    @Test
    public void testLoggedIn() {
        BibliotecaApp instance = new BibliotecaApp();
        instance.getUserManager().login("123", "test");
        assertTrue(instance.getUserManager().loggedIn());
    }

    @Test
    public void testNotLoggedIn() {
        BibliotecaApp instance = new BibliotecaApp();
        assertTrue(!instance.getUserManager().loggedIn());
    }
}
