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
}