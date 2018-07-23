package com.twu.biblioteca.Cataloguing;

import com.twu.biblioteca.Items.LibraryItem;

import java.util.ArrayList;

interface CatalogueInterface {
    ArrayList<? extends LibraryItem> getAll();
    ArrayList<? extends LibraryItem> getAllAvailable();
    void listAllAvailable();
}