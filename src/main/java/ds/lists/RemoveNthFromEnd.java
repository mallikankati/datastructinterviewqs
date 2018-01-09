package ds.lists;

import java.util.Arrays;

public class RemoveNthFromEnd {
	// Given a linked list, remove the nth node from the end of list and return
	// its head.
	// Do it in one pass
	// Ex: list: 1->2->3->4->5, and n = 2. out: 1->2->3->5
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = head;
		ListNode first = dummy, second = dummy;
		for (int i = 0; i<= n; i++){
			first = first.next;
		}
		while (first != null){
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy;
	}
	
	public static void main(String[] args) {
		ListNode node = ListNode.create(Arrays.asList(1, 2, 3, 4, 5));
		ListNode.print(node);
		node = removeNthFromEnd(node, 4);
		ListNode.print(node);
		node = ListNode.create(Arrays.asList(1));
		ListNode.print(node);
		node = removeNthFromEnd(node, 1);
		ListNode.print(node);
	}
}
