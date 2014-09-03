package LinkedList;
import structures.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummyHeadSmaller = new ListNode(-1);
        ListNode dummyHeadLarger = new ListNode(-1);
        ListNode smaller = dummyHeadSmaller;
        ListNode larger = dummyHeadLarger;
        if (head.val < x) {
            smaller.next = head;
            smaller = smaller.next;
        } else {
            larger.next = head;
            larger = larger.next;
        }
        while (head.next != null) {
            head = head.next;
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
        }
        if (dummyHeadLarger.next != null) {
            smaller.next = dummyHeadLarger.next;
            larger.next = null;
        } else {
            smaller.next = null;
        }
        return dummyHeadSmaller.next;
    }
}
