package com.munsun.contacts.mapping.impl;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.enums.ItemMainMenu;
import com.munsun.contacts.mapping.Mapper;
import com.munsun.contacts.services.impl.forms.SaveContactForm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleMapper implements Mapper {
    @Override
    public ItemMainMenu toItemMainMenu(Integer indexItem) {
        return ItemMainMenu.values()[indexItem - 1];
    }

    @Override
    public List<String> toContactsString(List<ContactDtoOut> contacts) {
        return contacts.stream()
                .map(this::toContactsString)
                .collect(Collectors.toList());
    }

    @Override
    public String toContactsString(ContactDtoOut contact) {
        return String.format("%s|%s|%s",
                contact.fullName(), contact.phoneNumber(), contact.email());
    }

    @Override
    public ContactDtoIn toContactDtoIn(Map<String, String> form) {
        return new ContactDtoIn(form.get(SaveContactForm.NAME.getDescription()),
                form.get(SaveContactForm.SURNAME.getDescription()),
                form.get(SaveContactForm.PATRONYMIC.getDescription()),
                form.get(SaveContactForm.PHONE_NUMBER.getDescription()),
                form.get(SaveContactForm.EMAIL.getDescription()));
    }
}
