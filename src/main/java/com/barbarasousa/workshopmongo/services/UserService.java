package com.barbarasousa.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbarasousa.workshopmongo.domain.User;
import com.barbarasousa.workshopmongo.dto.UserDTO;
import com.barbarasousa.workshopmongo.repository.UserRepository;
import com.barbarasousa.workshopmongo.services.exeption.ObjectNotFoundExeception;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; // mecanimos do injeção de depedencia

	public List<User> findAll() {// metodo responsavel por buscar todos so usuarios do banco de dados no repositorio
		return repo.findAll();
	}

	public User findById(String id){ // metodo responsavel por buscar o usuario por id no repositorio
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception("Objeto não encontrado"));//caso não existir o id solicitado lança tbm uma execption com msg personalizada	
	}
	
	public User insert(User obj) { // metodo responsavel por inserir usuario no repositorio
		return repo.insert(obj);
	}
	
	public void delete(String id) { // metodo responsavel por deleta usuariono no repositorio
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User fromDTO(UserDTO objDto) { 
		return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
	}
}