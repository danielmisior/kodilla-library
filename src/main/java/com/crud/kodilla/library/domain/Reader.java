package com.crud.kodilla.library.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "READERS")
public final class Reader {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "READER_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "SURNAME")
    private String surname;

    @NotNull
    @Column(name = "CREATED")
    private Date dateCreated;

    @OneToMany(
            targetEntity = Rentals.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rentals> rentals;
    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.dateCreated = new Date();
    }

    public Reader(Long id, String name, String surname, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateCreated = new Date();
    }
}
