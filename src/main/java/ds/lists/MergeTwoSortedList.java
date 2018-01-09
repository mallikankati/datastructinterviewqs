package ds.lists;

import java.util.Arrays;

public class MergeTwoSortedList {

	// Merge two sorted linked lists and return it as a new list.
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res = null;
		ListNode current = null;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				if (res == null) {
					res = l1;
					current = res;
				} else {
					current.next = l1;
					current = l1;
				}
				l1 = l1.next;
			} else {
				if (res == null) {
					res = l2;
					current = res;
				} else {
					current.next = l2;
					current = l2;
				}
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			if (res == null) {
				res = l1;
				current = res;
			} else {
				current.next = l1;
			}
		}
		if (l2 != null) {
			if (res == null) {
				res = l2;
				current = res;
			} else {
				current.next = l2;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ListNode l1 = ListNode.create(Arrays.asList(1, 2, 4));
		ListNode l2 = ListNode.create(Arrays.asList(1, 3, 4));
		ListNode merged = mergeTwoLists(l1, l2);
		ListNode.print(merged);
	}
}
