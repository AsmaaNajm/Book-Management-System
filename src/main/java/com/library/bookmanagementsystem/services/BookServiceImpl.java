package com.library.bookmanagementsystem.services;

import com.library.bookmanagementsystem.exceptions.ResourceNotFoundException;
import com.library.bookmanagementsystem.models.Book;
import com.library.bookmanagementsystem.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Cacheable(value = "books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Cacheable(value = "book", key = "#id")
    public Book getBookById(Long id) throws ResourceNotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Book with id %s not found", id)));

    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(cacheNames = {"book"}, allEntries = true),
            @CacheEvict(cacheNames = {"books"}, allEntries = true)})
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(cacheNames = {"book"}, allEntries = true),
            @CacheEvict(cacheNames = {"books"}, allEntries = true)})
    public Book updateBook(Book updatedBook) {
        return bookRepository.save(updatedBook);
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(cacheNames = {"book"}, allEntries = true),
            @CacheEvict(cacheNames = {"books"}, allEntries = true)})
    public void deleteBook(Long id) throws ResourceNotFoundException {
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Book with id %s not found", id)));
        bookRepository.deleteById(id);
    }
}
