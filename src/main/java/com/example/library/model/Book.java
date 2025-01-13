package com.example.library.model;

import com.example.library.constant.Genre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Genre genre;
    private String description;
    private Boolean isFavourite;
    private Integer numberOfCopies;  

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)  
    private Author author;
}