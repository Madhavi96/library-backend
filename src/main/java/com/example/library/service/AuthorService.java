package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.dto.AuthorRequestDTO;
import com.example.library.dto.AuthorResponseDTO;
import com.example.library.mapper.AuthorMapper;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public Author getAuthorEntityById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    public List<AuthorResponseDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authorMapper.toResponseDTOList(authors);
    }

    public AuthorResponseDTO getAuthorById(Long id) {
        Author author = getAuthorEntityById(id);
        return authorMapper.toResponseDTO(author);
    }

    
    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO) {
        // Convert AuthorRequestDTO to Author entity
        Author author = authorMapper.toEntity(authorRequestDTO);

        // Save the Author entity
        author = authorRepository.save(author);

        // Return the AuthorResponseDTO after saving
        return authorMapper.toResponseDTO(author);
    }

    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO authorRequestDTO) {
        // Convert AuthorRequestDTO to Author entity
        Author author = authorMapper.toEntity(authorRequestDTO);
        Author exisitingAuthor =  getAuthorEntityById(id);
        
        author.setId(id);
        author.setBooks(exisitingAuthor.getBooks());
        author = authorRepository.save(author);        

        // Map the updated author to a response DTO
        return authorMapper.toResponseDTO(author);
    }


    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        authorRepository.deleteById(id);
    }
}
