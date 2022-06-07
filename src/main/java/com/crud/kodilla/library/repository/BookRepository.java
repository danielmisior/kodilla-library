package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    Book save(Book book);
    void deleteById(Long id);
    Optional<Book> findById(Long id);
}
