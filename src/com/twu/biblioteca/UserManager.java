package com.twu.biblioteca;

import java.util.Scanner;

public class UserManager {
    private UserAccount loggedInUser = null;
    Scanner sc = new Scanner(System.in);

    public UserManager() {

    }

    public void displayLogin() {
        if (loggedInUser == null) {
            System.out.println("\n\nPlease Login with your credentials:\n");
            System.out.print("Library Number (or 'x' to exit): ");
            String enteredLibraryNumber = String.format(sc.nextLine());
            if (enteredLibraryNumber.equals("x")) return;
            System.out.print("Password: ");
            String enteredPassword = String.format(sc.nextLine());
            String output = login(enteredLibraryNumber, enteredPassword) ? "\nSuccessful Login\n\n-----------------\n" : "\nUnsuccessful Login. Try again.";
            System.out.println(output);
        }
    }

    public boolean login(String libraryNumber, String password) {
        if (libraryNumber.equals("123") && PasswordHashing.hashPassword(password).equals(PasswordHashing.hashPassword("test"))) {
            loggedInUser = new UserAccount("123", "test", "George Simmer", "test@test.com", "0404123456");
            return true;
        }
        return false;
    }

    public UserAccount getLoggedInUser() { return loggedInUser; }

    public boolean loggedIn() { return loggedInUser != null; }

    public void logout() { loggedInUser = null; }

    public void logInTestUser() { loggedInUser = new UserAccount("123", "test", "George Simmer", "test@test.com", "0404123456"); }



}
