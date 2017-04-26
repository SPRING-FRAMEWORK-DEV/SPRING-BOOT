package com.spring.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.spring.model.UserModel;

@Component
public class ValidateUser {

	public boolean validateUserModel(UserModel model) throws IOException {
		Properties props = new Properties();
		InputStream is = ValidateUser.class.getClassLoader().getResourceAsStream("userauth.properties");
		

		props.load(is);

		String userName = props.getProperty("username");
		String password = props.getProperty("password");

		UserModel model1 = new UserModel(userName, password);

		if (model.equals(model1) == false) {
			return false;
		}
		
		return true;
	}
}
