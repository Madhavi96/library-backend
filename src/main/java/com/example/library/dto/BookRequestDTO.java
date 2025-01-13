package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequestDTO {
    
    private String name;
    private String genre;
    private String description;
    private Boolean isFavourite;
    private Integer numberOfCopies;
    private Long authorId;  // authorId to associate with an Author
}
