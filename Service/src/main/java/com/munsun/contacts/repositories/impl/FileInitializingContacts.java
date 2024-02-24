package com.munsun.contacts.repositories.impl;

import com.munsun.contacts.mapping.ContactMapper;
import com.munsun.contacts.model.Contact;
import com.munsun.contacts.repositories.InitializingContacts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("init")
@RequiredArgsConstructor
public class FileInitializingContacts implements InitializingContacts {
    private final ContactMapper contactMapper;
    @Value("${contacts.file.input.path}")
    private String pathToInputFile;

    @Override
    public List<Contact> init() {
        List<Contact> contacts = new ArrayList<>();
        try(var stream = getClass().getClassLoader().getResourceAsStream(pathToInputFile)) {
            var text = new String(stream.readAllBytes()).split("\n");
            for(String strContact: text) {
                Contact contact = contactMapper.toContact(strContact);
                contacts.add(contact);
            }
            return contacts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}










