package DFS;

import structures.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }
    private TreeNode buildTreeHelper(int[] inorder, int inorderStart, int inorderEnd,
                                     int[] preorder, int preorderStart, int preorderEnd) {
        if (inorderStart > inorderEnd || preorderStart > preorderEnd) return null;
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootPosInorder = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
            	rootPosInorder = i;
            	break;
            }
        }
        
        root.left = buildTreeHelper(inorder, inorderStart, rootPosInorder - 1, 
                                    preorder, preorderStart + 1, preorderStart + rootPosInorder - inorderStart);
        root.right = buildTreeHelper(inorder, rootPosInorder + 1, inorderEnd,
                                    preorder, preorderStart + rootPosInorder - inorderStart + 1, preorderEnd);
        return root;
    }
}
