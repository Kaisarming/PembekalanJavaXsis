package com.xa.pembekalan;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.entity.User;
import com.xa.pembekalan.repository.CategoryRepository;
import com.xa.pembekalan.repository.UserRepository;
import com.xa.pembekalan.entity.Publisher;
import com.xa.pembekalan.repository.PublisherRepository;

@SpringBootApplication
public class PembekalanApplication {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PublisherRepository publisherRepository;

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

			Faker faker = new Faker(Locale.forLanguageTag("id-ID"));

			for (int i = 0; i < 10; i++) {
				User userSeed = new User(faker.name().fullName(), faker.phoneNumber().phoneNumber(),
						faker.address().fullAddress());
				userRepository.save(userSeed);
			}

			for (int i = 0; i < 10; i++) {
				Publisher publisherSeed = new Publisher(faker.book().publisher(), faker.address().fullAddress());
				publisherRepository.save(publisherSeed);
			}
		};
	}

}
