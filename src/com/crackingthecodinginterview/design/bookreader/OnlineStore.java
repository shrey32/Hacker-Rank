package com.crackingthecodinginterview.design.bookreader;

import java.util.List;
import java.util.Set;

public class OnlineStore {

	private Library library;
	private Reader reader;

	public OnlineStore(Set<Book> books, Set<Author> authors) {
		library = new Library(books, authors);
		reader = new BookReader();
	}

	public void findBookAndRead(String title) {
		Book book = library.findBookByTitle(title);
		reader.read(book);
	}

	public void viewAllBooksForAuthor(String authorName) {
		List<Book> books = library.findAllBooksByAuthorName(authorName);
		for(Book book:books)
			System.out.println(book.getTitle());
	}
	
}
