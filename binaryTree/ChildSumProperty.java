package binaryTree;

/*
🥥 if both children sum is less than parent, make children's value to parent's value.
🥥 if both children values sum is greater than or equal to parent,
   make parent's value to children's sum.
🥥 recursively go left and right. Traversal type: DFS.
🥥 when coming back up the tree, take children sum and replace it in parent.
🥥 at any point we reach null, just return (base case)
🥥 Intuition: while going down,
 	increase the children values so we make sure to never fall short, 
	then all we have to do is sum both children and replace it in parent.
 */
public class ChildSumProperty {

	public void childSum(Node root) {
        if (root == null) {
            return;
        }

        // Calculate the sum of the values of left and right children
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }

        if (child < root.data) {
            // If the sum is smaller, update the
            // child with the current node's value.
            if (root.left != null) {
                root.left.data = root.data;
            }
            if (root.right != null) {
                root.right.data = root.data;
            }
        }

        childSum(root.left);
        childSum(root.right);

        // coming back starts
        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        int tot = 0;
        if (root.left != null) {
            tot += root.left.data;
        }
        if (root.right != null) {
            tot += root.right.data;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if (root.left != null || root.right != null) {
            root.data = tot;
        }
    }
}
