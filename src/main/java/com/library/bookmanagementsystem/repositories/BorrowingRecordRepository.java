package com.library.bookmanagementsystem.repositories;

import com.library.bookmanagementsystem.models.Book;
import com.library.bookmanagementsystem.models.BorrowingRecord;
import com.library.bookmanagementsystem.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    BorrowingRecord findByBookAndPatronAndReturnDateIsNull(Book book, Patron patron);
}
