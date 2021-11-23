package com.book.service.service;

import java.util.List;

import com.book.service.dto.BookDTO;

public interface BookService {

	void saveBook(BookDTO book);

	List<BookDTO> findAllBooks();

	BookDTO findBook(Long bookId);

	void deleteBook(Long bookId);

	void updateBook(BookDTO book, Long bookId);

}
