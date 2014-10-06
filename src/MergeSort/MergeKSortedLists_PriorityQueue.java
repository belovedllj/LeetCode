package MergeSort;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import structures.ListNode;

public class MergeKSortedLists_PriorityQueue {
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
        		lists.size(), new Comparator<ListNode>() {
					@Override
					public int compare(ListNode arg0, ListNode arg1) {
						return arg0.val - arg1.val;
					}        			
        		});
        for(ListNode node : lists) {
            if(node != null)
            	queue.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(queue.size() > 0) {
        	ListNode curSmall = queue.poll();
        	pre.next = curSmall;
        	if(curSmall.next != null) {
        		queue.add(curSmall.next);
        	}
        	pre = pre.next;
        }
        return dummy.next;
    }
}
