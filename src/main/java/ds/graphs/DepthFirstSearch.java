package ds.graphs;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Depth-first search can be used to detect connectivity, cycles and bipartiness 
 * @author mallik
 *
 */
public class DepthFirstSearch {

	// Depth-first search (DFS) recursive
	public static Set<Integer> dfs1(Graph<Integer, Integer> g, int val) {
		Set<Integer> visited = new LinkedHashSet<>();
		dfsRecursive(g, val, visited);
		return visited;
	}

	public static void dfsRecursive(Graph<Integer, Integer> g, int val,
			Set<Integer> visited) {
		if (visited.contains(val)) {
			return;
		}
		visited.add(val);
		List<Integer> adj = g.getEdges(val);
		if (adj != null && !adj.isEmpty()) {
			for (int u : adj) {
				dfsRecursive(g, u, visited);
			}
		}
	}
	
	//DFS iterative
	public static Set<Integer> dfs2(Graph<Integer, Integer> g, int val){
		Stack<Integer> s = new Stack<>();
		Set<Integer> visited = new LinkedHashSet<>();
		s.push(val);
		while (!s.isEmpty()){
			int v = s.pop();
			if (visited.contains(v)){
				continue;
			}
			visited.add(v);
			List<Integer> adj = g.getEdges(v);
			if (adj != null && !adj.isEmpty()) {
				for (int u : adj) {
					s.push(u);
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
		System.out.println(dfs1(g, 1));
		System.out.println(dfs2(g, 1));
	}
}
