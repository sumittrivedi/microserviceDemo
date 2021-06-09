package com.example.demo.services;

import com.example.demo.entity.BookEntity;

public interface BookService {
	BookEntity getBookDetails(String bookId);
}
