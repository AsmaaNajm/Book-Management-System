package com.library.bookmanagementsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String ISBN;
    @Getter
    private boolean availableForBorrow;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BorrowingRecord> borrowingRecords;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(id, book.id)) return false;
        if (!Objects.equals(ISBN, book.ISBN)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ISBN);
    }
}