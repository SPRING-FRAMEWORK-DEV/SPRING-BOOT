package com.expedia.events.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.expedia.events.utils.ErrorFieldMapperUtils;

@RestControllerAdvice
public class EventApiErrorHandler {

	@ResponseBody
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InputFieldDataNotValidException.class)
	public List<FieldErrorDTO> fieldErrorHandler(InputFieldDataNotValidException ex)
	{
		return ErrorFieldMapperUtils.getErrorFieldMessages(ex.getBindingResult());
	}
	
}
