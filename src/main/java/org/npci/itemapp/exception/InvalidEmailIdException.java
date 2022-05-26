package org.npci.itemapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class InvalidEmailIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4498727064008938965L;
	final String message;
}
