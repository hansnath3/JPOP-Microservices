package com.book.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;

import com.book.service.dto.BookDTO;
import com.book.service.model.Book;

public class CustomMapper {
	public static Book convertDtoToModel(BookDTO bookDto) {
		Book book = new Book();
		book.setName(bookDto.getName());
		book.setAuthor(bookDto.getAuthor());
		book.setCategory(bookDto.getCategory());
		book.setDescription(bookDto.getDescription());
		return book;
	}
	
	public static List<BookDTO> convertToDtoFromList(List<Book> books) {
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		books.stream().forEach(b->{
			BookDTO bookDTO = new BookDTO();
			bookDTO.setName(b.getName());
			bookDTO.setAuthor(b.getAuthor());
			bookDTO.setCategory(b.getCategory());
			bookDTO.setDescription(b.getDescription());
			bookDTO.setId(b.getId());
			bookList.add(bookDTO);
		});
		return bookList;
	}

	public static BookDTO convertModelToDto(Optional<Book> book) {
		BookDTO bookDto = new BookDTO();
		if(book.isPresent()){
			Book b = book.get();
			bookDto.setName(b.getName());
			bookDto.setAuthor(b.getAuthor());
			bookDto.setCategory(b.getCategory());
			bookDto.setDescription(b.getDescription());
			bookDto.setId(b.getId());
		}
		return bookDto;
	}
}
