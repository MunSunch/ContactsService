package com.munsun.contacts.services.impl;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.exceptions.ContactNotFoundException;
import com.munsun.contacts.exceptions.DatabaseConstrantException;
import com.munsun.contacts.exceptions.DuplicateContactException;
import com.munsun.contacts.mapping.ContactMapper;
import com.munsun.contacts.model.Contact;
import com.munsun.contacts.repositories.ContactRepository;
import com.munsun.contacts.services.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ContactService implements Service {
    private final ContactRepository repository;
    private final ContactMapper contactMapper;

    @Override
    public List<ContactDtoOut> getContacts() {
        List<Contact> contacts = repository.getAllContacts();
        return contactMapper.toContactDtoOut(contacts);
    }

    @Override
    public ContactDtoOut addContact(ContactDtoIn contactDtoIn) throws DuplicateContactException {
        try {
            Contact newContact = contactMapper.toContact(contactDtoIn);
            return contactMapper.toContactDtoOut(repository.save(newContact));
        } catch (DatabaseConstrantException e) {
            throw new DuplicateContactException("Контакт с таким номером уже существует");
        }
    }

    @Override
    public ContactDtoOut removeContactByEmail(String email) throws ContactNotFoundException {
        try {
            return contactMapper.toContactDtoOut(repository.removeByEmail(email));
        } catch (DatabaseConstrantException e) {
            throw new ContactNotFoundException();
        }
    }

    @Override
    public void importContacts() {
        repository.saveToFile(contactMapper.toStringContacts(getContacts()));
    }
}
