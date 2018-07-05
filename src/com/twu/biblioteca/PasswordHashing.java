package com.twu.biblioteca;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing
{
    public static String hashPassword(String passwordToHash)
    {
        String encryptedString = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(passwordToHash.getBytes());
            encryptedString = new String(messageDigest.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encryptedString;
    }
}
