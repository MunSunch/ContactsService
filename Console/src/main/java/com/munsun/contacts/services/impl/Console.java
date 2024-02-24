package com.munsun.contacts.services.impl;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.enums.ItemMainMenu;
import com.munsun.contacts.mapping.Mapper;
import com.munsun.contacts.mapping.impl.ConsoleMapper;
import com.munsun.contacts.services.View;
import com.munsun.contacts.services.impl.forms.SaveContactForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Console implements View {
    private static final String DEFAULT_PREFIX_INPUT = ">>>";
    private String fillHeaderSymbol = "=";
    private final Mapper consoleMapper;
    @Override
    public ItemMainMenu showMainMenu() {
        printHeader("Главное меню");
        Collection<String> items = Arrays.stream(ItemMainMenu.values())
                                .map(ItemMainMenu::getDescription)
                                .collect(Collectors.toList());
        printListItems(items);
        Integer indexItem = Integer.parseInt(input(DEFAULT_PREFIX_INPUT));
        return consoleMapper.toItemMainMenu(indexItem);
    }

    private void printHeader(String header) {
        int countRepeatFillHeaderSymbol = 14;
        String lineFillHeader = fillHeaderSymbol.repeat(countRepeatFillHeaderSymbol);
        System.out.println(lineFillHeader+header+lineFillHeader);
    }

    private String input(String prefixInput) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prefixInput);
        return scanner.next();
    }

    private void printListItems(Collection<String> items) {
        int index = 1;
        for (var item: items) {
            String temp = String.format("%d) %s", index, item);
            System.out.println(temp);
            index++;
        }
    }

    @Override
    public void showListContacts(List<ContactDtoOut> contacts) {
        printHeader(ItemMainMenu.PRINT_CONTACTS.getShortDescription());
        if(contacts.isEmpty()) {
            System.out.println("Пусто");
        }
        List<String> contactsString = consoleMapper.toContactsString(contacts);
        printListItems(contactsString);
    }

    @Override
    public ContactDtoIn showFormSaveContact() {
        printHeader(ItemMainMenu.ADD_CONTACTS.getShortDescription());
        Collection<String> items = Arrays.stream(SaveContactForm.values())
                .map(SaveContactForm::getDescription)
                .collect(Collectors.toList());
        Map<String,String> form = printForm(items);
        return consoleMapper.toContactDtoIn(form);
    }

    private Map<String,String> printForm(Collection<String> collection) {
        Map<String,String> form = new HashMap<>(collection.size());
        Scanner scanner = new Scanner(System.in);
        for (var item: collection) {
            System.out.print(item + ": ");
            form.put(item, scanner.next());
        }
        return form;
    }

    @Override
    public String showRemoveContact() {
        printHeader(ItemMainMenu.REMOVE_BY_EMAIL.getShortDescription());
        System.out.print("Email: ");
        return input("");
    }

    @Override
    public void showError(String message) {
        printHeader("Ошибка");
        System.out.println("Ошибка: "+message);
    }
}
