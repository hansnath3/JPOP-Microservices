package com.book.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.dto.BookDTO;
import com.book.service.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;
	
    @GetMapping(value="/")
    public List<BookDTO> books(){
    	return bookService.findAllBooks();
    }
    
    @GetMapping(value="/{bookId}")
    public BookDTO books(@PathVariable("bookId") Long bookId){
    	return bookService.findBook(bookId);
    }
    
    @PostMapping(value="/")
    public String saveBooks(@RequestBody BookDTO book){
    	bookService.saveBook(book);
    	return "Book added successfully.";
    }
    
    @DeleteMapping(value="/{bookId}")
    public String deleteBook(@PathVariable Long bookId){
    	bookService.deleteBook(bookId);
    	return "Book deleted successfully";
    }
    
    @PutMapping(value="/{bookId}")
    public String updateBook(@PathVariable Long bookId,@RequestBody BookDTO book){
    	bookService.updateBook(book,bookId);
    	return "Book updated successfully";
    }
}
