package DFS;

import structures.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
    	if(num == null || num.length < 1) return null;
        return createBST(num, 0, num.length - 1);
    }
    private TreeNode createBST(int[] num, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = createBST(num, start, mid - 1);
        node.right = createBST(num, mid + 1, end);
        return node;
    }
}
