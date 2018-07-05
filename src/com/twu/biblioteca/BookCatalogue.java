package com.twu.biblioteca;

import java.util.ArrayList;

public class BookCatalogue {
    private ArrayList<Book> books = new ArrayList<>();

    public BookCatalogue() {
        //for demo
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996", true);
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979", true);
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997", false);
        books.add(gotBook);
        books.add(hitchhickersBook);
        books.add(harryPotterBook);
    }

    public BookCatalogue(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> returnAllBooks() {
        return books;
    }

    public ArrayList<Book> returnAllAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for(Book book: books) {
            if (!book.checkedOut) availableBooks.add(book);
        }
        return availableBooks;
    }

    public ArrayList<Book> returnAllCheckedOutBooks() {
        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        for(Book book: books) {
            if (book.checkedOut) checkedOutBooks.add(book);
        }
        return checkedOutBooks;
    }

    public String generateFormattedStringAllAvailableBooks() {
        String format = "%-" + getBooksMaxNameLengthForPrintFormatting() + "s %-30s %-20s\n";
        String output = "Available Books\n----------------\n" + String.format(format, "BOOK NAME", "AUTHOR", "YEAR PUBLISHED") + "\n";

        for (Book book: returnAllAvailableBooks()) {
            output = output.concat(String.format(format, book.name, book.author, book.year));
        }
        return output;
    }

    public String handleCheckOut(String bookTitle) {
        Book book = findBookByBookTitle(bookTitle);
        if (book == null) return("That book is not available.");
        if (!book.checkedOut) {
            book.toggleCheckedOutStatus();
            return("Thank you! Enjoy the book.");
        } else {
            return("That book is not available.");
        }
    }

    public String handleCheckIn(String bookTitle) {
        Book book = findBookByBookTitle(bookTitle);
        if (book == null) return("That is not a valid book to return.");
        if (book.checkedOut) {
            book.toggleCheckedOutStatus();
            return("Thank you for returning the book.");
        } else {
            return("That is not a valid book to return.");
        }
    }

    public Book findBookByBookTitle(String bookTitle) {
        for (Book book: returnAllBooks()) {
            if (book.name.equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public int getBooksMaxNameLengthForPrintFormatting() {
        int max = 0;
        for (Book book: returnAllAvailableBooks()) {
            if (book.name.length() > max) max = book.name.length();
        }
        return max + 10;
    }

}