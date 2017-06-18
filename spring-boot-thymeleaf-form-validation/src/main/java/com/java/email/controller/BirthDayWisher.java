package com.java.email.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class BirthDayWisher {

	@Autowired
	private JavaMailSender sender;

	private String content;
	public static final String BIRTHDAY_TEMPLATE = "birthday-template.txt";

	public BirthDayWisher() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		this.content = loadTemplate();
	}

	private String loadTemplate() throws IOException {
		StringBuffer sb = new StringBuffer();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(getClass().getClassLoader().getResourceAsStream(BIRTHDAY_TEMPLATE)))) {
			for (String line; (line = br.readLine()) != null;) {
				// process the line.
				sb.append(line);
			}
			// line is not visible here.
		}

		return sb.toString();
	}

	public boolean wish(String[] email, String name, String message, String image) throws MessagingException {

		String mailBody = new Personalise(content, name, message, image).makeBirthDayTemplate();

		MimeMessage mimeMessage = sender.createMimeMessage();

		// Enable the multipart flag!
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(email[0]);
		//helper.setTo(email);
		helper.setCc(email[1]);
		helper.setText(mailBody, true);
		helper.setSubject("Happy BirthDay " + name);

		// ClassPathResource file = new ClassPathResource("cat.jpg");
		// helper.addInline("id101", file);

		sender.send(mimeMessage);
		return true;
	}
}

class Personalise {
	private String name;
	private String message;
	private String image;
	private String content;

	public Personalise(String content, String name, String message, String image) {
		super();
		this.name = name;
		this.message = message;
		this.image = image;
		this.content = content;
	}

	public String makeBirthDayTemplate() {

		String s = new String(this.content);
		s = s.replaceAll("#name#", this.name).replaceAll("#message#", message).replaceAll("#image#", image);

		return s;

	}

}
