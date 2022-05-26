package org.npci.itemapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvalidPhoneNoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8731508592205839381L;
	final String message;
}
