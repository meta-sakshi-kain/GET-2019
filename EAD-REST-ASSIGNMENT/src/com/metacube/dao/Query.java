package com.metacube.dao;
//class for all the database queries
public class Query {

	public static String getAllBooks() {
		return "SELECT * FROM BOOK";
	}

	public static String getBookByTitle(String title) {
		return "SELECT * FROM BOOK where title ='" + title + "'";
	}

	public static String countBooks() {
		return "select count(id) from book";
	}

	public static String deleteAllBooks() {
		return "TRUNCATE TABLE BOOK";
	}

	public static String deleteBookById(int id) {
		return "DELETE FROM BOOK WHERE id = '" + id + "'";
	}

	public static String addBook(String bookTitle, String bookWriter,
			String publisher, int publishedYear) {
		return "insert into book(title,writer,publisher,published_year) values('"
				+ bookTitle
				+ "','"
				+ bookWriter
				+ "','"
				+ publisher
				+ "',"
				+ publishedYear + ")";
	}

	public static String updateBook(String title, int year) {
		return "update book set published_year = '" + year
				+ "' where title = '" + title + "'";
	}
}
