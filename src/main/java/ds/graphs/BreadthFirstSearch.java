package ds.graphs;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
	// Breadth-first search using iterative
	public static Set<Integer> bfs(Graph<Integer, Integer> g, int val) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(val);
		Set<Integer> visited = new LinkedHashSet<>();
		while (!q.isEmpty()) {
			int v = q.poll();
			if (visited.contains(v)) {
				continue;
			}
			visited.add(v);
			List<Integer> list = g.getEdges(v);
			if (list != null && !list.isEmpty()) {
				for (int u : list) {
					q.offer(u);
				}
			}
		}
		return visited;
	}

	public static void main(String[] args) {
		Graph<Integer, Integer> g = new Graph<>();
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 5);
		g.addEdge(3, 5);
		System.out.println(g);
		System.out.println(bfs(g, 1));
	}
}
