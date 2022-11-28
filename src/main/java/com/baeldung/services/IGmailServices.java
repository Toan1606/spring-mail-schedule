package com.baeldung.services;


public interface IGmailServices {

    public void sendSimpleMessage(String fromEmail, String toEmail,  String subject, String text);

}
