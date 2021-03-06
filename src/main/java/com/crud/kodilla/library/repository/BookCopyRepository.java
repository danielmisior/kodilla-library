package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Integer> {

    BookCopy save(BookCopy bookCopy);
    void deleteById(Long id);
    Optional<BookCopy> findById(Long id);
}
