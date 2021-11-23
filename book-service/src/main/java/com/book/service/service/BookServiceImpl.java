package com.book.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.service.dto.BookDTO;
import com.book.service.model.Book;
import com.book.service.repository.BookRepository;
import com.book.service.util.CustomMapper;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	
	@Override
	public void saveBook(BookDTO bookDto) {
		Book  book = CustomMapper.convertDtoToModel(bookDto);
		bookRepository.save(book);
	}
	
	@Override
	public List<BookDTO> findAllBooks() {
		List<Book> books = (List<Book>) bookRepository.findAll();
		return CustomMapper.convertToDtoFromList(books);
	}
	
	@Override
	public BookDTO findBook(Long bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		return CustomMapper.convertModelToDto(book);
	}
	
	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public void updateBook(BookDTO bookDto,Long bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		if(book.isPresent()) {
			Book b = book.get();
			b.setAuthor(bookDto.getAuthor());
			b.setCategory(bookDto.getCategory());
			b.setDescription(bookDto.getDescription());
			b.setName(bookDto.getName());
			bookRepository.save(b);
		}
		
	}

}
