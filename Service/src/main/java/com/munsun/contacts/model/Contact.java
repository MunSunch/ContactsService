package com.munsun.contacts.model;

public record Contact(
        String name,
        String surname,
        String patronymic,
        String phoneNumber,
        String email
) {}