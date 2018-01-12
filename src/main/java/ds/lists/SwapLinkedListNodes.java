package ds.lists;

import java.util.Arrays;

public class SwapLinkedListNodes {

	// Assume that there is no duplicates and swap the nodes in LinkedList
	// TODO: This logic requires revisit. Below test case is failing
	public static ListNode swapNode(ListNode head, int x, int y) {
		if (x == y) {
			return head;
		}
		ListNode prevX = null, currX = head;
		while (currX != null && currX.val != x) {
			prevX = currX;
			currX = currX.next;
		}
		ListNode prevY = null, currY = head;
		while (currY != null && currY.val != y) {
			prevY = currY;
			currY = currY.next;
		}
		if (currX == null || currY == null || currX.val == currY.val) {
			return head;
		}
		if (prevX == null && currX.val == x) {
			ListNode temp = currX;
			currX.next = currY.next;
			currY.next = temp;
			head = currY;
			return head;
		}
		if (prevY == null && currY.val == y) {
			ListNode temp = currY;
			currY.next = currX.next;
			currX.next = temp;
			head = currX;
			return head;
		}
		if (prevX != null) {
			prevX.next = currY;
		} else {
			head = currY;
		}
		if (prevY != null) {
			prevY.next = currX;
		} else {
			head = currX;
		}
		ListNode stemp = currX.next;
		currX.next = currY.next;
		currY.next = stemp;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = ListNode.create(Arrays.asList(1, 2, 4, 5));

		ListNode temp = swapNode(head, 2, 4);
		ListNode.print(temp);
		temp = swapNode(head, 4, 2);
		ListNode.print(temp);

		temp = swapNode(head, 1, 2);
		ListNode.print(temp);
		temp = swapNode(temp, 1, 2);
		ListNode.print(temp);
	}
}
