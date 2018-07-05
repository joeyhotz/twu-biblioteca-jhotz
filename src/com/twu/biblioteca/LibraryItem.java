package com.twu.biblioteca;

public class LibraryItem {
    public String name;
    public String year;
    public boolean checkedOut;

    public void checkOut() {
        this.checkedOut = true;
    }

    public void checkIn() {
        this.checkedOut = false;
    }
}
