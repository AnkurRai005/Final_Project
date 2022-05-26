package org.npci.itemapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {

Logger log = LoggerFactory.getLogger("CentralExceptionHandler.class");
	
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(InvalidEmailIdException.class)
	public String invalidEmailId(InvalidEmailIdException e) {
		log.error("Email Id is not in correct format.");
		return e.getMessage();
	}
	
	@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(InvalidPhoneNoException.class)
	public String invalidPhoneNo(InvalidPhoneNoException e) {
		log.error("Phone Number is not in correct format.");
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IntegrityViolationException.class)
	public String userNotAvailable(IntegrityViolationException e) {
		log.error(e.getMessage());
		return e.getMessage();
	}
}
