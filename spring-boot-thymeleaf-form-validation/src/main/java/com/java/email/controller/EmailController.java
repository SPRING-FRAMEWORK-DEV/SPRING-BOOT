package com.java.email.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

	@Autowired
	BirthDayWisher wisher;

	@GetMapping("/html-email")
	@ResponseBody
	String home() {
		try {
			sendBirthDayEmail();
			System.out.println("sent");
			return "Email Sent!";
		} catch (Exception ex) {
			System.out.println("error in mail sent");
			System.out.println(ex);
			;
			return "Error in sending email: " + ex;
		}
	}

	private void sendBirthDayEmail() throws Exception {
		String image = "http://www.happybirthdaycake2015.com/wp-content/uploads/2017/03/Happy-Birthday-Images-Download-6-min-1024x576.jpg";
		String message = "I hope you have a wonderful day and that the year ahead is filled with much love, many wonderful surprises and gives you lasting memories that you will cherish in all the days ahead."
				+ "Happy Birthday";
		wisher.wish(new String[] { "kumarsethi.rajesh@gmail.com", "rkpatra201@gmail.com" }, "Rajesh Kumar Sethi", message,
				image);
	}
}
