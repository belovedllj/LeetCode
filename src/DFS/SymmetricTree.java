package DFS;

import structures.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymetricHelper(root.left, root.right);
        
    }
    private boolean isSymetricHelper(TreeNode leftSide, TreeNode rightSide) {
        if(leftSide == null && rightSide == null) return true;
        if(leftSide == null || rightSide == null) return false;
        if(leftSide.val != rightSide.val) return false;
        return isSymetricHelper(leftSide.left, rightSide.right) 
               && isSymetricHelper(leftSide.right, rightSide.left);               
    }
}
