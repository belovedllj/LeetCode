package BFS;

import structures.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode_BFS {
	public void connect(TreeLinkNode root) {
		TreeLinkNode leftMostNode = root;
	    while (leftMostNode != null) {
	        TreeLinkNode accrossNode = leftMostNode;
	        while(accrossNode != null) {
	            if (accrossNode.left != null) {
	                accrossNode.left.next = accrossNode.right;
	                if(accrossNode.next != null) {
	                    accrossNode.right.next = accrossNode.next.left;
	                }
	            }
	            accrossNode = accrossNode.next;
	        }
	        leftMostNode = leftMostNode.left;
	    }
	}
}
