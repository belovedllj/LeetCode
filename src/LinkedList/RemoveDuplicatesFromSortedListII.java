package LinkedList;
import structures.ListNode;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode first = dummyHead;
        while (first.next != null) {
            ListNode sec = first.next;
            while(sec.next != null && sec.next.val == sec.val) {
                sec = sec.next;
            }
            if (sec != first.next) {
                first.next = sec.next; // has duplicate, first doesn't change
            } else {
                first = first.next; //no duplicate move first to next
            }
        }
        return dummyHead.next;
    }
}
