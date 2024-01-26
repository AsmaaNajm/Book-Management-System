package com.library.bookmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronAddDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Contact information is required")
    private String contactInformation;

}
