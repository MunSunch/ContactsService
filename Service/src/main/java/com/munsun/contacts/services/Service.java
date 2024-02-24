package com.munsun.contacts.services;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.exceptions.ContactNotFoundException;
import com.munsun.contacts.exceptions.DuplicateContactException;

import java.util.List;

public interface Service {
    List<ContactDtoOut> getContacts();

    ContactDtoOut addContact(ContactDtoIn contactDtoIn) throws DuplicateContactException;

    ContactDtoOut removeContactByEmail(String email) throws ContactNotFoundException;

    void importContacts();
}
