package DFS;

import structures.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTreeHelper(int[] inorder, int inorderStart, int inorderEnd,
                                     int[] postorder, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) return null;
        int rootVal = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int rootPosInorder = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
            	rootPosInorder = i;
            	break;
            }            	
        }
        
        root.left = buildTreeHelper(inorder, inorderStart, rootPosInorder - 1, 
                                    postorder, postorderStart, postorderStart + rootPosInorder - inorderStart - 1);
        root.right = buildTreeHelper(inorder, rootPosInorder + 1, inorderEnd,
                                    postorder, postorderStart + rootPosInorder - inorderStart, postorderEnd - 1);
        return root;
    }
}
