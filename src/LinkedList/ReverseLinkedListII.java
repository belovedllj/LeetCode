package LinkedList;
import structures.ListNode;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(-1);
        ListNode mBeforeNode = dummyHead;
        mBeforeNode.next = head;
        for (int i = 1; i < m; i++) {
            mBeforeNode = mBeforeNode.next;
        }
        ListNode mNode = mBeforeNode.next;
        ListNode mNextNode = mNode.next;
        ListNode lastNode = mNode;
        for (int i = 0; i < n - m; i++) {
            ListNode temp = mNextNode.next;
            mBeforeNode.next = mNextNode;
            mNextNode.next = mNode;
            mNode = mNextNode;
            mNextNode = temp;
            if (i == n - m - 1) lastNode.next = temp;
        }
        return dummyHead.next;
    }
}
