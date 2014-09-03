package LinkedList;
import structures.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode dummyHead = new ListNode(0); 
        ListNode last = dummyHead;
        ListNode cur1 = l1, cur2 = l2;
        int carryBit = 0;
        while(cur1 != null && cur2 != null) {
            int curVal = (cur1.val + cur2.val + carryBit) % 10;
            carryBit = (cur1.val + cur2.val + carryBit) / 10;
            ListNode curNode = new ListNode(curVal);
            last.next = curNode;
            last = last.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if(cur1 != null && cur2 == null) {
            while(cur1 != null) {
                int curVal = (cur1.val + carryBit) % 10;
                carryBit = (cur1.val + carryBit) / 10;
                ListNode curNode = new ListNode(curVal);
                last.next = curNode;
                last = last.next;
                cur1 = cur1.next;
            }
        } else if (cur1 == null && cur2 != null) {
            while(cur2 != null) {
                int curVal = (cur2.val + carryBit) % 10;
                carryBit = (cur2.val + carryBit) / 10;
                ListNode curNode = new ListNode(curVal);
                last.next = curNode;
                last = last.next;
                cur2 = cur2.next;
            }
        }
        if (carryBit >= 1) {
            ListNode curNode = new ListNode(carryBit);
            last.next = curNode;
        }
        return dummyHead.next;
    }
}
