package com.barbarasousa.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.barbarasousa.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//==>Consulta com Query
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String tex);
	
	//==>Consulta sem Query
	List<Post> findByTitleContainingIgnoreCase(String text); // metodo de buscar
}
