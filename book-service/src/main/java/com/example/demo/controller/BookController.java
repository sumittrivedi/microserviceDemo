package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;

@RestController
@RequestMapping(value = "books")
public class BookController {

	@GetMapping(value = "{book_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBookDetails(@PathVariable String book_id) {
		Book bookModel = new Book();
		return new ResponseEntity<Book>(bookModel,HttpStatus.OK);
	}

}
