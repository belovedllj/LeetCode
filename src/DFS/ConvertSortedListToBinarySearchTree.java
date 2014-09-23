package DFS;

import structures.ListNode;
import structures.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	private ListNode curListNode = null;
    public TreeNode sortedListToBST(ListNode head) { // until reach the leaf create the first one
        int length = 0;
        ListNode node = head;
        for (; node != null; node = node.next) {
            length++;
        }
        curListNode = head;
        return helper(0, length - 1);
    }
    
    private TreeNode helper(int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        TreeNode leftNode = helper(low, mid - 1);
        TreeNode parentTreeNode = new TreeNode(curListNode.val);
        parentTreeNode.left = leftNode;
        curListNode = curListNode.next;
        parentTreeNode.right = helper(mid + 1, high);
        return parentTreeNode;
    }
}
