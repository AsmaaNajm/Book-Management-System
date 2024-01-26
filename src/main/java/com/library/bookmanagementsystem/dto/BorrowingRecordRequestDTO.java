package com.library.bookmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class BorrowingRecordRequestDTO {
    @NotNull(message = "Book ID is required")
    private Long bookId;

    @NotNull(message = "Patron ID is required")
    private Long patronId;

    @NotNull(message = "Borrow date is required")
    private LocalDate borrowDate;

    private LocalDate returnDate;

}
