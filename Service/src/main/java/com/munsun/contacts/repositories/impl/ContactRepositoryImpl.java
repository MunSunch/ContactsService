package com.munsun.contacts.repositories.impl;

import com.munsun.contacts.exceptions.DatabaseConstrantException;
import com.munsun.contacts.model.Contact;
import com.munsun.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
    @Value("${contacts.file.path}")
    private String pathToFile;

    List<Contact> contacts = new ArrayList<>();
    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    @Override
    public Contact save(Contact newContact) throws DatabaseConstrantException {
        var contact = findContactByPhoneNumber(newContact.phoneNumber());
        if(contact.isPresent()) {
            throw new DatabaseConstrantException();
        }
        contacts.add(newContact);
        return newContact;
    }

    private Optional<Contact> findContactByPhoneNumber(String number) {
        return contacts.stream()
                .filter(x -> x.phoneNumber().equals(number))
                .findFirst();
    }

    @Override
    public Contact removeByEmail(String email) throws DatabaseConstrantException {
        var index = findContactByEmail(email);
        if(index == -1) {
            throw new DatabaseConstrantException();
        }
        return contacts.remove(index);
    }

    private int findContactByEmail(String email) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            var contact = contacts.get(i);
            if(contact.email().equals(email)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void saveToFile(List<String> contacts) {
        String absolutePathToFile = new File(pathToFile).getAbsolutePath();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(absolutePathToFile))) {
            for(var contact: contacts) {
                writer.write(contact);
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
