package com.java.forms.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.forms.error.ModelError;

public class ErrorMapper {

	public static String getErrorFieldMessages(List<FieldError> fieldErrors) throws JsonProcessingException {
		List<String> errorList = new ArrayList<String>();

		for (FieldError fe : fieldErrors) {
			ModelError me = new ModelError(fe.getField(), fe.getDefaultMessage());

			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(me);
			errorList.add(json);
		}
		Collections.sort(errorList);
		return errorList.toString();
	}
}
