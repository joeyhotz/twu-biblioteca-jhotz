package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class bookTests {

    @Test
    public void testMenuDisplaysListOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book harryPotterBook = new Book(){{ name = "Harry Potter"; }};
        Book gameOfThronesBook = new Book(){{ name = "Game of Thrones"; }};
        listOfBooks.add(harryPotterBook);
        listOfBooks.add(gameOfThronesBook);

        String expectedOutput = BibliotecaApp.availableBooksAsString(listOfBooks);
        String actualOutput = getBibliotecaOutput.asString();
        assertTrue(actualOutput.contains(expectedOutput));
    }

    @Test
    public void testStringGenerationOfBooks() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        Book harryPotterBook = new Book(){{ name = "Harry Potter"; }};
        Book gameOfThronesBook = new Book(){{ name = "Game of Thrones"; }};
        listOfBooks.add(harryPotterBook);
        listOfBooks.add(gameOfThronesBook);

        String expectedOutput = harryPotterBook.name + ", " + gameOfThronesBook.name;
        String actualOutput = BibliotecaApp.availableBooksAsString(listOfBooks);
        assertEquals(expectedOutput,actualOutput);
    }
}
