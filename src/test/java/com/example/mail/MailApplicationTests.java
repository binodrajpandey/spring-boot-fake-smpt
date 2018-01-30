package com.example.mail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {
	@Autowired
	EmailService emailService;
	 
	
	@Test
	public void contextLoads() throws MessagingException {
		String from = "pavan@localhost";
		String to = "solapure@localhost";
		String subject = "Java Mail with Spring Boot";
		 
		EmailTemplate template = new EmailTemplate("hello-world.html");
		 
		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", "Pavan");
		replacements.put("today", String.valueOf(new Date()));
		 
		String message = template.getTemplate(replacements);
		 
		Email email = new Email(from, to, subject, message);
		email.setHtml(true);
		emailService.sendMail(email);
	}

}
