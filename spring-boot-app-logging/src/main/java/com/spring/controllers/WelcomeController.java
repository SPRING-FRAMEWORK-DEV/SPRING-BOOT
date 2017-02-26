package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public @ResponseBody String getIndex() {
		return "welcome to spring-boot";
	}

	@RequestMapping("/about-us")
	public String getAboutUs() {
		return "we are programmers and learning spring-boot now";
	}
}
