package ds.lists;

public class DLinkedList {
	private DListNode head;
	private DListNode tail;

	public void addFirst(DListNode node) {
		if (head == null && tail == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	public void addLast(DListNode node) {
		if (head == null && tail == null) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
	}

	public void remove(DListNode node) {
		if (node != null) {
			// if the node has prev and next
			if (node.prev != null && node.next != null) {
				((DListNode) (node.next)).prev = node.prev;
				node.prev.next = node.next;
			} else if (node.prev != null) {
				tail = (DListNode) node.prev;
				node.prev.next = null;
			} else if (node.next != null) {
				head = (DListNode) node.next;
				((DListNode) (node.next)).prev = null;
			}
		}
	}

	public DListNode removeLast() {
		DListNode temp = tail;
		tail = (DListNode) tail.prev;
		tail.next = null;
		temp.next = null;
		temp.prev = null;
		return temp;
	}

	public DListNode getNode(int val) {
		DListNode curr = head;
		while (curr != null && curr.val != val) {
			curr = (DListNode) curr.next;
		}
		return curr;
	}

	public void print() {
		StringBuffer sb = new StringBuffer();
		sb.append("Printing from front:");
		DListNode current = head;
		while (current != null) {
			sb.append(current.val).append(", ");
			current = (DListNode) current.next;
		}
		System.out.println(sb.toString());
		sb = new StringBuffer();
		sb.append("Printing from back:");
		current = tail;
		while (current != null) {
			sb.append(current.val).append(", ");
			current = (DListNode) current.prev;
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		DLinkedList list = new DLinkedList();
		for (int i = 0; i < 5; i++) {
			list.addFirst(new DListNode(i));
		}
		list.print();
		for (int i = 5; i < 10; i++) {
			list.addLast(new DListNode(i));
		}
		list.print();
		DListNode node = list.getNode(0);
		list.remove(node);
		System.out.println("After removing 0");
		list.print();
		node = list.getNode(4);
		list.remove(node);
		System.out.println("After removing 4");
		list.print();
		node = list.getNode(9);
		list.remove(node);
		System.out.println("After removing 9");
		list.print();
		System.out.println("After removing last");
		list.removeLast();
		list.print();
	}
}
