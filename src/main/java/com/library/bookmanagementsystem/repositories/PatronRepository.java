package com.library.bookmanagementsystem.repositories;

import com.library.bookmanagementsystem.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepository extends JpaRepository<Patron, Long> {
}
