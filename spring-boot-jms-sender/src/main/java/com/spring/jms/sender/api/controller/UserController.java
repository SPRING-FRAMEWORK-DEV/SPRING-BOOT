package com.spring.jms.sender.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jms.sender.api.model.UserSendResponse;
import com.spring.jms.sender.api.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "/sendToClient")
	public UserSendResponse sendMessageToClient() {
		int noOfRecords = service.sendUsers();
		UserSendResponse response = new UserSendResponse();
		response.setFlag(Boolean.TRUE);
		response.setStatus("Record Send successfully To Consumer");
		response.setRecords(noOfRecords);
		return response;
	}

}
