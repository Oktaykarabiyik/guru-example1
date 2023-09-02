package com.example.guruexample1.domain.repositories;

import com.example.guruexample1.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
