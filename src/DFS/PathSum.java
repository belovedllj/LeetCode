package DFS;

import structures.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int depth = depth(root);
        int[] path = new int[depth];
        return helper(root, sum, path, 0);
    }
    private int depth(TreeNode node) {
    	if (node == null) return 0;
    	return 1 + Math.max(depth(node.left), depth(node.right));
    }    
    private boolean helper(TreeNode node, int sum, int[] path, int level){
    	path[level] = node.val;
    	if (node.left == null && node.right == null) { // here is the leaf node
    	    return checkIsSumEqual(sum, path, level);
    	} else if (node.left == null) {
    	    return helper(node.right, sum, path, level + 1);
    	} else if (node.right == null) {
    	    return helper(node.left, sum, path, level + 1);
    	} else {
    	    return helper(node.left, sum, path, level + 1) ||
    			helper(node.right, sum, path, level + 1);
    	}
    }
    private boolean checkIsSumEqual(int sum, int[] path, int level) {
    	int pathSum = 0;
    	for (int i = level; i >=0; i--) {
    		pathSum += path[i];
    	}
    	if (pathSum == sum) return true;
    	return false;
    }        
}
