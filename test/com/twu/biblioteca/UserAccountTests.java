package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountTests {
    @Test
    public void testLoginWorks() {
        assertTrue(UserAccount.loginValid("123", "test") != null);
    }

    @Test
    public void testLoginDetectsInvalidAccount() {
        assertTrue(UserAccount.loginValid("invalid", "invalid") == null);
    }

    @Test
    public void testHandleLogin() {
        assertTrue(BibliotecaApp.handleLogin("123", "test"));
    }

    @Test
    public void testHandleInvalidLogin() {
        assertTrue(!BibliotecaApp.handleLogin("invalid", "invalid"));
    }

    @Test
    public void testBuildingCustomerInformationString() {
        UserAccount user = new UserAccount("123", "test", "George", "george@test.com", "0423523999");
        String expectedOutput = String.format("YOUR ACCOUNT DETAILS\n-------------\nName: %s\nEmail: %s\nPhone: %s", user.name, user.emailAddress, user.phoneNumber);
        assertEquals(expectedOutput, user.buildCustomerInformationString());
    }
}