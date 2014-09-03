package LinkedList;
import structures.ListNode;


public class SortList {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = head;
        head1 = sortList(head1);
        head2 = sortList(head2);
        return mergeTwoLists(head1, head2);
        
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
             } else {
                 pre.next = l2;
                 l2 = l2.next;
             }
             pre = pre.next;
        }
        if(l1 == null) 
            pre.next = l2;
        else
            pre.next = l1;
        return dummy.next;
    }
}

