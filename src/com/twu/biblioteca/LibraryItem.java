package com.twu.biblioteca;

public class LibraryItem {
    public String name;
    public String year;
    public boolean checkedOut;

    public void toggleCheckedOutStatus() {
        this.checkedOut = !this.checkedOut;
    }
}
