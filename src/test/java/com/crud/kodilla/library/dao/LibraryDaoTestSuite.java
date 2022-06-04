package com.crud.kodilla.library.dao;

import com.crud.kodilla.library.domain.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DaoTestSuite {

    @Autowired
    private ReaderDao readerDao;

    @Test
    void testSaveReaderDao() {
        //Given
        Reader reader = new Reader("John", "Smith");

        readerDao.save(reader);

        //When
        Long id = reader.getId();

        //Then
        assertEquals(1L, id);

        //CleanUp
        readerDao.deleteById(id);
    }
}
