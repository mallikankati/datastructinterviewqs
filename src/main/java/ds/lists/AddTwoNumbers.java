package ds.lists;

import java.util.Arrays;

public class AddTwoNumbers {

	/**
	 * The digits are stored in reverse order
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342
	 * + 465 = 807.
	 */
	public static ListNode addTwoNumbers(ListNode n1, ListNode n2) {
		ListNode result = new ListNode(0);
		ListNode p = n1, q = n2, curr = result;
		int carry = 0;
		while (p != null || q != null) {
			int val1 = p != null ? p.val : 0;
			int val2 = q != null ? q.val : 0;
			int sum = carry + val1 + val2;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return result.next;
	}

	public static void main(String[] args) {
		ListNode n1 = ListNode.create(Arrays.asList(2, 4, 3));
		ListNode n2 = ListNode.create(Arrays.asList(5, 6, 4));
		ListNode res = addTwoNumbers(n1, n2);
		ListNode.print(res);
	}
}
