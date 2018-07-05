package com.twu.biblioteca;

public class UserAccount {
    public String libraryNumber;
    public String password;

    public UserAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public static UserAccount loginValid(String libraryNumber, String password) {
        if (libraryNumber.equals("123") && password.equals("test")) {
            return new UserAccount("123", "test");
        }
        return null;
    }
}