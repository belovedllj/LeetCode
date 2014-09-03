package LinkedList;
import structures.ListNode;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) { // already touch the null end
            return head.next;
        }
        slow = slow.next;
        fast = fast.next;
        // no loop and n must be less than size of linkedList
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            prev = prev.next;
        } 
        prev.next = slow.next;
        
        return head;
    }
}
