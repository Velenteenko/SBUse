package com.ua.ingk.spboot.initial.controller.exept;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ua.ingk.spboot.initial.exception.RestException;

@Controller
public class ExceptionHandlerController {

	private static final Logger logger = Logger.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(RestException.class)
	@ResponseBody
	public String handleException(RestException exception) {

		logger.error("Error from handler: " + exception.getLocalizedMessage(), exception);

		return "Handling error: " + exception.getMessage();
	}

}
