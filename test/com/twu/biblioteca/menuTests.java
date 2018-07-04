package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class menuTests {

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
    public void testMenuStartsFrom1AndAscends() {
        for (int i=1; i<=MenuOptions.data.size();i++) {
            if (MenuOptions.data.get(i - 1).getInt() != i) {
                fail("Menu Options aren't in a range starting from 1");
            }
        }
    }

    @Test
    public void testMenuOptionsContainListCheckoutReturn() {
        for (MenuOption menuOption: MenuOptions.data) {
            if (menuOption.getString() == "List Books" || menuOption.getString() == "Checkout Book" || menuOption.getString() == "Return Book" || menuOption.getString() == "Quit") {
                //do nothing, this is good
            } else {
                fail("Unrecognised menu option");
            }
        }
    }

    @Test
    public void testMenuStringGeneration() {
        String expectedOutput = "1: List Books\n" +
                "2: Checkout Book\n" +
                "3: Return Book\n" +
                "4: Quit\n";
        String actualOutput = BibliotecaApp.generateMenuStringToDisplay();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMenuOptionGetInt() {
        MenuOption menuOption = new MenuOption(1, "List Books");
        int actualOutput = menuOption.getInt();
        assertEquals(1, actualOutput);
    }

    @Test
    public void testMenuOptionGetString() {
        MenuOption menuOption = new MenuOption(1, "List Books");
        String actualOutput = menuOption.getString();
        assertEquals("List Books", actualOutput);
    }

}
