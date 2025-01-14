package com.example.library.dto;

import java.util.List;

import lombok.Data;

@Data
public class PagedBookResponseDTO {
    long total;
    List<BookResponseDTO> books;
}
