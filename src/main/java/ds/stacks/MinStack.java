package ds.stacks;

import java.util.logging.Logger;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time
 * 
 * @author mallik
 * 
 */
public class MinStack {

	private static final Logger logger = Logger.getLogger(MinStack.class
			.getName());

	class Node {
		int value;
		int min;
		Node next;

		Node(int value, int min) {
			this.value = value;
			this.min = min;
			next = null;
		}
	}

	Node head;

	public void push(int x) {
		if (head == null) {
			Node temp = new Node(x, x);
			head = temp;
		} else {
			Node temp = new Node(x, Math.min(x, head.min));
			temp.next = head;
			head = temp;
		}
	}

	public void pop() {
		if (head == null) {
			return;
		}
		Node temp= head.next;
		head.next = null;
		head = temp;
	}

	public int top() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		return head.value;
	}

	public int getMin() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		return head.min;
	}
	
	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(5);
		s.push(4);
		s.push(0);
		s.push(6);
		s.push(1);
		
		logger.info("min1:" + s.getMin());
		s.pop();
		logger.info("min2:" + s.getMin());
		s.pop();
		logger.info("min3:" + s.getMin());
		s.pop();
		logger.info("min4:" + s.getMin());
	}
}
