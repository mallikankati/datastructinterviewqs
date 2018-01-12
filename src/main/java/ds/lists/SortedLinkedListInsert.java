package ds.lists;

import java.util.Arrays;

public class SortedLinkedListInsert {

	// Assume it's a sorted list and insert item in ascending order.
	public static void sortedInsert(ListNode head, ListNode newNode) {
		ListNode current = null;
		if (head == null || head.val >= newNode.val) {
			newNode.next = head;
			head = newNode;
		} else {
			current = head;
			while (current != null && current.next != null
					&& current.next.val < newNode.val) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = ListNode.create(Arrays.asList(1, 2, 4, 5));
		ListNode newNode = new ListNode(3);
		sortedInsert(head, newNode);
		ListNode.print(head);
	}
}
