package com.example.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceImpl implements EmailService{
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public void sendMail(Email email) throws MessagingException {
		boolean isHtml = true;
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(email.getTo().toArray(new String[email.getTo().size()]));
		helper.setReplyTo(email.getFrom());
		helper.setFrom(email.getFrom());
		helper.setSubject(email.getSubject());
		helper.setText(email.getMessage(), isHtml);
		if (email.getCc().size() > 0) {
			helper.setCc(email.getCc().toArray(new String[email.getCc().size()]));
		}
		mailSender.send(message);
	}
	
	
	
}

