package com.book.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.book.service.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
