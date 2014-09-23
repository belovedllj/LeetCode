package DFS;

import java.util.ArrayList;
import java.util.Stack;

import structures.TreeNode;

public class BinaryTreeInorderTraversal_NonRec {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode top = root;
		while(!stack.isEmpty() || top != null) {
			if(top != null) {
				stack.push(top);
				top = top.left;
			} else {
				top = stack.pop();
				res.add(top.val);
				top = top.right;
			}
		}
		return res;
	}
}
