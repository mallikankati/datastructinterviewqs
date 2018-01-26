package ds.lists;

public class DListNode extends ListNode {
	//This is only CACHE implementation purpose;
	String key;
	ListNode prev;

	public DListNode(int val) {
		super(val);
		this.next = null;
		this.prev = null;
	}
}
