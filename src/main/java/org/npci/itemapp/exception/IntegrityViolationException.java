package org.npci.itemapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class IntegrityViolationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8123976387776162293L;
	final String message;
}
