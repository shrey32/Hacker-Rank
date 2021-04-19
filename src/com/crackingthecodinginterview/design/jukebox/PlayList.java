package com.crackingthecodinginterview.design.jukebox;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class PlayList {

	private String name;
	private List<Song> songs;

	public PlayList(String name) {
		this.name = name;
		this.songs = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void addSong(Song song) {
		this.songs.add(song);
	}

	public List<Song> getSongs() {
		return List.copyOf(songs);
	}

}
