package com.library.bookmanagementsystem.services;

import com.library.bookmanagementsystem.exceptions.ResourceNotFoundException;
import com.library.bookmanagementsystem.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id) throws ResourceNotFoundException;
    Book addBook(Book book);

    Book updateBook(Book updatedBook) throws ResourceNotFoundException;

    void deleteBook(Long id) throws ResourceNotFoundException;
}
