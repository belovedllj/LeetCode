package DFS;

import structures.TreeNode;

public class BinaryTreeMaximumPathSum {
	int max;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = root.val;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        max = Math.max(max, node.val + left + right);
        return node.val + Math.max(left, right); // only one side count for return        
    }
}
