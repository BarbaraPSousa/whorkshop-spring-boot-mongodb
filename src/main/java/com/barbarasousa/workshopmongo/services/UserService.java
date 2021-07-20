package com.barbarasousa.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbarasousa.workshopmongo.domain.User;
import com.barbarasousa.workshopmongo.repository.UserRepository;
import com.barbarasousa.workshopmongo.services.exeption.ObjectNotFoundExeception;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; // mecanimos do injeção de depedencia

	public List<User> findAll() {// metodo responsavel por filtrar todos so usuarios do banco de dados
		return repo.findAll();
	}

	public User findById(String id){ // metodo responsavel por filtra usuario por id
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception("Objeto não encontrado"));//caso não existir o id solicitado lança tbm uma execption com msg personalizada	
	}
}