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
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id){
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) { // metodo responsavel por deleta usuariono no repositorio
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {// metodos responsavel por atualizar dados pelo usuario
		User newObj = findById(obj.getId());
		updateDete(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateDete(User newObj, User obj) {// metodo responsavel por copiar os novos dados passados pelo usuario
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) { 
		return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
	}
}