package com.twu.biblioteca;

import java.util.ArrayList;

public class BookCatalogue {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;

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

    public ArrayList<Book> returnAllCheckedOutBooks() {
        return checkedOutBooks;
    }

    public boolean checkOutBook(Book book) {
        try {
            this.availableBooks.remove(book);
            this.checkedOutBooks.add(book);
        } catch (Exception ex) {
            return false;
        } finally {
            return true;
        }
    }

    public boolean checkInBook(Book book) {
        try {
            this.checkedOutBooks.remove(book);
            this.availableBooks.add(book);
        } catch (Exception ex) {
            return false;
        } finally {
            return true;
        }
    }
}
