package com.example.restapi.RestApi;

import com.example.restapi.RestApi.ApiRepository;
import com.example.restapi.RestApi.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class LoadDatabase {

    @Autowired
    private ApiRepository repository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            repository.save(new Book(null, "Peter Pan", "Hej på dig", 2020, "James Matthew Barrie", "Children"));
            repository.save(new Book(null, "Lord of the rings", "Saron took control over all of midgard", 1979, "John Ronald Reuel Tolkien", "Fiction"));
            repository.save(new Book(null, "Harry Potter and the Prisoner of Azkaban", "Join Harry Potter as he sets out on the magical journey of a lifetime in the third book in J.K.", 1999, "J. K. Rowling", "Fantasy"));
            repository.save(new Book(null, "Harry Potter and the Philosopher's Stone", "Join Harry Potter as he sets out on the magical journey of a lifetime in the first book in J.K.", 1997, "J. K. Rowling", "Fantasy"));
            repository.save(new Book(null, "Harry Potter and the Chamber of Secrets", "Join Harry Potter as he sets out on the magical journey of a lifetime in the fourth book in J.K.", 1998, "J. K. Rowling", "Fantasy"));
            repository.save(new Book(null, "Harry Potter and the Goblet of Fire", "Join Harry Potter as he sets out on the magical journey of a lifetime in the fifth book in J.K.", 2000, "J. K. Rowling", "Fantasy"));
        };
    }
}