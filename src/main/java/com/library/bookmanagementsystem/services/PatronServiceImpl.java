package com.library.bookmanagementsystem.services;

import com.library.bookmanagementsystem.exceptions.ResourceNotFoundException;
import com.library.bookmanagementsystem.models.Patron;
import com.library.bookmanagementsystem.repositories.PatronRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronServiceImpl implements PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Cacheable(value = "patrons")
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Cacheable(value = "patron", key = "#id")
    public Patron getPatronById(Long id) throws ResourceNotFoundException {
        return patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Patron with id %s not found", id)));

    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(cacheNames = {"patron"}, allEntries = true),
            @CacheEvict(cacheNames = {"patrons"}, allEntries = true)})
    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    @Transactional
    //    @CachePut(cacheNames = "patron", key = "#id")
    @Caching(evict = {
            @CacheEvict(cacheNames = {"patron"}, allEntries = true),
            @CacheEvict(cacheNames = {"patrons"}, allEntries = true)})
    public Patron updatePatron(Patron updatedPatron) {
        return patronRepository.save(updatedPatron);
    }


    @Transactional
    @Caching(evict = {
            @CacheEvict(cacheNames = {"patron"}, allEntries = true),
            @CacheEvict(cacheNames = {"patrons"}, allEntries = true)})
    public void deleteParton(Long id) throws ResourceNotFoundException {
        patronRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Patron with id %s not found", id)));
        patronRepository.deleteById(id);
    }
}
