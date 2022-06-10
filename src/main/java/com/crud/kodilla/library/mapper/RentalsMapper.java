package com.crud.kodilla.library.mapper;

import com.crud.kodilla.library.domain.BookCopy;
import com.crud.kodilla.library.domain.Reader;
import com.crud.kodilla.library.domain.Rentals;
import com.crud.kodilla.library.domain.RentalsDto;
import org.springframework.stereotype.Service;

@Service
public class RentalsMapper {

    public Rentals mapToRentals(final RentalsDto rentalsDto) {
        return new Rentals(
                Reader.builder().id(rentalsDto.getId()).build(),
                BookCopy.builder().id(rentalsDto.getId()).build(),
                rentalsDto.getRentalDate(),
                rentalsDto.getReturnDate()
        );
    }

    public RentalsDto mapToRentalsDto(final Rentals rentals) {
        return new RentalsDto(
                rentals.getId(),
                rentals.getReader().getId(),
                rentals.getBookCopy().getId(),
                rentals.getRentalDate(),
                rentals.getReturnDate()
        );
    }
}
