package com.expedia.events.utils;

import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EventDateFormatValidator implements ConstraintValidator<EventDateFormat, String> {

	String format;

	@Override
	public void initialize(EventDateFormat constraintAnnotation) {
		// TODO Auto-generated method stub
		format = constraintAnnotation.format();
		System.out.println("****"+format);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean flag = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		simpleDateFormat.setLenient(false);
		try {
			simpleDateFormat.parse(value);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}

		return flag;
	}

}
