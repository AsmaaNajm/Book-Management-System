package com.library.bookmanagementsystem.services;

import java.time.LocalDate;

public interface BorrowService {
    boolean borrowBook(Long bookId, Long patronId,LocalDate returnDate);
    boolean returnBook(Long bookId, Long patronId);
}
