package ds.lists;

import java.util.Arrays;

public class IntersectionOfTwoLinkedLists {

	// Write a program to find the node at which the intersection of two singly
	// linked lists begins.

	// Notes:
	// If the two linked lists have no intersection at all, return null.
	// The linked lists must retain their original structure after the function
	// returns.
	// You may assume there are no cycles anywhere in the entire linked
	// structure.
	// Your code should preferably run in O(n) time and use only O(1) memory.

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a.next;
			b = b.next;
			if (a == b)
				return a;
			if (a == null)
				a = headB;
			if (b == null)
				b = headA;
		}
		return a;
	}

	public static void main(String[] args) {
		ListNode headA = ListNode.create(Arrays.asList(2, 3, 4, 5, 6));
		ListNode headB = ListNode.create(Arrays.asList(7, 8, 4, 5, 6));
		ListNode intersect = getIntersectionNode(headA, headB);
		ListNode.print(intersect);
	}
}
