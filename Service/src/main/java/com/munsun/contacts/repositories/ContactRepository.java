package com.munsun.contacts.repositories;

import com.munsun.contacts.exceptions.DatabaseConstrantException;
import com.munsun.contacts.model.Contact;

import java.util.List;

public interface ContactRepository {
    List<Contact> getAllContacts();

    Contact save(Contact newContact) throws DatabaseConstrantException;

    Contact removeByEmail(String email) throws DatabaseConstrantException;

    void saveToFile(List<String> contacts);
}
