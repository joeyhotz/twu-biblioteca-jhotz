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
        ArrayList<Book> allBooks = availableBooks;
        allBooks.addAll(checkedOutBooks);
        return allBooks;
    }

    public ArrayList<Book> returnAllAvailableBooks() {
        return availableBooks;
    }

    public String generateFormattedStringAllAvailableBooks() {
        String format = "%-" + getMaxNameLengthForPrintFormatting() + "s %-30s %-20s\n";
        String output = String.format(format, "BOOK NAME", "AUTHOR", "YEAR PUBLISHED") + "\n";

        for (Book book: returnAllAvailableBooks()) {
            output = output.concat(String.format(format, book.name, book.author, book.yearPublished));
        }
        return output;
    }

    public ArrayList<Book> returnAllCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void checkOutBook(Book book) {
        try {
            this.availableBooks.remove(book);
            this.checkedOutBooks.add(book);
        } catch (Exception ex) {
            System.out.println("That book is not available.");
        } finally {
            System.out.println("Thank you! Enjoy the book.");
        }
    }

    public void checkInBook(Book book) {
        try {
            this.checkedOutBooks.remove(book);
            this.availableBooks.add(book);
        } catch (Exception ex) {
            System.out.println("That is not a valid book to return");
        } finally {
            System.out.println("Thank you for returning the book.");
        }
    }

    public int getMaxNameLengthForPrintFormatting() {
        int max = 0;
        for (Book book: returnAllAvailableBooks()) {
            if (book.name.length() > max) max = book.name.length();
        }
        return max + 10;
    }
}
