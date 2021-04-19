package com.crackingthecodinginterview.design.jukebox;

/**
 * 
 * @author Shrey
 *
 */
public class Song {

	private final String name;
	private final int durationInMinutes;
	private final Artist artist;

	public Song(String name, int durationInMinutes, Artist artist) {
		this.name = name;
		this.durationInMinutes = durationInMinutes;
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public Artist getArtist() {
		return artist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Song other = (Song) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
