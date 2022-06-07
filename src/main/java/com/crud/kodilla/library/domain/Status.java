package com.crud.kodilla.library.domain;

import lombok.Getter;

@Getter
public enum Status {

    AVAILABLE,
    BORROWED,
    LOST,
    DESTROYED;
}
