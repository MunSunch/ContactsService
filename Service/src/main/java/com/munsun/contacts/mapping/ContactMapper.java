package com.munsun.contacts.mapping;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.model.Contact;

import java.util.List;

public interface ContactMapper {
    List<ContactDtoOut> toContactDtoOut(List<Contact> contacts);
    ContactDtoOut toContactDtoOut(Contact contact);

    Contact toContact(ContactDtoIn contactDtoIn);

    List<String> toStringContacts(List<ContactDtoOut> contacts);

    Contact toContact(String strContact);
}
