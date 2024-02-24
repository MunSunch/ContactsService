package com.munsun.contacts.services.impl.forms;

public enum SaveContactForm {
    NAME("имя"),
    SURNAME("фамилия"),
    PATRONYMIC("отчество"),

    PHONE_NUMBER("телефон"),
    EMAIL("email");

    private String description;

    SaveContactForm(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
