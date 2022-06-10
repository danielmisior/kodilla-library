package com.crud.kodilla.library.controller;

import com.crud.kodilla.library.domain.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/library")
public class LibraryController {

    @PostMapping(value = "addReader", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addReader(ReaderDto readerDto) {
        //nothing yet
    }

    @PostMapping(value = "addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTitle(BookDto bookDto) {
        //nothing yet
    }

    @PostMapping(value = "addBookCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBookCopy(BookCopyDto bookCopyDto) {
        //nothing yet
    }

    @PutMapping
    public void updateStatus(BookCopyDto bookCopyDto) {
        //nothing yet
    }

    @GetMapping(value = "{bookId}")
    public Long getQuantityOfAvailableBookCopies(@PathVariable Long bookId) {
        //nothing yet
        return 0L;
    }

    @PutMapping(value = "rentBook")
    public void rentBookCopy(RentalsDto rentalsDto) {
        //nothing yet
    }

    @PutMapping(value = "returnBook")
    public void returnBookCopy(RentalsDto rentalsDto) {
        //nothing yet
    }
}
