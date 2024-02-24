package com.munsun.contacts.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.munsun.contacts")
@Import(value = {ServiceContextConfiguration.class, })
public class PresenterContextConfiguration {
}
