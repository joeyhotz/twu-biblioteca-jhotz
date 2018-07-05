package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryItemTests {
    @Test
    public void testLibraryItemToggleCheckOut() {
        LibraryItem item = new LibraryItem();
        boolean originalValue = item.checkedOut;
        item.toggleCheckedOutStatus();
        assertTrue(originalValue != item.checkedOut);
    }
}