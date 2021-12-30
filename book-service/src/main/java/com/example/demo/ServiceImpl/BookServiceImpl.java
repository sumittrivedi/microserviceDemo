package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookEntity;
import com.example.demo.models.BookRequestModel;
import com.example.demo.models.BookResponseModel;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookResponseModel getBookDetails(int bookId) {
		BookEntity bookEntity = bookRepository.findById(bookId).orElse(null);
		BookResponseModel bookResponseModel = new BookResponseModel();
		if (bookEntity != null) {
			bookResponseModel.setBookId(bookEntity.getBookId());
			bookResponseModel.setBookTitle(bookEntity.getBookTitle());
			bookResponseModel.setBookDesc(bookEntity.getBookDesc());
			bookResponseModel.setAuthor(bookEntity.getAuthor());
			bookResponseModel.setCategory(bookEntity.getCategory());

		}
		return bookResponseModel;
	}

	@Override
	public List<BookResponseModel> getBookDetails() {
		Iterable<BookEntity> bookEntityList = bookRepository.findAll();
		List<BookResponseModel> bookResponseModels = new ArrayList<>();
		if (bookEntityList != null) {
			for (BookEntity bookEntity : bookEntityList) {
				BookResponseModel bookResponseModel = new BookResponseModel();
				bookResponseModel.setBookId(bookEntity.getBookId());
				bookResponseModel.setBookTitle(bookEntity.getBookTitle());
				bookResponseModel.setBookDesc(bookEntity.getBookDesc());
				bookResponseModel.setAuthor(bookEntity.getAuthor());
				bookResponseModel.setCategory(bookEntity.getCategory());
				bookResponseModels.add(bookResponseModel);
			}
		}
		return bookResponseModels;
	}

	@Override
	public BookResponseModel addBook(BookRequestModel bookRequestModel) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookTitle(bookRequestModel.getBookTitle());
		bookEntity.setBookDesc(bookRequestModel.getBookDesc());
		;
		bookEntity.setAuthor(bookRequestModel.getAuthor());
		;
		bookEntity.setCategory(bookRequestModel.getCategory());
		bookRepository.save(bookEntity);
		return getBookDetails(bookEntity.getBookId());
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public BookResponseModel updateBook(int bookId, BookRequestModel bookRequestModel) {
		BookEntity bookEntity = bookRepository.findById(bookId).orElse(null);
		if (bookEntity != null) {
			bookEntity.setBookTitle(bookRequestModel.getBookTitle());
			bookEntity.setBookDesc(bookRequestModel.getBookDesc());
			;
			bookEntity.setAuthor(bookRequestModel.getAuthor());
			;
			bookEntity.setCategory(bookRequestModel.getCategory());
			bookRepository.save(bookEntity);
		}
		return getBookDetails(bookId);
	}

}
