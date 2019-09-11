package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.enums.Status;
import com.metacube.model.Book;
//class for handling database operations
public class LibraryDao implements BaseDao<Book> {

	private Connection connection;

	public LibraryDao() throws ClassNotFoundException, SQLException {
		connection = MySQLCon.getConnection();
	}

	@Override
	public List<Book> getAllBooks(String query) {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setBookId(resultSet.getInt(1));
				book.setBookTitle(resultSet.getString(2));
				book.setBookWriter(resultSet.getString(3));
				book.setPublisher(resultSet.getString(4));
				book.setPublishedYear(resultSet.getInt(5));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book getBookByTitle(String query) {
		Book book = new Book();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			book.setBookId(resultSet.getInt(1));
			book.setBookTitle(resultSet.getString(2));
			book.setBookWriter(resultSet.getString(3));
			book.setPublisher(resultSet.getString(4));
			book.setPublishedYear(resultSet.getInt(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Status deleteAllBooks(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.executeUpdate();
			return Status.DELETED;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.FAILED;
	}

	@Override
	public Status deleteBookById(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			if (statement.executeUpdate() > 0)
				return Status.DELETED;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.FAILED;
	}

	@Override
	public Status addBook(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			if (statement.executeUpdate() > 0)
				return Status.ADDED;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.FAILED;
	}

	@Override
	public Status updateBook(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			if (statement.executeUpdate() > 0)
				return Status.UPDATED;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Status.FAILED;
	}
}
