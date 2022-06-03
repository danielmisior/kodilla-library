package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COPIES_OF_BOOKS")
public final class BookCopy {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "BOOK_ID", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @Column(name = "STATUS")
    private Status status;

    @OneToMany(
            targetEntity = Rentals.class,
            mappedBy = "bookCopy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rentals> rentals;
}
