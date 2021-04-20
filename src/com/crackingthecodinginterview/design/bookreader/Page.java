package com.crackingthecodinginterview.design.bookreader;

public class Page {

	private final String text;
	private final int pageNumber;

	public Page(String text, int pageNumber) {
		this.text = text;
		this.pageNumber = pageNumber;
	}

	public String getText() {
		return text;
	}

	public int getPageNumber() {
		return pageNumber;
	}

}
