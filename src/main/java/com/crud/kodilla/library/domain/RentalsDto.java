package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalsDto {

    private Long id;
    private Long readerId;
    private Long bookCopyId;
    private Date rentalDate;
    private LocalDate returnDate;
}
