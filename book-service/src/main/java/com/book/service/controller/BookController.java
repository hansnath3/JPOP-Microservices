package com.book.service.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.config.Configuration;
import com.book.service.dto.BookDTO;
import com.book.service.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;
	
	@Autowired
	Configuration configuration; 
	
	@ApiOperation(value = "Finds all books data.",
			    notes = "No input value needed.",
			    response = BookDTO.class,
			    responseContainer = "List")
//	@HystrixCommand(fallbackMethod = "fallbackBooks", commandProperties = {
//			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//			})
    @GetMapping(value="/")
    public List<BookDTO> get(){
    	return bookService.findAllBooks();
    }
    
	@ApiOperation(value = "Finds single book data.",
		    notes = "Input needed of book id in parameter.",
		    response = BookDTO.class)
    @GetMapping(value="/{bookId}")
    public BookDTO getById(@PathVariable("bookId") Long bookId){
    	return bookService.findById(bookId);
    }
    
	@ApiOperation(value = "Saves book data.",
		    notes = "Provide json request data of book.",
		    response = BookDTO.class)
    @PostMapping(value="/")
    public String save(@RequestBody BookDTO book){
    	bookService.save(book);
    	return "Book added successfully.";
    }
	
	@ApiOperation(value = "Delete book data.",
		    notes = "Provide book id as input for deletion.",
		    response = BookDTO.class)
    @DeleteMapping(value="/{bookId}")
    public String deleteById(@PathVariable Long bookId){
    	bookService.delete(bookId);
    	return "Book deleted successfully";
    }
	@ApiOperation(value = "Update book data.",
		    notes = "Provide book id as input for updation.",
		    response = BookDTO.class)
    @PutMapping(value="/{bookId}")
    public String update(@PathVariable Long bookId,@RequestBody BookDTO book){
    	bookService.update(book,bookId);
    	return "Book updated successfully";
    }
	
	private List<BookDTO> fallbackBooks() {
		   return Collections.emptyList();
	}
	
	@GetMapping(value="/limit")
    public String limit(){
    	//System.out.println("URL = "+configuration.getUrl());
    	System.out.println("User name = "+configuration.getUsername());
    	return "User name = "+configuration.getUrl();
    }
}
