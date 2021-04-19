package com.crackingthecodinginterview.design.jukebox;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Shrey
 *
 */
public class JukeBox implements Player {

	private final List<Song> allSongs;
	private final List<PlayList> playlists;
	public final Queue<Song> currentQueue;
	private Song current;

	public JukeBox(List<Song> allSongs) {
		this.allSongs = new ArrayList<>(allSongs);
		playlists = new ArrayList<>();
		currentQueue = new LinkedList<>();
	}

	public Song selectSong(String songName) {
		Song requiredSong = null;
		for (Song song : allSongs) {
			if (songName.equals(song.getName())) {
				requiredSong = song;
				break;
			}
		}
		if (requiredSong == null) {
			throw new IllegalArgumentException("Provided song not available");
		}
		return requiredSong;
	}

	public PlayList selectPlayList(String playListName) {
		PlayList requriedPlayList = null;
		for (PlayList playList : this.playlists) {
			if (playListName.equals(playList.getName())) {
				requriedPlayList = playList;
			}
		}
		if (requriedPlayList == null) {
			throw new IllegalArgumentException("Provided Playlist not available");
		}
		return requriedPlayList;
	}

	@Override
	public void play(String songName) {
		Song song = selectSong(songName);
		LinkedList<Song> queue = (LinkedList<Song>) this.currentQueue;
		queue.addFirst(song);
		this.play(this.currentQueue.poll());
	}

	public void play(Song song) {
		this.current = song;
		System.out.println("playing..." + this.current.getName());
		try {
			Thread.sleep(this.current.getDurationInMinutes() * 1L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		if (this.current == null)
			throw new RuntimeException("No Song is being played currently...");
		System.out.println("stopping..." + this.current.getName());
		this.current = null;
	}

	@Override
	public void addToCurrentQueue(String songName) {
		Song song = selectSong(songName);
		this.currentQueue.offer(song);
	}

	@Override
	public void playPlayList(String playListName) {
		PlayList playList = selectPlayList(playListName);
		this.currentQueue.clear();
		this.stop();
		this.currentQueue.addAll(playList.getSongs());
		while (!this.currentQueue.isEmpty()) {
			this.play(this.currentQueue.poll());
		}
	}

	@Override
	public void addPlayListToCurrentQueue(String playListName) {
		PlayList playList = selectPlayList(playListName);
		this.currentQueue.addAll(playList.getSongs());
	}
}
