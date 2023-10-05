package leetcode;

import binaryTree.Node;
/*
 * 1038. Binary Search Tree to Greater Sum Tree
 * 
 * RVL rule
 * original key plus the sum of all keys greater than the original key in BST.
 */
public class BSTtoGST_1038 {
	int ans =0;
	public Node convertBSTtoGST(Node root) {
		
		if (root != null) {
			convertBSTtoGST(root.right);
            ans += root.data;
            root.data = ans;
            convertBSTtoGST(root.left);
        }
		return root;
		
	}

	
}
