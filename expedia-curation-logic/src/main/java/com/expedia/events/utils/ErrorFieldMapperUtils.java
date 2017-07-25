package com.expedia.events.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.expedia.events.error.FieldErrorDTO;

public class ErrorFieldMapperUtils {

	public static List<FieldErrorDTO> getErrorFieldMessages(BindingResult result) {
		List<FieldErrorDTO> errorList = new ArrayList<FieldErrorDTO>();
		List<FieldError> fieldErrors = result.getFieldErrors();
		for (FieldError fe : fieldErrors) {
			FieldErrorDTO fed = new FieldErrorDTO(fe.getField(), fe.getDefaultMessage());
			errorList.add(fed);
		}
		Collections.sort(errorList);
		return errorList;
	}
}