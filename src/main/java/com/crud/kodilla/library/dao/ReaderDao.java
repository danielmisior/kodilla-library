package com.crud.kodilla.library.dao;

import com.crud.kodilla.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;

public interface ReaderDao extends CrudRepository<Reader, Integer> {
}
