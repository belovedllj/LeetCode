package DFS;

import structures.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode_DFS {
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode node = root;
        TreeLinkNode leftNode = node.left;
        TreeLinkNode rightNode = node.right;
        if(leftNode != null && rightNode != null) {
            leftNode.next = rightNode;
            if(node.next != null) {
                rightNode.next = node.next.left;
            }
        } else {
            return;
        }
        connect(leftNode);
        connect(rightNode);
    }
}
