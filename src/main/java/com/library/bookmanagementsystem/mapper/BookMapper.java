package com.library.bookmanagementsystem.mapper;

import com.library.bookmanagementsystem.dto.BookAddDTO;
import com.library.bookmanagementsystem.dto.BookResponseDTO;
import com.library.bookmanagementsystem.dto.BookUpdateDto;
import com.library.bookmanagementsystem.models.Book;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface BookMapper {

    Book asBook(BookAddDTO book);

    BookResponseDTO asBookResponse(Book book);

    List<BookResponseDTO> asBookResponseList(List<Book> bookList);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book asUpdateBook(@MappingTarget Book book, BookUpdateDto bookUpdateDto);


}
