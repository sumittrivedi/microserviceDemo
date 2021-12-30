package com.example.demo.models;

import lombok.Data;

@Data
public class BookResponseModel {
	private int bookId;
	private String bookTitle;
	private String bookDesc;
	private String author;
	private String category;
}
