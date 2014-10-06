package MergeSort;

import java.util.List;

import structures.ListNode;

public class MergeKSortedLists_Recur {
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        return helper(lists, 0, lists.size() - 1);
    }
    private ListNode helper(List<ListNode> lists, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            return merge(helper(lists, left, mid), helper(lists, mid + 1, right));
        }
        return lists.get(left);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if(l1 != null) {
            pre.next = l1;
        } else if (l2 != null) {
            pre.next = l2; 
        }
        return dummyHead.next;
    }
}
