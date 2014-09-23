package DFS;

import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        int depth = depth(root);
        int[] path = new int[depth];
        helper(root, sum, path, res, 0);
        return res;
    }
	
	private int depth(TreeNode node) {
	    if (node == null) return 0;
	    return 1 + Math.max(depth(node.left), depth(node.right));
	}    
	private void helper(TreeNode node, int sum, int[] path, List<List<Integer>> res, int level) {
	    if(node == null)
	    	return;
	    path[level] = node.val;
	    if (node.left == null && node.right == null) { // here is the leaf node
	        checkIsSumEqual(sum, path, res,level);
	    } else {
	   	    helper(node.left, sum, path, res, level + 1);
	   	    helper(node.right, sum, path, res, level + 1);
	   	}			
	}
	    
	private void checkIsSumEqual(int sum, int[] path, List<List<Integer>> res, int level) {
	    int pathSum = 0;
	   	for (int i = level; i >=0; i--)
	   		pathSum += path[i];
	    	
	   	if (pathSum == sum) {
	   		ArrayList<Integer> list = new ArrayList<Integer>();
	   		for (int i = 0; i <= level; i++)
	   			list.add(path[i]);
	   		res.add(list);	    		
	   	}	    		
	}        
}
