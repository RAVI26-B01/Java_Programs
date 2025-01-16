package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal_iterative {

	/*
	 * Pre-Order Traversal VLR
	 * Using Stack it follows LIFO
	 * So, we have to push right node first inside the stack
	 * so that left node will be accessed before right node.
	 * 
	 */
	public List<Integer> preOrderTraversal(Node current) {
		List<Integer> ans = new ArrayList<>();
		if(current == null)
			return ans;
		Stack<Node> stack = new Stack<>();
		stack.push(current);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			ans.add(node.data);
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				stack.push(node.left);
			}
		}
		return ans;
	}

	public List<Integer> inOrderTraversal(Node curr) {

		List<Integer> ans = new ArrayList<>();
		if(curr == null)
			return ans;
		Stack<Node> s = new Stack<>();
        while (curr != null || !s.isEmpty()) {

            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            ans.add(curr.data);
            curr = curr.right;
        }

		return ans;
	}

	
}
