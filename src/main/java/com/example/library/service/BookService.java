package com.example.library.service;

import com.example.library.dto.BookRequestDTO;
import com.example.library.dto.BookResponseDTO;
import com.example.library.dto.PagedBookResponseDTO;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public PagedBookResponseDTO getAllBooks(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Book> pagedBooks = bookRepository.findAll(pageRequest);
        return bookMapper.toPagedBookResponseDTO(pagedBooks.getTotalElements(), pagedBooks.getContent());
    }

    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return bookMapper.toResponseDTO(book);
    }

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        // Map DTO to entity
        Book book = bookMapper.toEntity(bookRequestDTO);

        // Save book
        book = bookRepository.save(book);

        // Map entity to response DTO
        return bookMapper.toResponseDTO(book);
    }

    public BookResponseDTO updateBook(Long id, BookRequestDTO bookRequestDTO) {
        // Map DTO to entity
        Book book = bookMapper.toEntity(bookRequestDTO);
        book.setId(id);

        // Save book
        book = bookRepository.save(book);

        // Map entity to response DTO
        return bookMapper.toResponseDTO(book);
    }

    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
