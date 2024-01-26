package com.library.bookmanagementsystem.controllers;

import com.library.bookmanagementsystem.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<String> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId, @PathVariable LocalDate returnDate) {
        boolean success = borrowService.borrowBook(bookId, patronId, returnDate);
        if (success) {
            return ResponseEntity.ok("Book borrowed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Unable to borrow the book.");
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        boolean success = borrowService.returnBook(bookId, patronId);
        if (success) {
            return ResponseEntity.ok("Book returned successfully.");
        } else {
            return ResponseEntity.badRequest().body("Unable to return the book.");
        }
    }
}
