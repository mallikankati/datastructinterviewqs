package ds.lists;

import java.util.Arrays;
import java.util.List;

public class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public static ListNode create(List<Integer> list) {
		ListNode head = null;
		ListNode current = null;
		for (int i : list) {
			ListNode node = new ListNode(i);
			if (head == null) {
				head = node;
				current = head;
			} else {
				current.next = node;
				current = node;
			}
		}
		return head;
	}

	public static void print(ListNode n) {
		ListNode current = n;
		while (current != null && current.next != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		if (current == null) {
			System.out.print("{}");
		} else {
			System.out.println(current.val);
		}
	}

	public static void main(String[] args) {
		ListNode node = create(Arrays.asList(1, 2, 3, 4, 5));
		print(node);
	}
}
