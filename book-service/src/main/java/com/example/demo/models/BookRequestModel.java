package com.example.demo.models;

import lombok.Data;

@Data
public class BookRequestModel {
	private String bookTitle;
	private String bookDesc;
	private String author;
	private String category;
}
