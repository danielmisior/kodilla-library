package com.crud.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderDto {

    private Long id;
    private String name;
    private String surname;
    private Date dateCreated;
}
