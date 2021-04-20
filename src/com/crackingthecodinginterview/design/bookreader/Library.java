package com.crackingthecodinginterview.design.bookreader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {

	private final Map<String, Author> authorsLibrary;
	private final Map<String, Book> library;

	public Library(Set<Book> books, Set<Author> authors) {
		library = new HashMap<>(books.size());
		authorsLibrary = new HashMap<>(authors.size());
		initBooks(books);
		initAuthors(authors);
	}

	private void initBooks(Set<Book> books) {
		for (Book book : books) {
			library.put(book.getTitle(), book);
		}
	}

	private void initAuthors(Set<Author> authors) {
		for (Author author : authors) {
			authorsLibrary.put(author.getName(), author);
		}
	}

	public Book findBookByTitle(String title) {
		if (library.containsKey(title))
			return library.get(title);
		throw new RuntimeException("No such Book exist in our Library!");
	}

	public List<Book> findAllBooksByAuthorName(String authorName) {
		if (authorsLibrary.containsKey(authorName))
			return List.copyOf(authorsLibrary.get(authorName).getBooksPublished());
		throw new RuntimeException("No such Author exist in our Library!");
	}

	public Book addNewBook(Book book) {
		return this.library.put(book.getTitle(), book);
	}

	public Author addNewAuthor(Author author) {
		return this.authorsLibrary.put(author.getName(), author);
	}

}
