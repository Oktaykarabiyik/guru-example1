package com.example.guruexample1.bootstrap;

import com.example.guruexample1.domain.Author;
import com.example.guruexample1.domain.Book;
import com.example.guruexample1.domain.repositories.AuthorRepository;
import com.example.guruexample1.domain.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        System.out.println("Started in Bootstrap");
        System.out.println(("Number of Books: "+bookRepository.count()));

    }
}
