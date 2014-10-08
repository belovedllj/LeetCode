package DFS;

import structures.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII_DFS{
	public void connect(TreeLinkNode root) {
	    if (root == null) return; // simple
	    if (root.left == null && root.right == null) return; // simple
	    TreeLinkNode last = root.right; if (last == null) last = root.left; 
	    // last means the rightest of the existing sons.
	    // first means the leftest of the sons of right brothers of the root.
	    TreeLinkNode first = root.next; 
	    while (true) {
	        if (first == null) break;
	        //as far as somne of our right brothers has children we shoudl link our last with it.
	        if (first.left != null) {
	            last.next = first.left; 
	            break;
	        }
	        if (first.right != null) {
	            last.next = first.right;
	            break;
	        }
	        first = first.next;
	    }
	    // linking our childrens if both exists
	    if (root.left != null && root.right != null) {
	        root.left.next = root.right;
	    }

	    connect(root.right);
	    connect(root.left);
	}
}
