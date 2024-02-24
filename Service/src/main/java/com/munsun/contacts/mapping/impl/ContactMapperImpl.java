package com.munsun.contacts.mapping.impl;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.mapping.ContactMapper;
import com.munsun.contacts.model.Contact;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactMapperImpl implements ContactMapper {
    @Override
    public List<ContactDtoOut> toContactDtoOut(List<Contact> contacts) {
        return contacts.stream()
                .map(this::toContactDtoOut)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDtoOut toContactDtoOut(Contact contact) {
        String separator = " ";
        String fullName = contact.name() + separator
                + contact.surname() + separator
                + contact.patronymic();
        return new ContactDtoOut(fullName, contact.phoneNumber(), contact.email());
    }

    @Override
    public Contact toContact(ContactDtoIn contactDtoIn) {
        return new Contact(contactDtoIn.name(),
                contactDtoIn.surname(),
                contactDtoIn.patronymic(),
                contactDtoIn.phoneNumber(),
                contactDtoIn.email());
    }
}
