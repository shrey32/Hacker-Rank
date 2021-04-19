package com.crackingthecodinginterview.design.jukebox;

public interface Player {

	public void play(String song);

	public void stop();

	public void addToCurrentQueue(String song);

	public void playPlayList(String playListName);

	public void addPlayListToCurrentQueue(String playListName);
}
