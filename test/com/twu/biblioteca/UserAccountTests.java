package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountTests {
    @Test
    public void testLoginWorks() {
        BibliotecaApp instance = new BibliotecaApp();
        assertTrue(instance.getUserManager().login("123", "test"));
    }

    @Test
    public void testLoginDetectsInvalidAccount() {
        BibliotecaApp instance = new BibliotecaApp();
        assertTrue(!instance.getUserManager().login("invalid", "invalid"));
    }


    @Test
    public void testBuildingCustomerInformationString() {
        UserAccount user = new UserAccount("123", "test", "George", "george@test.com", "0423523999");
        String expectedOutput = String.format("YOUR ACCOUNT DETAILS\n-------------\nName: %s\nEmail: %s\nPhone: %s", user.name, user.emailAddress, user.phoneNumber);
        assertEquals(expectedOutput, user.buildCustomerInformationString());
    }
}