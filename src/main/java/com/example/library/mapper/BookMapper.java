package com.example.library.mapper;

import com.example.library.dto.AssignedBookResponseDto;
import com.example.library.dto.BookRequestDTO;
import com.example.library.dto.BookResponseDTO;
import com.example.library.dto.PagedBookResponseDTO;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = AuthorService.class)
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    AssignedBookResponseDto toAssignedBookDTO(Book book);

    List<AssignedBookResponseDto> toAssignedBookListDTO(List<Book> book);

    @Mapping(source = "authorId", target = "author")
    Book toEntity(BookRequestDTO bookRequestDTO);

    @Mapping(source = "author.name", target = "authorName")
    BookResponseDTO toResponseDTO(Book book);

    List<BookResponseDTO> toResponseDTOList(List<Book> books);

    PagedBookResponseDTO toPagedBookResponseDTO(long total, List<Book> books);
}
