package LinkedList;
import structures.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode currentNode = head;
        ListNode lastNode = currentNode;
        currentNode = currentNode.next;
        while(currentNode != null) {
            int nodeValue = currentNode.val;
            if(nodeValue == lastNode.val) {
                lastNode.next = currentNode.next;
            } else {
                lastNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return head;
    }
}
