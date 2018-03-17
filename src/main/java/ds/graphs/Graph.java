package ds.graphs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<V, U> {
	// Set<V> vertexs = new HashSet<>();
	// List<V> adjacents = new ArrayList<>();

	private Map<V, List<U>> adjacents = new LinkedHashMap<>();

	public Set<V> getVertexs() {
		return this.adjacents.keySet();
	}

	public void addEdge(V v, U u) {
		// this.vertexs.add(v);
		// this.adjacents.add(u);
		if (adjacents.containsKey(v)) {
			this.adjacents.get(v).add(u);
		} else {
			List<U> list = new ArrayList<>();
			list.add(u);
			this.adjacents.put(v, list);
		}
	}

	public List<U> getEdges(V v) {
		return this.adjacents.get(v);
	}
	
	public String toString(){
		return this.adjacents.toString();
	}
}
