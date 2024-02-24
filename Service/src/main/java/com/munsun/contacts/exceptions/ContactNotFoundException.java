package com.munsun.contacts.exceptions;

public class ContactNotFoundException extends Exception {
    private static final String DEFAULT_MESSAGE = "Контакта не существует";
    public ContactNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ContactNotFoundException(String message) {
        super(message);
    }
}
