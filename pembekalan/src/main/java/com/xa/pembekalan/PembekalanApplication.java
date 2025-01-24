package com.xa.pembekalan;

import java.time.ZoneId;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.xa.pembekalan.entity.Author;
import com.xa.pembekalan.entity.Book;
import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.entity.User;
import com.xa.pembekalan.repository.AuthorRepository;
import com.xa.pembekalan.repository.BookRepository;
import com.xa.pembekalan.repository.CategoryRepository;
import com.xa.pembekalan.repository.UserRepository;
import com.xa.pembekalan.entity.Publisher;
import com.xa.pembekalan.repository.PublisherRepository;

@SpringBootApplication
public class PembekalanApplication {

	// @Autowired digunakan untuk Dependency Injection
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(PembekalanApplication.class, args);
	}

	/*
	 * Metode CommandLineRunner ini akan dijalankan setelah aplikasi Spring Boot
	 * selesai diinisialisasi. CommandLineRunner sering digunakan untuk menjalankan
	 * kode inisialisasi atau setup saat aplikasi dimulai.
	 */
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			// Category thriller = new Category("Thriller");
			// Category novel = new Category("Novel");
			// Category horror = new Category("Horror");

			// categoryRepository.save(thriller);
			// categoryRepository.save(novel);
			// categoryRepository.save(horror);

			Faker faker = new Faker(Locale.forLanguageTag("id-ID"));

			for (int i = 0; i < 10; i++) {
				Category categorySeed = new Category(faker.book().genre());
				categoryRepository.save(categorySeed);

				User userSeed = new User(faker.name().fullName(), faker.phoneNumber().phoneNumber(),
						faker.address().fullAddress());
				userRepository.save(userSeed);

				Publisher publisherSeed = new Publisher(faker.book().publisher(), faker.address().fullAddress());
				publisherRepository.save(publisherSeed);

				Author authorSeed = new Author(faker.book().author(), faker.book().title());
				authorRepository.save(authorSeed);

				// Book bookSeed = new Book(categorySeed, publisherSeed, authorSeed,
				// authorSeed.getPublishedBook(),
				// faker.number().randomDigit(),
				// faker.date().birthday());
				Book bookSeed = new Book(categorySeed, publisherSeed, authorSeed, authorSeed.getPublishedBook(),
						faker.number().randomDigit(), faker.date().birthday().toInstant()
								.atZone(ZoneId.systemDefault())
								.toLocalDate());
				bookRepository.save(bookSeed);
			}
		};
	}

}
