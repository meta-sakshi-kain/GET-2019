package com.metacube.dao;

import java.util.List;

import com.metacube.enums.Status;
import com.metacube.model.Book;

public interface BaseDao<T> {

	/**
	 * method for get all books
	 * @param query for get all books
	 * @return list of books
	 */
	public abstract List<Book> getAllBooks(String query);

	/**
	 * method for get book by title
	 * @param query get book by title
	 * @return book of title
	 */
	public abstract Book getBookByTitle(String query);

	/**
	 * METHOD FOR DELETE ALL BOOKS
	 * @param query FOR DELETE ALL BOOKS
	 * @return Status of delete
	 */
	public abstract Status deleteAllBooks(String query);

	/**
	 * method for delete book by id
	 * @param query for delete book by id
	 * @return status for delete
	 */
	public abstract Status deleteBookById(String query);

	/**
	 * method for add new book record
	 * @param query for add book
	 * @return status of add
	 */
	public abstract Status addBook(String query);

	/**
	 * method for update published year of book
	 * @param query for update published year of book
	 * @return status of update
	 */
	public abstract Status updateBook(String query);
	
}
