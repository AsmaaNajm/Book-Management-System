package com.library.bookmanagementsystem.controllers;

import com.library.bookmanagementsystem.dto.BookAddDTO;
import com.library.bookmanagementsystem.dto.BookResponseDTO;
import com.library.bookmanagementsystem.dto.BookUpdateDto;
import com.library.bookmanagementsystem.dto.PatronResponseDTO;
import com.library.bookmanagementsystem.exceptions.ResourceNotFoundException;
import com.library.bookmanagementsystem.mapper.BookMapper;
import com.library.bookmanagementsystem.models.Book;
import com.library.bookmanagementsystem.models.Patron;
import com.library.bookmanagementsystem.services.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        List<BookResponseDTO> result = bookMapper.asBookResponseList(bookList);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) throws ResourceNotFoundException {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok().body(bookMapper.asBookResponse(book));
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> addBook(@Valid @RequestBody BookAddDTO bookAddDTO) {
        Book book = bookMapper.asBook(bookAddDTO);
        Book savedBook = bookService.addBook(book);
        BookResponseDTO bookResponseDTO = bookMapper.asBookResponse(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookUpdateDto bookUpdateDto) throws ResourceNotFoundException {
        Book book = bookService.getBookById(id);
        log.info("book => {}", book);
        Book mapperUpdateBook = bookMapper.asUpdateBook(book, bookUpdateDto);
        log.info("mapperUpdateBook => {}", mapperUpdateBook);
        Book updatedBook = bookService.updateBook(mapperUpdateBook);
        BookResponseDTO bookResponseDTO = bookMapper.asBookResponse(updatedBook);
        return ResponseEntity.ok().body(bookResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id) throws ResourceNotFoundException {
        bookService.deleteBook(id);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", String.format("Book with id %s deleted successfully", id));
        return ResponseEntity.ok().body(response);
    }
}