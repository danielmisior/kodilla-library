package com.crud.kodilla.library.dao;

import com.crud.kodilla.library.domain.Rentals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface RentalsDao extends CrudRepository<Rentals, Integer> {

    Rentals save(Rentals rentals);
    void deleteById(Long id);
    Optional<Rentals> findById(Long id);
}
