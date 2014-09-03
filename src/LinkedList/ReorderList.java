package LinkedList;
import structures.ListNode;

public class ReorderList {
	public void reorderList(ListNode head) {
        //http://blog.csdn.net/linhuanmars/article/details/21503215
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode head1 = head;
        head2 = reverse(head2);
        while(head1 != null && head2 != null) {
            ListNode next1 = head1.next;
            head1.next = head2;
            head1 = next1;
            ListNode next2 = head2.next;
            head2.next = head1;
            head2 = next2;
        }
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    } 
}
