package com.metacube.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.enums.Status;
import com.metacube.facade.LibraryFacade;
import com.metacube.factory.Factory;
import com.metacube.model.Book;
import com.google.gson.Gson;

//class for executing get,put,post,delete REST methods
@Path("/home")
public class LibraryResource {

	private LibraryFacade libraryFacade = Factory.createLibraryFacade();
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public String showAllBooks() {
		System.out.println("sbjw");
		List<Book> books = libraryFacade.getAllBooks();
		if (books.size() > 0) {
			Gson gson=new Gson();
			String booksJson = gson.toJson(books);
			return booksJson;
		} else
			return "no book found";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{title}")
	public String showBookByTitle(@PathParam("title") String title) {
		Book book = libraryFacade.getBookByTitle(title);
		if (book.getBookId() > 0) {
			Gson gson=new Gson();
			String bookJson = gson.toJson(book);
			return bookJson;
		} else
			return "No book found";
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAllBooks() {
		if (libraryFacade.deleteAllBooks() == Status.DELETED)
			return "All books are successfully deleted";
		else
			return "Operation failed";
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String deleteBookById(@PathParam("id") int id) {
		if (libraryFacade.deleteBookById(id) == Status.DELETED)
			return "book successfully deleted";
		else
			return "Book does not exist";
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addBook(Book book) {
		if (libraryFacade.addBook(book.getBookTitle(), book.getBookWriter(),
				book.getPublisher(),book.getPublishedYear()) == Status.ADDED)
			return "book successfully added";
		else
			return "Operation failed";
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{title}")
	public String updateBook(@PathParam("title") String title, Book book) {
		if (libraryFacade.updateBook(title, book.getPublishedYear()) == Status.UPDATED)
			return "Successfully updated";
		else
			return "Operation failed";
	}
}
