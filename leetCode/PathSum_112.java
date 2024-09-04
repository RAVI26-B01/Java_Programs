package leetcode;

import binaryTree.Node;

/*
 Given the root of a binary tree and an integer targetSum, 
 return true if the tree has a root-to-leaf path 
 such that adding up all the values along the path equals targetSum
 */
public class PathSum_112 {
	
	 public boolean hasPathSum(Node root, int targetSum) {
	        if(root == null){  // Base case
	            return false;
	        }
	        
	        // If it's a leaf node, check if the current sum equals the targetSum
	        if (root.left == null && root.right == null) {
	            return targetSum == root.data;
	        }

	        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data); // traverse left and right
	    }
}
