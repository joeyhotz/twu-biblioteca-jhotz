package com.twu.biblioteca.Cataloguing;

import com.twu.biblioteca.Items.LibraryItem;

abstract class Catalogue implements CatalogueInterface {
    public LibraryItem findByTitle(String title) {
        for (LibraryItem item: getAll()) {
            if (item.getName().equals(title)) { return item; }
        }
        return null;
    }

    public void checkOut(String title) {
        LibraryItem item = findByTitle(title);
        if (item == null) {
            System.out.print("\nThat is not available");
            return;
        } else if (item.isAvailable()) {
            item.toggleCheckedOutStatus();
            System.out.printf("\nThank you! Enjoy the %s.", item.getClass().getSimpleName().toLowerCase());
        } else {
            System.out.printf("\nThat %s is not available", item.getClass().getSimpleName().toLowerCase());
        }
    }

    public void checkIn(String title) {
        LibraryItem item = findByTitle(title);
        if (item == null) {
            System.out.printf("\nThat is not valid to return.");
            return;
        } else if (!item.isAvailable()) {
            item.toggleCheckedOutStatus();
            System.out.printf("\nThank you for returning the %s.", item.getClass().getSimpleName().toLowerCase());
        } else {
            System.out.printf("\nThat is not a valid %s to return.", item.getClass().getSimpleName().toLowerCase());
        }
    }
}
