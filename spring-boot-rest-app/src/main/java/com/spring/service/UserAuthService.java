package com.spring.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.exception.UserAuthException;
import com.spring.model.UserModel;
import com.spring.utils.ValidateUser;

@Service
public class UserAuthService {
	@Autowired
	private ValidateUser validateUser;

	public String validateUser(UserModel model) throws IOException {
		String message = null;

		boolean flag = validateUser.validateUserModel(model);

		if (flag == false)
			throw new UserAuthException("22401");
		message = "User Auth Success";

		return message;
	}

}
