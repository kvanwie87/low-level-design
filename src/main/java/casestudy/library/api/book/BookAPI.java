package casestudy.library.api.book;

import java.util.List;

import casestudy.library.model.Book;
import casestudy.library.repo.BookRepository;

public class BookAPI {
	private BookRepository bookRepo;
	public BookResponse findBookAuthor(String author) {
		// Validations
		List<Book> books = bookRepo.findByAuthor(author);
		BookResponse resp = new BookResponse();
		if(books != null && !books.isEmpty()) {
			resp.books = books;
			resp.status = 200;
		} else {
			resp.status = 404;
		}
		
		return resp;
	}
	public BookResponse findBookTitle(String title) {
		// Validations
		
		return null;
	}
	//removeBook(...)
	//addBook(...)
	//addBookCopy(..)
	//removeBookCopy(..
}
