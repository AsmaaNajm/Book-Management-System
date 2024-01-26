package com.library.bookmanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BorrowingRecordResponseDTO {
    private Long id;
    private BookResponseDTO book;
    private PatronResponseDTO patron;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
