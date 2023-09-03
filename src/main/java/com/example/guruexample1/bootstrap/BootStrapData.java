package com.example.guruexample1.bootstrap;

import com.example.guruexample1.domain.Publisher;
import com.example.guruexample1.domain.Author;
import com.example.guruexample1.domain.Book;
import com.example.guruexample1.domain.repositories.AuthorRepository;
import com.example.guruexample1.domain.repositories.BookRepository;
import com.example.guruexample1.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher =new Publisher();

        publisher.setName("Oktay");
        publisher.setCity("Kastamonu");


        System.out.println(("Number of Publisher: "+publisherRepository.count()));

        Author eric = new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);




        authorRepository.save(eric);
        bookRepository.save(ddd);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println(("Number of Books: "+bookRepository.count()));
        System.out.println("Publisher number of Books"+publisher.getBooks().size());


    }
}
