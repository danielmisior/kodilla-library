package com.crud.kodilla.library.mapper;

import com.crud.kodilla.library.domain.BookCopy;
import com.crud.kodilla.library.domain.BookCopyDto;
import org.springframework.stereotype.Service;

@Service
public class BookCopyMapper {

    public BookCopy mapToBookCopy(final BookCopyDto bookCopyDto) {
        BookCopy bookCopy = BookCopy.builder()
                .id(bookCopyDto.getId())
                .status(bookCopyDto.getStatus())
                .build();

        return bookCopy;
    }

    public BookCopyDto mapToBookCopyDto(final BookCopy bookCopy) {
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getStatus()
        );
    }
}
