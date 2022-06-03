package com.crud.kodilla.library.dao;

import com.crud.kodilla.library.domain.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleDao extends CrudRepository<Title, Integer> {
}
