package com.example.mail;

import javax.mail.MessagingException;

public interface EmailService {
void sendMail(Email email) throws MessagingException;
}
