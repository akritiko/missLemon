/**
 * 
 */
package org.akritiko.misslemon.util;

/**
 * Mailman creates and sends e-mail messages using gmail smtp 
 * protocol.
 * 
 * @version 1.0.0, 05 Jan 2013
 * @author Apostolos Kritikos <akritiko@gmail.com>
 *
 * SOURCE CODE WAS ORIGINALLY FOUND ON:
 * http://www.javabeat.net/2007/10/sending-mail-from-java/
 * 
 */

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailman {

	private String from;
	private String to;
	private String subject;
	private String text;

	public Mailman(String from, String to, String subject, String text) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public void deliver() {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		Session mailSession = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, "1985akr1t1k0");
					}
				});
		
		Message simpleMessage = new MimeMessage(mailSession);

		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(from);
			toAddress = new InternetAddress(to);
		} catch (AddressException e) {
			e.printStackTrace();
		}

		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(subject);
			simpleMessage.setText(text);

			Transport.send(simpleMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}