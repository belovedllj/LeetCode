package LinkedList;
import structures.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) { 
        // http://fisherlei.blogspot.com/2012/12/leetcode-reverse-nodes-in-k-group.html
        // http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
        if (head == null || head.next == null || k < 1) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        int i = 0;
        while(head != null) {
            i++;
            if(i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }
    
    private ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}
