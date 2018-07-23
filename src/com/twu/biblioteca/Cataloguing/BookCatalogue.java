package com.twu.biblioteca.Cataloguing;

import com.twu.biblioteca.Items.Book;

import java.util.ArrayList;

public class BookCatalogue extends Catalogue {
    private ArrayList<Book> books = new ArrayList<>();

    public BookCatalogue() {
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

    public ArrayList<Book> getAll() {
        return books;
    }

    public ArrayList<Book> getAllAvailable() {
        ArrayList<Book> availableBooks = new ArrayList<>();
        for(Book book: books) { if (book.isAvailable()) availableBooks.add(book); }
        return availableBooks;
    }

    public void listAllAvailable() {
        String format = "%-100s %-30s %-20s\n";
        System.out.print(buildHeader(format) + buildContent(format));
    }

    private String buildHeader(String format) {
        return "Available Books\n----------------\n" + String.format(format, "BOOK NAME", "AUTHOR", "YEAR PUBLISHED") + "\n";
    }

    private String buildContent(String format) {
        String content = "";
        for (Book book: getAllAvailable()) {
            content += String.format(format, book.getName(), book.getAuthor(), book.getYear());
        }
        return content;
    }
}
