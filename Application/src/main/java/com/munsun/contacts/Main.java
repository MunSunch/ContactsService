package com.munsun.contacts;

import com.munsun.contacts.configurations.PresenterContextConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(PresenterContextConfiguration.class);
        context.getBean(Presenter.class).start();
    }
}