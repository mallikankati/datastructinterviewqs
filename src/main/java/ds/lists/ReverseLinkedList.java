package ds.lists;

import java.util.Arrays;

public class ReverseLinkedList {

	// Reverse linked list without recursion
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	// Reverse LinkedList with recursion
	public static ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reverse = reverseList1(head.next);
		head.next.next = head;
		head.next = null;
		return reverse;
	}

	public static void main(String[] args) {
		ListNode node = ListNode.create(Arrays.asList(1, 2, 3, 4));
		ListNode reverse = reverseList(node);
		ListNode.print(reverse);
		node = ListNode.create(Arrays.asList(1, 2, 3, 4));
		reverse = reverseList1(node);
		ListNode.print(reverse);
	}
}
