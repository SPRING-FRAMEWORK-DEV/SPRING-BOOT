package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.UserModel;

@Controller("userAuthController")
public class UserAuthController {

	

	@RequestMapping("/")
	private String getIndexPage() {
		System.out.println("**************************");
		return "index";
	}

	

	@RequestMapping(value = "user/dummy", method = RequestMethod.GET)
	public @ResponseBody
	UserModel getDummyUser() {
		UserModel model = new UserModel("abc", "def");

		return model;
	}

	

}