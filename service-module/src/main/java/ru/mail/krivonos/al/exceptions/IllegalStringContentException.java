package ru.mail.krivonos.al.exceptions;

public class IllegalStringContentException extends RuntimeException {

    public IllegalStringContentException(String s) {
        super(s);
    }
}
