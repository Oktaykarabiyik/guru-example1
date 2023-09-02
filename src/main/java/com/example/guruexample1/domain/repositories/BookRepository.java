package com.example.guruexample1.domain.repositories;

import com.example.guruexample1.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
