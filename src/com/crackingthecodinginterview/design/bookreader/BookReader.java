package com.crackingthecodinginterview.design.bookreader;

public class BookReader implements Reader {

	@Override
	public void read(Book book) {
		System.out.println("Reading..." + book.getTitle());
	}

}
