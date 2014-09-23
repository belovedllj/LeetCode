package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import structures.TreeNode;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode top = root;
		TreeNode lastNodeVisited = null;
		while(!stack.isEmpty() || top != null) {
			if(top != null) {
				stack.push(top);
				top = top.left;
			} else {
				TreeNode parent = stack.peek();
				if(parent.right != null && parent.right != lastNodeVisited) 
					top = parent.right;
				else {
					stack.pop();
					res.add(parent.val);
					lastNodeVisited = parent;
				}					
			}
		}
		return res;
    }
}
