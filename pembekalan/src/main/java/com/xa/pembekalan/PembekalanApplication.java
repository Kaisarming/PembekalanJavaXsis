package com.xa.pembekalan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.repository.CategoryRepository;

@SpringBootApplication
public class PembekalanApplication {

	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(PembekalanApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			Category thriller = new Category("Thriller");
			Category novel = new Category("Novel");
			Category horror = new Category("Horror");

			categoryRepository.save(thriller);
			categoryRepository.save(novel);
			categoryRepository.save(horror);
		};
	}

}
