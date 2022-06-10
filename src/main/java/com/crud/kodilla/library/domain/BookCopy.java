package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COPIES_OF_BOOKS")
public final class BookCopy {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "BOOK_COPY_ID", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TITLE_ID")
    private Book book;

    @Column(name = "STATUS")
    private Status status;

    @OneToMany(
            targetEntity = Rentals.class,
            mappedBy = "bookCopy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rentals> rentals;

    public BookCopy(Book book, Status status, List<Rentals> rentals) {
        this.book = book;
        this.status = status;
        this.rentals = rentals;
    }
}
