package com.example.demo.services;

import java.util.List;

import com.example.demo.models.BookRequestModel;
import com.example.demo.models.BookResponseModel;

public interface BookService {
	BookResponseModel getBookDetails(int bookId);

	List<BookResponseModel> getBookDetails();

	BookResponseModel addBook(BookRequestModel bookRequestModel);

	void deleteBook(int bookId);

	BookResponseModel updateBook(int bookId, BookRequestModel bookRequestModel);
}
