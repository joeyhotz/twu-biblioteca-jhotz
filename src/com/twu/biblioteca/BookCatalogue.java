package com.twu.biblioteca;

import java.util.ArrayList;

public class BookCatalogue {
    private ArrayList<Book> availableBooks = new ArrayList<>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    public BookCatalogue() {
        //for demo
        Book gotBook = new Book("A Game of Thrones", "George R. R. Martin", "01.08.1996");
        Book hitchhickersBook = new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adam", "12.10.1979");
        Book harryPotterBook = new Book("Harry Potter and The Philosophers Stone", "J.K. Rowling", "26.06.1997");
        availableBooks.add(gotBook);
        availableBooks.add(hitchhickersBook);
        checkedOutBooks.add(harryPotterBook);
    }

    public BookCatalogue(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public ArrayList<Book> returnAllBooks() {
        ArrayList<Book> allBooks = new ArrayList<>();
        if (availableBooks != null) allBooks.addAll(availableBooks);
        if (checkedOutBooks != null) allBooks.addAll(checkedOutBooks);
        return allBooks;
    }

    public ArrayList<Book> returnAllAvailableBooks() {
        return availableBooks;
    }

    public ArrayList<Book> returnAllCheckedOutBooks() {
        return checkedOutBooks;
    }

    public String generateFormattedStringAllAvailableBooks() {
        String format = "%-" + getMaxNameLengthForPrintFormatting() + "s %-30s %-20s\n";
        String output = "Available Books\n----------------\n" + String.format(format, "BOOK NAME", "AUTHOR", "YEAR PUBLISHED") + "\n";

        for (Book book: returnAllAvailableBooks()) {
            output = output.concat(String.format(format, book.name, book.author, book.yearPublished));
        }
        return output;
    }

    public String handleCheckOutBook(String bookTitle) {
        Book book = findBookByBookTitle(bookTitle);
        if (bookIsAvailable(book)) {
            checkOutBook(book);
            return("Thank you! Enjoy the book.");
        } else {
            return("That book is not available.");
        }
    }

    private void checkOutBook(Book book) {
        this.availableBooks.remove(book);
        this.checkedOutBooks.add(book);
    }

    public String handleCheckInBook(String bookTitle) {
        Book book = findBookByBookTitle(bookTitle);
        if (bookIsCheckedOut(book)) {
            checkInBook(book);
            return("Thank you for returning the book.");
        } else {
            return("That is not a valid book to return.");
        }
    }

    private void checkInBook(Book book) {
        this.checkedOutBooks.remove(book);
        this.availableBooks.add(book);
    }

    public Book findBookByBookTitle(String bookTitle) {
        for (Book book: returnAllBooks()) {
            if (book.name.equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public boolean bookIsAvailable(Book bookToCheck) {
        if (bookToCheck == null) return false;
        for (Book book: returnAllAvailableBooks()) {
            if (book.name.equals(bookToCheck.name)) {
                return true;
            }
        }
        return false;
    }

    public boolean bookIsCheckedOut(Book bookToCheck) {
        if (bookToCheck == null) return false;
        for (Book book: returnAllCheckedOutBooks()) {
            if (book.name.equals(bookToCheck.name)) {
                return true;
            }
        }
        return false;
    }

    public int getMaxNameLengthForPrintFormatting() {
        int max = 0;
        for (Book book: returnAllAvailableBooks()) {
            if (book.name.length() > max) max = book.name.length();
        }
        return max + 10;
    }

}
