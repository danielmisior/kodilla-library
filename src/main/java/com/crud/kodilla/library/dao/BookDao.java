package com.crud.kodilla.library.dao;

import com.crud.kodilla.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

    Book save(Book book);
    void deleteById(Long id);
    Optional<Book> findById(Long id);
}
