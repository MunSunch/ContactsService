package com.munsun.contacts;

import com.munsun.contacts.configurations.PresenterContextConfiguration;
import com.munsun.contacts.services.Presenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {
    public static void main(String[] args) {
        String profile;
        if(args.length == 0) {
            profile = "default";
        } else {
            profile = args[0];
        }

        var context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profile);
        context.register(PresenterContextConfiguration.class);
        context.refresh();

        context.getBean(Presenter.class).start();
    }
}