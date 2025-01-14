package com.example.library.mapper;

import com.example.library.dto.AssignedBookResponseDto;
import com.example.library.dto.AuthorRequestDTO;
import com.example.library.dto.AuthorResponseDTO;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.service.BookService;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AssignedBookResponseDto toAssignedBookDTO(Book book);

    List<AssignedBookResponseDto> toAssignedBookListDTO(List<Book> book);

    Author toEntity(AuthorRequestDTO authorRequestDTO);

    AuthorResponseDTO toResponseDTO(Author author);

    List<AuthorResponseDTO> toResponseDTOList(List<Author> author);
}
