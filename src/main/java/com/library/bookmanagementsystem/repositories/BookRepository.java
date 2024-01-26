package com.library.bookmanagementsystem.repositories;

import com.library.bookmanagementsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
