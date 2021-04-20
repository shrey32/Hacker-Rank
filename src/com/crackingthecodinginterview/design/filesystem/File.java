package com.crackingthecodinginterview.design.filesystem;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
public class File {

	private String name;
	private final boolean isDirectory;
	private final Map<String, File> map;
	private String content;

	public File(String name, boolean isDirectory) {
		this.name = name;
		this.isDirectory = isDirectory;
		map = new HashMap<>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isDirectory() {
		return this.isDirectory;
	}

	public Map<String, File> files() {
		return map;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void appendContent(String content) {
		StringBuilder sb = new StringBuilder(this.content).append(content);
		this.content = sb.toString();
	}

	public String readContent() {
		return this.content;
	}

}
