package DFS;

import structures.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) 
            return false;
        else return true;
    }
    
    private int checkHeight(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1) return -1;
        // check current balance
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else 
            return Math.max(leftHeight, rightHeight) + 1;
    }
}
