package com.crackingthecodinginterview.design.filesystem;

public class FileSystem {

	private final File root;

	public FileSystem() {
		this.root = new File("/", true);
	}

	public void ls(String pattern) {
		String[] dirs = pattern.split("/");
		if (dirs.length == 0)
			print(root.getName(), root);
		else {
			StringBuilder path = new StringBuilder(root.getName());
			File temp = root;
			for (int i = 1; i < dirs.length; i++) {
				if (temp.files().containsKey(dirs[i])) {
					path.append(dirs[i]).append("/");
					temp = temp.files().get(dirs[i]);
				} else {
					System.out.println("[" + pattern + "] no such directory exist!");
					return;
				}
			}
			print(path.toString(), temp);
		}
	}

	private void print(String path, File file) {
		System.out.println(path);
		StringBuilder space = new StringBuilder();
		for (int i = 1; i < path.length(); i++) {
			space.append(" ");
		}
		for (String key : file.files().keySet()) {
			System.out.print(space.toString() + "|_");
			System.out.println(key);
		}
		System.out.println();
	}

	public void mkdir(String pattern) {
		String[] dirs = pattern.split("/");
		if (dirs.length == 1) {
			root.files().put(dirs[0], new File(dirs[0], true));
			return;
		}
		File temp = root;
		for (int i = 1; i < dirs.length; i++) {
			File sub = new File(dirs[i], true);
			if (temp.files().containsKey(dirs[i]))
				sub = temp.files().get(dirs[i]);
			else
				temp.files().put(dirs[i], sub);
			temp = sub;
		}
	}

	public void addContentToFile(String pattern, String content) {
		String[] dirs = pattern.split("/");
		if (dirs.length == 1) {
			File sub = new File(pattern, false);
			sub.setContent(content);
			root.files().put(pattern, sub);
			return;
		}
		File file = root;
		for (int i = 1; i < dirs.length - 1; i++) {
			String curr = dirs[i];
			if (!file.files().containsKey(curr))
				throw new RuntimeException("[" + pattern + "] No Such Directory Exist");
			file = file.files().get(curr);
		}
		File newFile = new File(dirs[dirs.length - 1], false);
		newFile.setContent(content);
		file.files().put(newFile.getName(), newFile);
	}

	public void readContentFromFile(String pattern) {
		String[] dirs = pattern.split("/");
		if (dirs.length == 1 && root.files().containsKey(dirs[0])) {
			readFile(pattern, root);
			return;
		}
		File file = root;
		for (int i = 1; i < dirs.length - 1; i++) {
			String curr = dirs[i];
			if (!file.files().containsKey(curr))
				System.err.println("[" + pattern + "] no such directory exist");
			file = file.files().get(curr);
		}
		readFile(dirs[dirs.length - 1], file);
	}

	private void readFile(String pattern, File root) {
		if (!root.files().containsKey(pattern))
			System.err.println("[" + pattern + "] no such file exist");
		else
			System.out.println(root.files().get(pattern).readContent());
	}

	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		fs.ls("/");
		fs.mkdir("/a/b/c");
		fs.addContentToFile("/a/b/c/d", "Hello");
		fs.ls("/");
		fs.readContentFromFile("/a/b/c/d");
	}

}
