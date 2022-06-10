package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RENTALS")
public final class Rentals {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "RENTAL_ID", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_COPY_ID")
    private BookCopy bookCopy;

    @Column(name = "RENTAL_DATE")
    private Date rentalDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    public Rentals(Reader reader, BookCopy bookCopy, Date rentalDate, LocalDate returnDate) {
        this.reader = reader;
        this.bookCopy = bookCopy;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Rentals(Reader reader, BookCopy bookCopy, LocalDate returnDate) {
        this.reader = reader;
        this.bookCopy = bookCopy;
        this.rentalDate = new Date();
        this.returnDate = returnDate;
    }
}
