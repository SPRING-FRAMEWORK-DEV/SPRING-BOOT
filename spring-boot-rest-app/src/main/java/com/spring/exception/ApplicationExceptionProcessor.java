package com.spring.exception;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.utils.LoggerManager;

@ControllerAdvice
@Component
public class ApplicationExceptionProcessor {

	Logger logger = new LoggerManager(getClass().getCanonicalName())
			.getLogger();

	@Autowired
	private MessageSource messageSource;

	public ApplicationExceptionProcessor() {
		super();
		// TODO Auto-generated constructor stub

	}

	@ExceptionHandler(UserAuthException.class)
	// @ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorMessage userAuthFailed(HttpServletRequest req,
			HttpServletResponse res, IAppBaseException ex) {

		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage(
				((Throwable) ex).getMessage(), null, locale);

		ErrorMessage em = new ErrorMessage(((Throwable) ex).getMessage(),
				errorMessage);
		printLog((Throwable) ex, em);

		return em;
	}

	@ExceptionHandler(Throwable.class)
	// @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMessage genericHandler(Throwable ex) {
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage("error.internal.server",
				null, locale);

		errorMessage += ex.getMessage();

		ErrorMessage em = new ErrorMessage(
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), errorMessage);
		printLog(ex, em);

		return em;
	}

	// print message to log file and displays in console
	private void printLog(Throwable ex, ErrorMessage em) {

		logger.error("***If the error code starts with 11 then it is an customized error code for application***");

		StackTraceElement[] elems = ex.getStackTrace();
		StringBuffer sb = new StringBuffer();

		logger.error("Error/Exception occured "
				+ ex.getClass().getCanonicalName() + "::" + ex.getMessage()
				+ "::" + elems[0].toString());
		logger.error(em.toString());
		for (int i = 1; i < elems.length; i++) {
			sb.append("\n\t\t" + elems[i].toString());
		}

		logger.error(sb.toString());

	}

}