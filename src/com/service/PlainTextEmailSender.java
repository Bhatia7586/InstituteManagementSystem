package com.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PlainTextEmailSender {

	public void sendPlainTextEmail(String host, String port, String mailFrom, String password, String mailto,
			String mailcc, String subject, String message) throws AddressException, MessagingException {
		
		
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		
		Authenticator auth = new Authenticator() {
			
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, password);
			}
		};
		
		
		
		Session session = Session.getInstance(properties, auth);
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(mailFrom));
		InternetAddress[] toAddress = { new InternetAddress(mailto) };
		msg.setRecipients(Message.RecipientType.TO, toAddress);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		
		msg.setText(message);
		
		Transport.send(msg);
		
		
		
		
		
	}

}
