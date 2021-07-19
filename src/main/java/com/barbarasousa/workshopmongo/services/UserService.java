package com.barbarasousa.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbarasousa.workshopmongo.domain.User;
import com.barbarasousa.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; //mecanimos do injeção de depedencia
	
	public List<User> findAll() {//metodo responsavel por retorna todos so usuarios do banco de dados
		return repo.findAll();
	}
}
