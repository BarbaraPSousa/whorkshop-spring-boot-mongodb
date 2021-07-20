package com.barbarasousa.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barbarasousa.workshopmongo.domain.User;
import com.barbarasousa.workshopmongo.dto.UserDTO;
import com.barbarasousa.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	@Autowired
	private UserService service; // injeção de depedencia
	
	
	//@GetMapping
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {//Responsavel por retorna todos usuarios
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());// converção da list para listDTO
		return ResponseEntity.ok().body(listDto);
	}	
}
