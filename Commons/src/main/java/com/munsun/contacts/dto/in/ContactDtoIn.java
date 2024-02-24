package com.munsun.contacts.dto.in;

public record ContactDtoIn(
        String name,
        String surname,
        String patronymic,
        String phoneNumber,
        String email
) {}