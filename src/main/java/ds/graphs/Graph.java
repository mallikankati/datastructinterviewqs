package ds.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<V> {
	Set<V> vertexs = new HashSet<>();
	List<V> adjacents = new ArrayList<>();
	
	public Set<V> getVertexs(){
		return this.vertexs;
	}
	
	public void addEdge(V v, V u){
		this.vertexs.add(v);
		this.adjacents.add(u);
	}
}
