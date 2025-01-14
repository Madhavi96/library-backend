package com.example.library.dto;

import com.example.library.constant.Genre;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookResponseDTO {
    private Long id;
    private String name;
    private Genre genre;
    private String description;
    private Boolean isFavourite;
    private Integer numberOfCopies;
    private String authorName;
    private String urlId;
}
