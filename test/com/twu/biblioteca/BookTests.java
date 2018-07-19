package com.twu.biblioteca;

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

        ArrayList<Book> actualAllBooks = bookCatalogue.returnAllBooks();
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

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.returnAllAvailableBooks();
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
        String outputString = bookCatalogue.handleCheckOut(gotBook.name);

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.returnAllAvailableBooks();
        ArrayList<Book> expectedAllAvailableBooks = new ArrayList<Book>();
        expectedAllAvailableBooks.add(hitchhickersBook);

        ArrayList<Book> actualCheckedOutBooks = bookCatalogue.returnAllCheckedOutBooks();
        ArrayList<Book> expectedCheckedOutBooks = new ArrayList<Book>();
        expectedCheckedOutBooks.add(gotBook);
        expectedCheckedOutBooks.add(harryPotterBook);

        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
        assertEquals(expectedCheckedOutBooks, actualCheckedOutBooks);
        assertEquals("Thank you! Enjoy the book.", outputString);
    }

    @Test
    public void testCantCheckoutInvalidBook() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);

        BookCatalogue bookCatalogue = new BookCatalogue(books);
        String outputString = bookCatalogue.handleCheckOut(gotBook.name + "makesitinvalid");
        assertEquals("That book is not available.", outputString);
    }

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
        String outputString = bookCatalogue.handleCheckIn(harryPotterBook.name);

        ArrayList<Book> actualAllAvailableBooks = bookCatalogue.returnAllAvailableBooks();
        ArrayList<Book> expectedAllAvailableBooks = new ArrayList<Book>();
        expectedAllAvailableBooks.add(hitchhickersBook);
        expectedAllAvailableBooks.add(gotBook);
        expectedAllAvailableBooks.add(harryPotterBook);

        ArrayList<Book> actualCheckedOutBooks = bookCatalogue.returnAllCheckedOutBooks();
        ArrayList<Book> expectedCheckedOutBooks = new ArrayList<Book>();

        assertEquals(expectedAllAvailableBooks, actualAllAvailableBooks);
        assertEquals(expectedCheckedOutBooks, actualCheckedOutBooks);
        assertEquals("Thank you for returning the book.", outputString);
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
        String outputString = bookCatalogue.handleCheckIn(gotBook.name + "makesitinvalid");
        assertEquals("That is not a valid book to return.", outputString);
    }

    @Test
    public void testGeneratedStringAllAvailableBooks() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);

        ArrayList<Book> books = new ArrayList<>();
        books.add(hitchhickersBook);
        books.add(gotBook);
        BookCatalogue bookCatalogue = new BookCatalogue(books);

        String actualOutputString = bookCatalogue.generateFormattedStringAllAvailableBooks();
        String format = "%-" + bookCatalogue.getBooksMaxNameLengthForPrintFormatting() + "s %-30s %-20s\n";
        String expectedOutputString = "Available Books\n----------------\n" + String.format(format, "BOOK NAME", "AUTHOR", "YEAR PUBLISHED") + "\n";

        for(Book book: books) {
            expectedOutputString = expectedOutputString.concat(String.format(format, book.name, book.author, book.year));
        }

        assertEquals(expectedOutputString, actualOutputString);
    }

    @Test
    public void testMaxNameLengthFunction() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", false);

        ArrayList<Book> books = new ArrayList<>();
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);
        BookCatalogue bookCatalogue = new BookCatalogue(books);

        int actualMaxLength = bookCatalogue.getBooksMaxNameLengthForPrintFormatting();
        int expectedMaxLength = 49; //harry potter + 10
        assertEquals(expectedMaxLength, actualMaxLength);
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

        Book bookFound = bookCatalogue.findBookByBookTitle("Harry Potter and The Philosophers Stone");
        assertEquals(harryPotterBook, bookFound);
    }

    @Test
    public void testMenuGoodbye() {
        assertEquals("Goodbye!", BibliotecaApp.handleMenuInputAndReturnResponse("8"));
    }

    @Test
    public void testMenuInvalidInput() {
        assertEquals("Select a valid option! Try again:", BibliotecaApp.handleMenuInputAndReturnResponse("invalidoption"));
    }

    @Test
    public void testMenuListBooks() {
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", false);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", false);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", true);

        ArrayList<Book> books = new ArrayList<>();
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);
        BookCatalogue bookCatalogue = new BookCatalogue(books);

        BibliotecaApp app = new BibliotecaApp();
        app.bookCatalogue = bookCatalogue;
        assertEquals(bookCatalogue.generateFormattedStringAllAvailableBooks(), BibliotecaApp.handleMenuInputAndReturnResponse("1"));
    }
}
