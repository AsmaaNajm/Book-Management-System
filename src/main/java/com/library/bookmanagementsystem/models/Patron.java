package com.library.bookmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Patron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contactInformation;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<BorrowingRecord> borrowingRecords;

}