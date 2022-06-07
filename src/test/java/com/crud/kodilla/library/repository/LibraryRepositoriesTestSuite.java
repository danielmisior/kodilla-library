package com.crud.kodilla.library.repository;

import com.crud.kodilla.library.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Repositories Test")
public class LibraryRepositoriesTestSuite {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private RentalsRepository rentalsRepository;

    private static int testCounter;

    private Reader reader;
    private Book book;
    private BookCopy bookCopy;
    private Rentals rental;
    private List<BookCopy> bookCopies;
    private List<Rentals> rentalsList;

    @BeforeEach
    void beforeEveryTest() {
        bookCopies = new ArrayList<>();
        rentalsList = new ArrayList<>();

        reader = new Reader("John", "Smith");
        book = new Book("Title", "Author",
                LocalDate.of(2000,1,1), bookCopies);
        bookCopy = new BookCopy(book, Status.AVAILABLE, rentalsList);
        rental = new Rentals(reader, bookCopy, LocalDate.now().plusDays(14L));

        testCounter++;
        System.out.println("Executing Test #" + testCounter);
    }

    @AfterEach
    void afterEveryTest() {
        System.out.println("Test #" + testCounter + " is finished.");
    }

    @DisplayName("Save Reader Test")
    @Test
    void testSaveReader() {
        //Given
        readerRepository.save(reader);

        //When
        Long id = reader.getId();
        String name = reader.getName();
        String surname = reader.getSurname();

        //Then
        try {
            assertEquals("John", name);
            assertEquals("Smith", surname);
            assertNotNull(id);
        } finally {
            //CleanUp
            readerRepository.deleteById(id);
        }
    }

    @DisplayName("Save Title Test")
    @Test
    void testSaveTitle() {
        //Given
        bookRepository.save(book);

        //When
        String title = book.getTitle();
        String author = book.getAuthor();
        Long bookId = book.getId();

        //Then
        try {
            assertEquals("Title", title);
            assertEquals("Author", author);
            assertNotNull(bookId);
        } finally {
            //CleanUp
            bookRepository.deleteById(bookId);
        }
    }

    @DisplayName("Save BookCopy Test")
    @Test
    void testSaveBookCopy() {
        //Given
        bookCopies.add(bookCopy);
        bookCopy.setBook(book);

        bookCopyRepository.save(bookCopy);

        //When
        String title = bookCopy.getBook().getTitle();
        String author = bookCopy.getBook().getAuthor();
        int numberOfRentals = bookCopy.getRentals().size();

        Long bookCopyId = bookCopy.getId();

        //Then
        try {
            assertEquals("Title", title);
            assertEquals("Author", author);
            assertEquals(0, numberOfRentals);
            assertNotEquals(null, bookCopyId);

        } finally {
            //CleanUp
            bookCopyRepository.deleteById(bookCopyId);
        }
    }

    @DisplayName("Save Rentals Test")
    @Test
    void testSaveRentals() {
        //Given
        bookCopies.add(bookCopy);
        bookCopy.setBook(book);

        rentalsRepository.save(rental);

        //When
        Long rentalId = rental.getId();
        Long readerId = rental.getReader().getId();
        Long bookCopyId = rental.getBookCopy().getId();
        Long bookId = rental.getBookCopy().getBook().getId();
        String readerName = rental.getReader().getName();
        String title = rental.getBookCopy().getBook().getTitle();

        //Then
        try {
            assertNotNull(rentalId);
            assertNotNull(readerId);
            assertNotNull(bookCopyId);
            assertNotNull(bookId);
            assertEquals("John", readerName);
            assertEquals("Title", title);
        } finally {
            //CleanUp
            rentalsRepository.deleteById(rentalId);
        }
    }
}
