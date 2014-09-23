package DFS;

import structures.TreeNode;

//other solution in LeetCode (private int helper())
public class SumRootToLeafNumbers {
	int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumHelper(root, "");
        return sum;
    }
    
    private void sumHelper(TreeNode node, String str) {
        String temp = str + node.val;
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(temp);
        } else {
            if (node.left != null) 
               sumHelper(node.left, temp);
            if (node.right != null) 
               sumHelper(node.right, temp);
        }
    }
}
