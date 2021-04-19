package com.crackingthecodinginterview.design.jukebox;

/**
 * 
 * @author Shrey
 *
 */
public class Artist {

	private final String firstname, lastname;

	public Artist(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

}
