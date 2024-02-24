package com.munsun.contacts.enums;

public enum ItemMainMenu {
    PRINT_CONTACTS("Контакты", "вывести все контакты"),
    ADD_CONTACTS("Новый контакт", "добавить новый контакт"),
    REMOVE_BY_EMAIL("Удалить контакт", "удалить контакт по его 'email'"),
    IMPORT_TO_FILE("Импорт", "импорт контактов в файл");

    private String shortDescription;
    private String description;

    ItemMainMenu(String shortDescrition, String description) {
        this.shortDescription = shortDescrition;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
