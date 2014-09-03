package LinkedList;
import structures.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        ListNode findLastNode = head;
        int listLen = 1;
        while(findLastNode.next != null) {
            listLen++;
            findLastNode = findLastNode.next;
        }
        
        n = n % listLen; //module
        if(n == 0) return head; // no move
        int moveStep = listLen - n;
        
        ListNode newTail = null;
        // 1,2,3,4,5,6,7  moveStep = 5; newTail = 5, new head = 6;
        ListNode newHead = head;
        for(int i = 0; i < moveStep; i++) {
            newTail = newHead;
            newHead = newHead.next;
        }
        newTail.next = null;
        findLastNode.next = head;
        return newHead;
    }
}
