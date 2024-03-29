package com.library.bookmanagementsystem.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateDto {
    @NotNull
    @NotBlank(message = "Title is required")
    private String title;
    @NotNull
    @NotBlank(message = "Author is required")
    private String author;
    @NotNull
    @NotBlank(message = "PublicationYear is required")
    private Integer publicationYear;
}