package com.library.bookmanagementsystem.controllers;

import com.library.bookmanagementsystem.dto.PatronAddDTO;
import com.library.bookmanagementsystem.dto.PatronResponseDTO;
import com.library.bookmanagementsystem.dto.PatronUpdateDTO;
import com.library.bookmanagementsystem.exceptions.ResourceNotFoundException;
import com.library.bookmanagementsystem.mapper.BookMapper;
import com.library.bookmanagementsystem.mapper.PatronMapper;
import com.library.bookmanagementsystem.models.Book;
import com.library.bookmanagementsystem.models.Patron;
import com.library.bookmanagementsystem.services.PatronService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/patrons")
public class PatronController {


    private final PatronService patronService;

    private final PatronMapper patronMapper;

    @GetMapping
    public ResponseEntity<List<PatronResponseDTO>> getAllPatrons() {
        List<Patron> patronList = patronService.getAllPatrons();
        List<PatronResponseDTO> result = patronMapper.asPatronResponseList(patronList);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatronResponseDTO> getPatronById(@PathVariable Long id) throws ResourceNotFoundException {
        Patron patron = patronService.getPatronById(id);
        return ResponseEntity.ok().body(patronMapper.asPatronResponse(patron));
    }

    @PostMapping
    public ResponseEntity<PatronResponseDTO> addPatron(@Valid @RequestBody PatronAddDTO patronAddDTO) {
        Patron savedPatron = patronService.addPatron(patronMapper.asPatron(patronAddDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(patronMapper.asPatronResponse(savedPatron));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatronResponseDTO> updatePatron(@PathVariable Long id, @Valid @RequestBody PatronUpdateDTO patronUpdateDTO) throws ResourceNotFoundException {
        Patron patron = patronService.getPatronById(id);
        Patron mapperUpdatepatron = patronMapper.asUpdatePatron(patron, patronUpdateDTO);
        Patron updatedPatron = patronService.updatePatron(mapperUpdatepatron);
        return ResponseEntity.ok().body(patronMapper.asPatronResponse(updatedPatron));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id) throws ResourceNotFoundException {
        patronService.deleteParton(id);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", String.format("Patron with id %s deleted successfully", id));
        return ResponseEntity.ok().body(response);
    }
}
