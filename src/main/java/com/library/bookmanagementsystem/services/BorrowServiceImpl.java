package com.library.bookmanagementsystem.services;

import com.library.bookmanagementsystem.models.Book;
import com.library.bookmanagementsystem.models.BorrowingRecord;
import com.library.bookmanagementsystem.models.Patron;
import com.library.bookmanagementsystem.repositories.BookRepository;
import com.library.bookmanagementsystem.repositories.BorrowingRecordRepository;
import com.library.bookmanagementsystem.repositories.PatronRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowServiceImpl implements BorrowService {

    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    public BorrowServiceImpl(BookRepository bookRepository, PatronRepository patronRepository, BorrowingRecordRepository borrowingRecordRepository) {
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
        this.borrowingRecordRepository = borrowingRecordRepository;
    }

    @Override
    @Transactional
    public boolean borrowBook(Long bookId, Long patronId,LocalDate returnDate) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Patron patron = patronRepository.findById(patronId).orElse(null);

        if (book == null || patron == null) {
            return false;
        }

        if (!book.isAvailableForBorrow()) {
            return false;
        }

        book.setAvailableForBorrow(false);
        bookRepository.save(book);

        BorrowingRecord borrowingRecord = new BorrowingRecord(book, patron, LocalDate.now(),returnDate );
        borrowingRecordRepository.save(borrowingRecord);

        return true;
    }

    @Override
    @Transactional
    public boolean returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Patron patron = patronRepository.findById(patronId).orElse(null);

        if (book == null || patron == null) {
            return false;
        }

        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookAndPatronAndReturnDateIsNull(book, patron);

        if (borrowingRecord == null) {
            return false;
        }

        book.setAvailableForBorrow(true);
        bookRepository.save(book);

        borrowingRecord.setReturnDate(LocalDate.now());
        borrowingRecordRepository.save(borrowingRecord);

        return true;
    }
}
