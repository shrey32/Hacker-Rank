package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Shrey
 *
 */
class GraphNode {
	private String name;
	boolean isVisited = false;
	List<GraphNode> nodes;

	public GraphNode(String name) {
		this.name = name;
		nodes = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void add(GraphNode conn) {
		this.nodes.add(conn);
	}
}

class Graph {

	private Map<String, GraphNode> map;
	private Map<String, Integer> freq;

	public Graph(Map<String, Integer> freq) {
		this.map = new HashMap<>();
		this.freq = freq;
	}

	public void addEdge(String u, String v) {
		if (!map.containsKey(u))
			map.put(u, new GraphNode(u));
		if (!map.containsKey(v))
			map.put(v, new GraphNode(v));

		map.get(u).add(map.get(v));
		map.get(v).add(map.get(u));
	}

	public HashMap<String, Integer> getTrueFrequency() {
		HashMap<String, Integer> res = new HashMap<>();
		for (GraphNode node : map.values()) {
			if (!node.isVisited) {
				int freq = dfs(node);
				res.put(node.getName(), freq);
			}
		}
		return res;
	}

	public int dfs(GraphNode node) {
		node.isVisited = true;
		int sum = freq.getOrDefault(node.getName(), 0);
		for (GraphNode neighbour : node.nodes) {
			if (!neighbour.isVisited) {
				sum += dfs(neighbour);
			}
		}
		return sum;
	}

}

public class BabyNames {

	public static void main(String[] args) {

		Map<String, Integer> names = new HashMap<String, Integer>();
		names.put("John", 3);
		names.put("Jonathan", 4);
		names.put("Johnny", 5);
		names.put("Chris", 1);
		names.put("Kris", 3);
		names.put("Brian", 2);
		names.put("Bryan", 4);
		names.put("Carleton", 4);

		String[][] synonyms = new String[][] { { "John", "Jonathan" }, { "Jonathan", "Johnny" }, { "Chris", "Kris" },
				{ "Brian", "Bryan" } };
		Graph gr = new Graph(names);

		for (String[] map : synonyms) {
			gr.addEdge(map[0], map[1]);
		}

		System.out.println(gr.getTrueFrequency());

		names = new HashMap<String, Integer>();
		names.put("John", 15);
		names.put("Jon", 12);
		// names.put("Johnny", 5);
		names.put("Chris", 13);
		names.put("Kris", 4);
		names.put("Christopher", 19);

		synonyms = new String[][] { { "Jon", "John" }, { "John", "Johnny" }, { "Chris", "Kris" },
				{ "Chris", "Christopher" } };
		gr = new Graph(names);

		for (String[] map : synonyms) {
			gr.addEdge(map[0], map[1]);
		}

		System.out.println(gr.getTrueFrequency());
	}

}
