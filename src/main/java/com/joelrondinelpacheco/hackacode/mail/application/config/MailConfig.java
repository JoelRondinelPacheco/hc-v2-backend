package com.joelrondinelpacheco.hackacode.mail.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Integer port;

        try {
            port = Integer.getInteger(env.getProperty("spring.mail.port"));
        } catch (NullPointerException ex) {
            // todo set ex
        } finally {
            port = 587;
        }

        mailSender.setHost(env.getProperty("spring.mail.host"));
        mailSender.setPort(port);
        mailSender.setUsername(env.getProperty("spring.mail.username"));
        mailSender.setPassword(env.getProperty("spring.mail.password"));
/*
        Properties props = new Properties();
        props.put("mail.smtp.auth", env.getProperty("spring.mail.properties.mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", env.getProperty("spring.mail.properties.mail.smtp.starttls.enable"));
        mailSender.setJavaMailProperties(props);*/

        return mailSender;
    }
}

