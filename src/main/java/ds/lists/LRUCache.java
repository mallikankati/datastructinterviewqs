package ds.lists;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	// initial size
	private int CACHE_SIZE = 3;

	// doubly linked list
	private DLinkedList dlist = new DLinkedList();

	private Map<String, DListNode> keys = new HashMap<>();

	public LRUCache() {
	}

	public LRUCache(int initialSize) {
		this.CACHE_SIZE = initialSize;
	}

	public void put(String key, int value) {
		if (keys.size() == CACHE_SIZE) {
			DListNode node = dlist.removeLast();
			keys.remove(node.key);
		}
		if (keys.containsKey(key)) {
			DListNode node = keys.get(key);
			dlist.remove(node);
		}
		DListNode node = new DListNode(value);
		node.key = key;
		dlist.addFirst(node);
		keys.put(key, node);
	}

	public int get(String key) {
		int rvalue = -1;
		DListNode node = keys.get(key);
		if (node != null) {
			dlist.remove(node);
			dlist.addFirst(node);
			rvalue = node.val;
		}
		return rvalue;
	}

	public void print() {
		dlist.print();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		cache.put("1", 1);
		cache.put("2", 2);
		cache.put("3", 3);
		cache.put("4", 4);
		cache.print();
		cache.put("3", 5);
		cache.print();
	}
}
