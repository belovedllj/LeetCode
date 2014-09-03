package LinkedList;
import structures.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode secondNode = head.next;
        ListNode thirdNode = secondNode.next;
        secondNode.next = head;
        head.next = thirdNode;
        ListNode currentNode = thirdNode;
        ListNode lastNode = head;
         while (currentNode != null && currentNode.next != null) {
            ListNode nextNode = currentNode.next;
            ListNode holdingNode = nextNode.next;
            lastNode.next = nextNode;
            nextNode.next = currentNode;
            currentNode.next = holdingNode;
            lastNode = currentNode;
            currentNode = holdingNode;
        }
        return secondNode;
    }
}
