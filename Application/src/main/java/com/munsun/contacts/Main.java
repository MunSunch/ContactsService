package com.munsun.contacts;

import com.munsun.contacts.impl.PresenterImpl;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new PresenterImpl();
        presenter.start();
    }
}