package com.twu.biblioteca;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class menuTests {

    @Test
    public void testMenuStartsFrom1AndAscends() {
        for (int i=1; i<=Menu.menuOptions.size();i++) {
            if (Menu.menuOptions.get(i - 1).getInt() != i) {
                fail("Menu Options aren't in a range starting from 1");
            }
        }
    }

    @Test
    public void testMenuOptionsContainListCheckoutReturn() {
        for (MenuOption menuOption: Menu.menuOptions) {
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
        String actualOutput = Menu.generateMenuStringToDisplay();
        assertEquals(expectedOutput, actualOutput);
    }
}
