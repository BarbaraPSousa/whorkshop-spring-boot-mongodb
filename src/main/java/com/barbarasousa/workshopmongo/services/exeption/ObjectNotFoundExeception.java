//Responsavel por personalizar a exception

package com.barbarasousa.workshopmongo.services.exeption;

public class ObjectNotFoundExeception extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExeception(String msg) {
		super(msg);
	}
}
