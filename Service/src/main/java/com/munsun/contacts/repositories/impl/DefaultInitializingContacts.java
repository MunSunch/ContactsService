package com.munsun.contacts.repositories.impl;

import com.munsun.contacts.model.Contact;
import com.munsun.contacts.repositories.InitializingContacts;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("default")
public class DefaultInitializingContacts implements InitializingContacts {
    @Override
    public List<Contact> init() {
        return new ArrayList<>();
    }
}
