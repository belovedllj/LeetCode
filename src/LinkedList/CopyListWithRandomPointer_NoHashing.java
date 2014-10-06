package LinkedList;

import structures.RandomListNode;

// Three loops
public class CopyListWithRandomPointer_NoHashing {
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode curCopy = new RandomListNode(cur.label);
            curCopy.next = cur.next;
            cur.next = curCopy;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null) {
            if(cur.random == null)
                cur.next.random = null;
            else 
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode headCopy = head.next;
        while(cur != null) {
            RandomListNode curCopy = cur.next;
            cur.next = curCopy.next;
            if(cur.next != null) 
                curCopy.next = cur.next.next;
            cur = cur.next;
        }
        return headCopy;
    }
}
