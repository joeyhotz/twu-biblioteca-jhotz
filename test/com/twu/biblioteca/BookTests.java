package com.twu.biblioteca;

import com.twu.biblioteca.Cataloguing.BookCatalogue;
import com.twu.biblioteca.Items.Book;
import com.twu.biblioteca.Items.LibraryItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class BookTests {
    @Test
    public void testReturnsAllBooks() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(books);

        ArrayList<Book> actualAllBooks = bookCatalogue.getAll();
        ArrayList<Book> expectedAllBooks = books;
        assertEquals(expectedAllBooks, actualAllBooks);
    }

    @Test
    public void testReturnsAllAvailableBooks() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(books);

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.getAllAvailable();
        ArrayList<Book> expectedAllAvailableBooks = new ArrayList<>();
        expectedAllAvailableBooks.add(gotBook);
        expectedAllAvailableBooks.add(hitchhickersBook);

        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
    }

    @Test
    public void testCanCheckoutBookAndCatalogueReflectsThis() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(books);
        bookCatalogue.checkOut(gotBook.getName());

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.getAllAvailable();
        ArrayList<Book> expectedAllAvailableBooks = new ArrayList<Book>();
        expectedAllAvailableBooks.add(hitchhickersBook);

        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
    }

   /* @Test
    public void testCantCheckoutInvalidBook() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(books);
        bookCatalogue.checkOut(gotBook.getName() + "makesitinvalid");
        assertEquals("That book is not available.", outputString);
    }*/

    @Test
    public void testCanCheckinBookAndCatalogueReflectsThis() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(hitchhickersBook);
        books.add(gotBook);
        books.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(books);
        bookCatalogue.checkIn(harryPotterBook.getName());

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.getAllAvailable();
        ArrayList<Book> expectedAllAvailableBooks = new ArrayList<Book>();
        expectedAllAvailableBooks.add(hitchhickersBook);
        expectedAllAvailableBooks.add(gotBook);
        expectedAllAvailableBooks.add(harryPotterBook);

//        ArrayList<Book> actualCheckedOutBooks = bookCatalogue.returnAllCheckedOutBooks();
//        ArrayList<Book> expectedCheckedOutBooks = new ArrayList<Book>();

        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
//        assertEquals(expectedCheckedOutBooks, actualCheckedOutBooks);
    }

    @Test
    public void testCantCheckInInvalidBook() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(hitchhickersBook);
        books.add(harryPotterBook);
        books.add(gotBook);

        BookCatalogue bookCatalogue = new BookCatalogue(books);
        bookCatalogue.checkIn(gotBook.getName() + "makesitinvalid");
//        assertEquals("That is not a valid book to return.", outputString);
    }



    @Test
    public void testFindBookByBookTitle() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(hitchhickersBook);
        books.add(harryPotterBook);
        BookCatalogue bookCatalogue = new BookCatalogue(books);

        LibraryItem bookFound = bookCatalogue.findByTitle("Harry Potter and The Philosophers Stone");
        assertEquals(harryPotterBook, bookFound);
    }

}
