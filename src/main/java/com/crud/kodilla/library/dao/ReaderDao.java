package com.crud.kodilla.library.dao;

import com.crud.kodilla.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ReaderDao extends CrudRepository<Reader, Integer> {
}
