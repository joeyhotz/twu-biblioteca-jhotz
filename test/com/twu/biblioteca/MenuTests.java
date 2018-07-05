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
            BibliotecaApp.printToConsole(stringToTest);
            capture.flush();
            actualOutput = os.toString();
        } catch (Exception ex) {
            System.err.println("Test unable to get output from main");
        }

        assertEquals(stringToTest, actualOutput);
    }

    @Test
    public void testMenuStringGenerationNoAccount() {
        String expectedOutput = "1: List Books\n" +
                "2: Checkout Book\n" +
                "3: Return Book\n" +
                "4: Login\n" +
                "5: Quit\n\n";
        BibliotecaApp instance = new BibliotecaApp();
        instance.loggedInAccount = null;
        String actualOutput = instance.generateMenuStringToDisplay();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMenuStringGenerationLoggedInAccount() {
        String expectedOutput = "1: List Books\n" +
                "2: Checkout Book\n" +
                "3: Return Book\n" +
                "4: My Account\n" +
                "5: Quit\n\n";
        BibliotecaApp instance = new BibliotecaApp();
        instance.loggedInAccount = new UserAccount("123", "test", "George", "george@george.com", "03123");
        String actualOutput = instance.generateMenuStringToDisplay();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testLoggedIn() {
        BibliotecaApp instance = new BibliotecaApp();
        instance.loggedInAccount = new UserAccount("123", "test", "George", "george@george.com", "03123");
        assertTrue(instance.loggedIn());
    }

    @Test
    public void testNotLoggedIn() {
        BibliotecaApp instance = new BibliotecaApp();
        instance.loggedInAccount = null;
        assertTrue(!instance.loggedIn());
    }
}
