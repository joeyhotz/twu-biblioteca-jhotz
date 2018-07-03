package com.twu.biblioteca;

class MenuOption {
    private int intValue;
    private String stringValue;

    public MenuOption(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public int getInt() {
        return this.intValue;
    }

    public String getString() {
        return this.stringValue;
    }
}