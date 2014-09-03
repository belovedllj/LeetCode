package LinkedList;
import structures.ListNode;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast.next == null || fast.next.next == null)
            return null;
        slow = head;
        while (true) {
            if (slow == fast) return slow;
            slow = slow.next;
            fast = fast.next;
        }
    }
}
