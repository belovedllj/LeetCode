package DFS;

import java.util.ArrayList;
import structures.TreeNode;

public class BinaryTreeInorderTraversal_Rec {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();        
        if(root == null)
        	return res;
        helper(res, root);
        return res; 
    }
	private void helper(ArrayList<Integer> res, TreeNode node) {
		if(node == null)
			return;
		helper(res, node.left);
		res.add(node.val);
		helper(res, node.right);
	}
}
