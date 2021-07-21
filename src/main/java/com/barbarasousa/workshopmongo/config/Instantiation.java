package com.barbarasousa.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.barbarasousa.workshopmongo.domain.Post;
import com.barbarasousa.workshopmongo.domain.User;
import com.barbarasousa.workshopmongo.dto.AuthorDTO;
import com.barbarasousa.workshopmongo.repository.PostRepository;
import com.barbarasousa.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception { // responsavel por instanciar o banco de dados para test
		// ==>formatação de data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		// ==>limpa a banco de dados
		userRepository.deleteAll();
		postRepository.deleteAll();

		// ==>Instanciando test
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		// ==>Salvando usuario no banco de dados
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); // ==> salva usuarios

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2018"), "Bom dia", "Acordei Feliz hoje!", new AuthorDTO(maria));
		
		// ==>Salvando Post com DTO banco de dados
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
