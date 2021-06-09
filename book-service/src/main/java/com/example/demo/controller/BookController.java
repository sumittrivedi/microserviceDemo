package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.BookRequestModel;
import com.example.demo.models.BookResponseModel;
import com.example.demo.services.BookService;

@RestController
@RequestMapping(value = "books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookResponseModel>> getAllBooks() {
		List<BookResponseModel> bookResponseModels = bookService.getBookDetails();
		return new ResponseEntity<>(bookResponseModels, HttpStatus.OK);
	}

	@GetMapping(value = "{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookResponseModel> getBookByBookId(@PathVariable int bookId) {
		BookResponseModel bookResponseModel = bookService.getBookDetails(bookId);
		return new ResponseEntity<>(bookResponseModel, HttpStatus.OK);
	}

	@PostMapping(value = "")
	public ResponseEntity<BookResponseModel> addBook(@RequestBody BookRequestModel bookRequestModel) {
		BookResponseModel bookResponseModel = bookService.addBook(bookRequestModel);
		return new ResponseEntity<>(bookResponseModel, HttpStatus.OK);
	}

	@DeleteMapping(value = "{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		bookService.deleteBook(bookId);
	}

	@PutMapping(value = "{bookId}")
	public ResponseEntity<BookResponseModel> updateBook(@PathVariable int bookId,
			@RequestBody BookRequestModel bookRequestModel) {
		BookResponseModel bookResponseModel = bookService.updateBook(bookId, bookRequestModel);
		return new ResponseEntity<>(bookResponseModel, HttpStatus.OK);
	}
}
