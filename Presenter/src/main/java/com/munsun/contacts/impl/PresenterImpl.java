package com.munsun.contacts.impl;

import com.munsun.contacts.Presenter;
import com.munsun.contacts.exceptions.ContactNotFoundException;
import com.munsun.contacts.exceptions.DuplicateContactException;
import com.munsun.contacts.services.Service;
import com.munsun.contacts.services.View;
import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.enums.ItemMainMenu;
import com.munsun.contacts.services.impl.Console;
import com.munsun.contacts.services.impl.ContactService;

import java.util.List;

public class PresenterImpl implements Presenter {
    private Service service = new ContactService();
    private View view = new Console();

    @Override
    public void start() {
        try {
            ItemMainMenu selectItemMainMenu = view.showMainMenu();
            switch (selectItemMainMenu) {
                case PRINT_CONTACTS -> showAllContacts();
                case ADD_CONTACTS -> addContact();
                case REMOVE_BY_EMAIL -> removeContactByEmail();
                case IMPORT_TO_FILE -> importFile();
            }
        } catch (NumberFormatException|ArrayIndexOutOfBoundsException e) {
            view.showError("Введите номер пункта меню");
        }
        start();
    }

    private void showAllContacts() {
        List<ContactDtoOut> contacts = service.getContacts();
        view.showListContacts(contacts);
    }

    private void addContact() {
        ContactDtoIn contactDtoIn = view.showFormSaveContact();
        try {
            ContactDtoOut contactDtoOut = service.addContact(contactDtoIn);
            view.showListContacts(List.of(contactDtoOut));
        } catch (DuplicateContactException e) {
            view.showError(e.getMessage());
        }
    }

    private void removeContactByEmail() {
        String email = view.showRemoveContact();
        try {
            ContactDtoOut contactDtoOut = service.removeContactByEmail(email);
            view.showListContacts(List.of(contactDtoOut));
        } catch (ContactNotFoundException e) {
            view.showError(e.getMessage());
        }
    }

    private void importFile() {
        System.out.println("Не реализовано!");
    }
}
