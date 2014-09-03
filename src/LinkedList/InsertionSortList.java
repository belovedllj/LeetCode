package LinkedList;
import structures.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curNode = head.next;
        while(curNode != null) {
            ListNode insertedPos = dummyHead;
            ListNode afterInsertedPos = dummyHead.next;
            while (true) {
                if (curNode == afterInsertedPos) { // same Node
                    curNode = curNode.next;
                    break;
                }
                if (curNode.val < afterInsertedPos.val) { // insertion
                    insertedPos.next = curNode;
                    ListNode tempCurNext = curNode.next;
                    curNode.next = afterInsertedPos;
                    
                    while (afterInsertedPos.next != curNode) {
                        afterInsertedPos = afterInsertedPos.next; // find the end of current to avoid loop
                    }
                    afterInsertedPos.next = tempCurNext;
                    /*
                     * [2, 3, 1] or [2, 1] with out this codes, there may generated a loop
                     * must make 3.next to null(1.next// curNode)
                     */
                    curNode = tempCurNext;
                    break;
                } else {
                    insertedPos = afterInsertedPos;
                    afterInsertedPos = afterInsertedPos.next;
                }
            }
        }
        return dummyHead.next;
    }
}
