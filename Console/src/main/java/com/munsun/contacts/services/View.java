package com.munsun.contacts.services;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.enums.ItemMainMenu;

import java.util.List;

public interface View {
    ItemMainMenu showMainMenu();

    void showListContacts(List<ContactDtoOut> contacts);

    ContactDtoIn showFormSaveContact();

    String showRemoveContact();

    void showError(String message);
}
