package com.twu.biblioteca;

public class UserAccount {
    public String libraryNumber;
    public String password;
    public String name;
    public String emailAddress;
    public String phoneNumber;

    public UserAccount(String libraryNumber, String password, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = PasswordHashing.hashPassword(password);
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public static UserAccount loginValid(String libraryNumber, String password) {
        //************add text file read here or something, just make it better
        if (libraryNumber.equals("123") && PasswordHashing.hashPassword(password).equals(PasswordHashing.hashPassword("test"))) {
            return new UserAccount("123", "test", "George Simmer", "test@test.com", "0404123456");
        }
        return null;
    }

    public String buildCustomerInformationString() {
        return String.format("YOUR ACCOUNT DETAILS\n-------------\nName: %s\nEmail: %s\nPhone: %s", this.name, this.emailAddress, this.phoneNumber);
    }
}