package com.crud.kodilla.library.dao;

import com.crud.kodilla.library.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;

public interface BookCopyDao extends CrudRepository<BookCopy, Integer> {
}
