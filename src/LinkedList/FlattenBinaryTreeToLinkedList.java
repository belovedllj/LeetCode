package LinkedList;
import structures.TreeNode;
// more solutions
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {  
        
        while(root != null) {
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                p.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }  
}
