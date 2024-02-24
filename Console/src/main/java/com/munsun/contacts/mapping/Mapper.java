package com.munsun.contacts.mapping;

import com.munsun.contacts.dto.in.ContactDtoIn;
import com.munsun.contacts.dto.out.ContactDtoOut;
import com.munsun.contacts.enums.ItemMainMenu;

import java.util.List;
import java.util.Map;

public interface Mapper {
    ItemMainMenu toItemMainMenu(Integer indexItem);

    List<String> toContactsString(List<ContactDtoOut> contacts);
    String toContactsString(ContactDtoOut contact);

    ContactDtoIn toContactDtoIn(Map<String,String> form);
}
