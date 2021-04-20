package com.crackingthecodinginterview.design.bookreader;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class Book {

	private final String title;
	private final Author author;
	private final String publicationName;
	private final List<Page> pages;

	public Book(String title, Author author, String publicationName, List<Page> pages) {
		this.title = title;
		this.author = author;
		this.publicationName = publicationName;
		this.pages = new ArrayList<>(pages);
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public String getPublicationName() {
		return publicationName;
	}

	public List<Page> getPages() {
		return List.copyOf(pages);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
