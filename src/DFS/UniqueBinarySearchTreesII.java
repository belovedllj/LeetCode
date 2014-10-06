package DFS;

import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> subTrees = new ArrayList<TreeNode>();
        if (left > right) {
            subTrees.add(null);
        } else {
            for (int i = left; i <= right; i++) {
                List<TreeNode> leftTrees = helper(left, i - 1);
                List<TreeNode> rightTrees = helper(i + 1, right);
                for (TreeNode leftNode : leftTrees) {
                    for (TreeNode rightNode : rightTrees) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftNode;
                        node.right = rightNode;
                        subTrees.add(node);
                    }
                }
            }
        }
        return subTrees;
    }
}
