package com.barbarasousa.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barbarasousa.workshopmongo.domain.Post;
import com.barbarasousa.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	@Autowired
	private PostService service; // injeção de depedencia
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){ // Responsavel por retorna usuario por ID
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
