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
                "4: List Movies\n" +
                "5: Checkout Movie\n" +
                "6: Return Movie\n" +
                "7: Login\n" +
                "8: Quit\n\n";
        BibliotecaApp instance = new BibliotecaApp();
        instance.logout();
        String actualOutput = instance.generateMenuStringToDisplay();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMenuStringGenerationLoggedInAccount() {
        String expectedOutput = "1: List Books\n" +
                "2: Checkout Book\n" +
                "3: Return Book\n" +
                "4: List Movies\n" +
                "5: Checkout Movie\n" +
                "6: Return Movie\n" +
                "7: My Account\n" +
                "8: Quit\n\n";
        BibliotecaApp instance = new BibliotecaApp();
        instance.handleLogin("123", "test");
        String actualOutput = instance.generateMenuStringToDisplay();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testLoggedIn() {
        BibliotecaApp instance = new BibliotecaApp();
        instance.handleLogin("123", "test");
        assertTrue(instance.loggedIn());
    }

    @Test
    public void testNotLoggedIn() {
        BibliotecaApp instance = new BibliotecaApp();
        assertTrue(!instance.loggedIn());
    }
}
