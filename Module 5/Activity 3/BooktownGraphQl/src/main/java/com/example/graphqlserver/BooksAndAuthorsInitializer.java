package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.graphqlserver.model.Author;
import com.example.graphqlserver.model.Book;
import com.example.graphqlserver.repository.AuthorRepository;
import com.example.graphqlserver.repository.BookRepository;
import com.example.graphqlserver.services.BookService;


@Configuration
public class BooksAndAuthorsInitializer {
    
    @Bean
    @Order(1)
    CommandLineRunner booksCommandLineRunner (BookRepository bookRepository) {
        return args -> {
            //initialize books first
            List<Book> books = Arrays.asList( 
                new Book("123456789", "The Road Not Taken", 0),
                new Book("987654321", "To Kill a Mockingbird", 1),
                new Book("456789123", "The Great Gatsby", 2)
            );            
            bookRepository.saveAll(books);

        };        
    }

    @Bean
    @Order(2)
    CommandLineRunner authorsCommandLineRunner (AuthorRepository authorRepository) {
        return args -> {            
            Author author1 = new Author(0, "Robert", "Frost", BookService.getBooksByAuthorId(0));
            Author author2 = new Author(1, "Martin", "Fowler", BookService.getBooksByAuthorId(1));
            Author author3 = new Author(2, "Kevin", "Gary", BookService.getBooksByAuthorId(2));

            authorRepository.saveAll(Arrays.asList(author1, author2, author3));
        };
    }

}
