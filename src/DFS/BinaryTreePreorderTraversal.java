package DFS;

import java.util.ArrayList;
import java.util.Stack;

import structures.TreeNode;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode top = root;
		stack.push(null);
		while(top != null) {
			res.add(top.val);
			if(top.right != null)
				stack.push(top.right);
			if(top.left != null)
				stack.push(top.left);
			top = stack.pop();
		}
		return res;
	}
}
