package com.twu.biblioteca;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class bookTests {

    @Test
    public void testReturnsAllBooks() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996");
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy ", "Douglas Adam", "12.10.1979");
        Book harryPotterBook = new Book("Harry Potter: The Philosophers Stone", "J.K. Rowling", "26.06.1997");

        ArrayList<Book> availableBooks = new ArrayList<>();
        availableBooks.add(gotBook);
        availableBooks.add(hitchhickersBook);

        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        checkedOutBooks.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(availableBooks, checkedOutBooks);

        ArrayList<Book> actualAllBooks = bookCatalogue.returnAllBooks();
        ArrayList<Book> expectedAllBooks = availableBooks;
        expectedAllBooks.addAll(checkedOutBooks);
        assertEquals(expectedAllBooks, actualAllBooks);
    }

    @Test
    public void testReturnsAllAvailableBooks() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996");
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy ", "Douglas Adam", "12.10.1979");
        Book harryPotterBook = new Book("Harry Potter: The Philosophers Stone", "J.K. Rowling", "26.06.1997");

        ArrayList<Book> availableBooks = new ArrayList<>();
        availableBooks.add(gotBook);
        availableBooks.add(hitchhickersBook);

        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        checkedOutBooks.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(availableBooks, checkedOutBooks);

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.returnAllAvailableBooks();
        ArrayList<Book> expectedAllAvailableBooks = availableBooks;
        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
    }

    @Test
    public void testCanCheckoutBookAndCatalogueReflectsThis() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996");
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy ", "Douglas Adam", "12.10.1979");
        Book harryPotterBook = new Book("Harry Potter: The Philosophers Stone", "J.K. Rowling", "26.06.1997");

        ArrayList<Book> availableBooks = new ArrayList<>();
        availableBooks.add(gotBook);
        availableBooks.add(hitchhickersBook);
        availableBooks.add(harryPotterBook);

        ArrayList<Book> checkedOutBooks = new ArrayList<>();

        BookCatalogue bookCatalogue = new BookCatalogue(availableBooks, checkedOutBooks);
        bookCatalogue.checkOutBook(gotBook);

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.returnAllAvailableBooks();
        ArrayList<Book> expectedAllAvailableBooks = new ArrayList<Book>();
        expectedAllAvailableBooks.add(hitchhickersBook);
        expectedAllAvailableBooks.add(harryPotterBook);

        ArrayList<Book> actualCheckedOutBooks = bookCatalogue.returnAllCheckedOutBooks();
        ArrayList<Book> expectedCheckedOutBooks = new ArrayList<Book>();
        expectedCheckedOutBooks.add(gotBook);

        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
        assertEquals(expectedCheckedOutBooks, actualCheckedOutBooks);
    }

    @Test
    public void testCanCheckinBookAndCatalogueReflectsThis() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996");
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy ", "Douglas Adam", "12.10.1979");
        Book harryPotterBook = new Book("Harry Potter: The Philosophers Stone", "J.K. Rowling", "26.06.1997");

        ArrayList<Book> availableBooks = new ArrayList<>();
        availableBooks.add(hitchhickersBook);
        availableBooks.add(harryPotterBook);

        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        checkedOutBooks.add(gotBook);

        BookCatalogue bookCatalogue = new BookCatalogue(availableBooks, checkedOutBooks);
        bookCatalogue.checkInBook(gotBook);

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.returnAllAvailableBooks();
        ArrayList<Book> expectedAllAvailableBooks = new ArrayList<Book>();
        expectedAllAvailableBooks.add(hitchhickersBook);
        expectedAllAvailableBooks.add(harryPotterBook);
        expectedAllAvailableBooks.add(gotBook);

        ArrayList<Book> actualCheckedOutBooks = bookCatalogue.returnAllCheckedOutBooks();
        ArrayList<Book> expectedCheckedOutBooks = new ArrayList<Book>();

        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
        assertEquals(expectedCheckedOutBooks, actualCheckedOutBooks);
    }

}
