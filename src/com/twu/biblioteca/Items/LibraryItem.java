package com.twu.biblioteca.Items;

import com.twu.biblioteca.UserAccount;

public abstract class LibraryItem {
    private String name;
    private String year;
    private UserAccount user;
    private boolean checkedOut;

    public LibraryItem(String name, String year, boolean checkedOut) {
        this.name = name;
        this.year = year;
        this.checkedOut = checkedOut;
    }

    public String getName() { return this.name; }
    public String getYear() { return this.year; }
    public void toggleCheckedOutStatus() {
        this.checkedOut = !this.checkedOut;
        //this.user = user;  For later addition to add user functionality
    }

    public boolean isAvailable() { return !this.checkedOut; }
}
