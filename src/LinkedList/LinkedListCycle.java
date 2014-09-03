package LinkedList;
import structures.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            if(slow.next == null) return false;
            slow = slow.next;
            if(fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            if(slow == fast) return true;
            
        }        
    }
}
