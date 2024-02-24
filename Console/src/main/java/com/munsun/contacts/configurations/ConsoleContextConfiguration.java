package com.munsun.contacts.configurations;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.munsun.contacts")
@PropertySource("classpath:application-console.properties")
public class ConsoleContextConfiguration {
}
