package com.munsun.contacts.configurations;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.munsun.contacts")
@PropertySource("classpath:application-service.properties")
public class ServiceContextDefaultConfiguration {
}
