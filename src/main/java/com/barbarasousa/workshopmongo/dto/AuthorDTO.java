//responsavel por salvar apenas alguns dados do usuario
package com.barbarasousa.workshopmongo.dto;

import java.io.Serializable;

import com.barbarasousa.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	public AuthorDTO() {
	}
	
	public AuthorDTO(User obj) { // construtor com usuario, apenas copiando os dados 
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
