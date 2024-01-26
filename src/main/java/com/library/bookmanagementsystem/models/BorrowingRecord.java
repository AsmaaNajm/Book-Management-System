package com.library.bookmanagementsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;


    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowingRecord(Book book, Patron patron, LocalDate borrowDate, LocalDate returnDate) {
    }
}
