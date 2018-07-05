package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
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
    public void testMenuStringGeneration() {
        String expectedOutput = "1: List Books\n" +
                "2: Checkout Book\n" +
                "3: Return Book\n" +
                "4: Quit\n" +
                "5: My Account\n";
        String actualOutput = BibliotecaApp.generateMenuStringToDisplay();
        assertEquals(expectedOutput, actualOutput);
    }
}
