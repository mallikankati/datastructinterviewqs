package ds.lists;

import java.util.Arrays;

public class SortLinkedList {
	// Sort a linked list in O(n log n) time using constant space complexity.
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode list2 = slow.next;
		slow.next = null;
		return merge(sortList(head), sortList(list2));
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}

		if (l1 != null) {
			node.next = l1;
		}
		if (l2 != null) {
			node.next = l2;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.create(Arrays.asList(1, 5, 3, 6, 2, 4));
		ListNode.print(head);
		ListNode sortedList = sortList(head);
		ListNode.print(sortedList);
	}
}
