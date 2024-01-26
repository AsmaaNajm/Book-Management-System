package com.library.bookmanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private Integer publicationYear;
    private String ISBN;
}

