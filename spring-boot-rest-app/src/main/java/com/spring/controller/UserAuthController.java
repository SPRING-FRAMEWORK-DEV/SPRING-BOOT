package com.spring.controller;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.UserModel;
import com.spring.service.UserAuthService;
import com.spring.utils.LoggerManager;

@Controller("userAuthController")
public class UserAuthController {

	Logger logger = new LoggerManager(getClass().getCanonicalName())
			.getLogger();
	@Autowired
	private DataSource ds;

	@RequestMapping("/")
	private String getIndexPage() {
		System.out.println("**************************");
		return "index";
	}

	@Autowired
	private UserAuthService service;

	@RequestMapping(value = "user/dummy", method = RequestMethod.GET)
	public @ResponseBody
	UserModel getDummyUser() {
		UserModel model = new UserModel("abc", "def");

		return model;
	}

	@RequestMapping(value = "user/validate", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> validateUserCredentials(
			@RequestBody UserModel model) throws IOException {

		ResponseEntity<String> response = null;
		String serviceMessage = service.validateUser(model);
		response = new ResponseEntity<String>(serviceMessage, HttpStatus.OK);

		return response;
	}

}
