package com.baeldung.services.impl;

import com.baeldung.services.IGmailServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GmailServices implements IGmailServices {

    private final JavaMailSender mailSender;


    public GmailServices(@Autowired JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendSimpleMessage(@Value("${spring.mail.username}") String fromEmail, String toEmail,  String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        log.info("from email : " + fromEmail);
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
