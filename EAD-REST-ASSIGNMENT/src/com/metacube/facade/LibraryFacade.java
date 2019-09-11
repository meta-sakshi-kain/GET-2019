package com.metacube.facade;

import java.util.List;

import com.metacube.dao.BaseDao;
import com.metacube.dao.Query;
import com.metacube.enums.Status;
import com.metacube.factory.Factory;
import com.metacube.model.Book;

public class LibraryFacade {

	private BaseDao baseDao = Factory.createLibraryDao();

	public List<Book> getAllBooks() {
		return baseDao.getAllBooks(Query.getAllBooks());
	}

	public Book getBookByTitle(String title) {
		return baseDao.getBookByTitle(Query.getBookByTitle(title));
	}

	public Status deleteAllBooks() {
		return baseDao.deleteAllBooks(Query.deleteAllBooks());
	}

	public Status deleteBookById(int id) {
		return baseDao.deleteBookById(Query.deleteBookById(id));
	}

	public Status addBook(String bookTitle, String bookWriter,
			String publisher, int publishedYear) {
		return baseDao.addBook(Query.addBook(bookTitle, bookWriter, publisher,
				publishedYear));
	}

	public Status updateBook(String title, int publishedYear) {
		return baseDao.updateBook(Query.updateBook(title, publishedYear));
	}

}
