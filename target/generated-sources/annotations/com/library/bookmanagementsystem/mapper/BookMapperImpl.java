package com.library.bookmanagementsystem.mapper;

import com.library.bookmanagementsystem.dto.BookAddDTO;
import com.library.bookmanagementsystem.dto.BookResponseDTO;
import com.library.bookmanagementsystem.dto.BookUpdateDto;
import com.library.bookmanagementsystem.models.Book;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-26T22:20:43+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book asBook(BookAddDTO book) {
        if ( book == null ) {
            return null;
        }

        Book book1 = new Book();

        book1.setTitle( book.getTitle() );
        book1.setAuthor( book.getAuthor() );
        book1.setPublicationYear( book.getPublicationYear() );
        book1.setISBN( book.getISBN() );

        return book1;
    }

    @Override
    public BookResponseDTO asBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setId( book.getId() );
        bookResponseDTO.setTitle( book.getTitle() );
        bookResponseDTO.setAuthor( book.getAuthor() );
        bookResponseDTO.setPublicationYear( book.getPublicationYear() );
        bookResponseDTO.setISBN( book.getISBN() );

        return bookResponseDTO;
    }

    @Override
    public List<BookResponseDTO> asBookResponseList(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookResponseDTO> list = new ArrayList<BookResponseDTO>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( asBookResponse( book ) );
        }

        return list;
    }

    @Override
    public Book asUpdateBook(Book book, BookUpdateDto bookUpdateDto) {
        if ( bookUpdateDto == null ) {
            return book;
        }

        if ( bookUpdateDto.getTitle() != null ) {
            book.setTitle( bookUpdateDto.getTitle() );
        }
        if ( bookUpdateDto.getAuthor() != null ) {
            book.setAuthor( bookUpdateDto.getAuthor() );
        }
        if ( bookUpdateDto.getPublicationYear() != null ) {
            book.setPublicationYear( bookUpdateDto.getPublicationYear() );
        }

        return book;
    }
}
