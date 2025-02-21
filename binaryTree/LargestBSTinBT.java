package binaryTree;

public class LargestBSTinBT {
	   
    class NodeValue {
        int maxNode, minNode, maxSize;

        // Constructor to initialize the NodeValue object
        NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
     }
    
    // Return the size of the largest sub-tree which is also a BST
     int largestBst(Node root)
    {
       return largestBSTSubtreeHelper(root).maxSize; 
    }
    
       NodeValue largestBSTSubtreeHelper(Node root) {
        // An empty tree is a BST of size 0
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from left and right subtrees of the current tree.
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        // Check if the current tree is a BST based on its left and right subtrees' properties
        if (left.maxNode < root.data && root.data < right.minNode) {
            // It is a BST, update the values for the current tree
            return new NodeValue(Math.min(root.data, left.minNode),
                    Math.max(root.data, right.maxNode), left.maxSize + right.maxSize + 1);
        }

        // If the current tree is not a BST, return values indicating invalid tree properties
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    
}
