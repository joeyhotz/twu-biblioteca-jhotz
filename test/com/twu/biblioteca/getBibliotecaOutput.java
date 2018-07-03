package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class getBibliotecaOutput {

    public static String asString() {
        String actualOutput = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PrintStream capture = new PrintStream(os);
            System.setOut(capture);
            BibliotecaApp.main(new String[]{});
            capture.flush();
            actualOutput = os.toString();
        } catch (Exception ex){
            System.err.println("Test unable to get output from main");
        }
        return actualOutput;
    }
}
