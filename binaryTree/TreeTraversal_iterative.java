package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

	/*
	 * LVR
	 * move to extreme left 
	 * when no element is found print the element and move right
	 */
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

	/*
	 * Iterative post-OrderTraversal using two stack
	 */
	public List<Integer> postOrderTraversal(Node curr) {
		List<Integer> ans = new ArrayList<>();
		if(curr == null)
			return ans;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(curr);
		while(!s1.isEmpty()) {
			Node node = s1.pop();
			s2.push(node);
			if(node.left !=null)
				s1.push(node.left);
			if(node.right != null)
				s1.push(node.right);
		}
		
		while(!s2.isEmpty()) {
			ans.add(s2.pop().data);
		}
		return ans;
	}

	/*
	 * Iterative post-OrderTraversal using one stack
	 */
	 public List<Integer> postOrderItrOneStack(Node root){
		 List<Integer> ans = new ArrayList<>();
			if(root == null)
				return ans;
	        Node current = root;
	        Deque<Node> stack = new LinkedList<>();
	        while(current != null || !stack.isEmpty()){
	            if(current != null){
	                stack.addFirst(current);
	                current = current.left;
	            }else{
	                Node temp = stack.peek().right;
	                if (temp == null) {
	                    temp = stack.poll();
	                    ans.add(temp.data);
	                    while (!stack.isEmpty() && temp == stack.peek().right) {
	                        temp = stack.poll();
	                       ans.add(temp.data);
	                    }
	                } else {
	                    current = temp;
	                }
	            }
	        }
	        return ans;
	    }
	
}
