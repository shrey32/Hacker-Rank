package com.crackingthecodinginterview.design.bookreader;

import java.util.ArrayList;
import java.util.List;

public class Author {

	private final String name;
	private final List<Book> booksPublished;

	public Author(String name, List<Book> booksPublished) {
		this.name = name;
		this.booksPublished = new ArrayList<>(booksPublished);
	}

	public String getName() {
		return name;
	}

	public List<Book> getBooksPublished() {
		return List.copyOf(booksPublished);
	}

}
