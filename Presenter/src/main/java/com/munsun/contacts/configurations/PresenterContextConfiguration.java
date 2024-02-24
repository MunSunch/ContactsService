package com.munsun.contacts.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.munsun.contacts")
@Import(value = {ServiceContextDefaultConfiguration.class})
public class PresenterContextConfiguration {
}