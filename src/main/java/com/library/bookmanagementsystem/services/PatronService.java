package com.library.bookmanagementsystem.services;

import com.library.bookmanagementsystem.exceptions.ResourceNotFoundException;
import com.library.bookmanagementsystem.models.Patron;

import java.util.List;

public interface PatronService {
    List<Patron> getAllPatrons();

    Patron getPatronById(Long id) throws ResourceNotFoundException;

    Patron addPatron(Patron patron);

    Patron updatePatron(Patron updatedPatron);

    void deleteParton(Long id) throws ResourceNotFoundException;
}
