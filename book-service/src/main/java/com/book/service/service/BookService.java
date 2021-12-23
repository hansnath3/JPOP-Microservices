package com.book.service.service;

import java.util.List;

import com.book.service.dto.BookDTO;

public interface BookService {

	void save(BookDTO book);

	List<BookDTO> findAllBooks();

	BookDTO findById(Long bookId);

	void delete(Long bookId);

	void update(BookDTO book, Long bookId);

}
