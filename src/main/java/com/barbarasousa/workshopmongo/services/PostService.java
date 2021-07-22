package com.barbarasousa.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbarasousa.workshopmongo.domain.Post;
import com.barbarasousa.workshopmongo.repository.PostRepository;
import com.barbarasousa.workshopmongo.services.exeption.ObjectNotFoundExeception;

@Service
public class PostService {

	@Autowired
	private PostRepository repo; // mecanimos do injeção de depedencia

	public Post findById(String id){ // metodo responsavel por buscar o Post por id no repositorio
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception("Objeto não encontrado"));//caso não existir o id solicitado lança tbm uma execption com msg personalizada	
	}
	
	public List<Post> findByTitle(String text){ //metodo responsavel por buscar por text
		
		return repo.searchTitle(text); // Busca com Query
		
		//return repo.findByTitleContainingIgnoreCase(text); Busca sem Query
	}
}