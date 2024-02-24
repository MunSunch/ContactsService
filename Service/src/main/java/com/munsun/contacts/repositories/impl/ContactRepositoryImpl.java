package com.munsun.contacts.repositories.impl;

import com.munsun.contacts.exceptions.DatabaseConstrantException;
import com.munsun.contacts.model.Contact;
import com.munsun.contacts.repositories.ContactRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
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
}
