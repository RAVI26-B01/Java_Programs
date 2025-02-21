package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTravel {

	/*
	 In-order Morris Traversal:
	🌳 1st case: if left is null, print current node and go right
	🌳 2nd case: before going left, make right most node on left subtree
	 			 connected to current node, then go left
	🌳 3rd case: if thread is already pointed to current node, then remove the thread
	 */
	public List<Integer> inOrder(Node root){
		List<Integer> ans = new ArrayList<>();
		Node curr = root;
		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.data);
				curr=curr.right;
			}
			else {
				Node prev = curr.left;
				while(prev.right!=null && prev.right != curr) {
					prev = prev.right;
				}
				
				if(prev.right == null) {
					prev.right = curr;
					curr=curr.left;
				}else {
					prev.right=null;
					ans.add(curr.data);
					curr=curr.right;
				}
			}
		}
		
		return ans;
	}
	
	public List<Integer> preOrder(Node root){
		List<Integer> ans = new ArrayList<>();
		Node curr = root;
		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.data);
				curr=curr.right;
			}
			else {
				Node prev = curr.left;
				while(prev.right!=null && prev.right != curr) {
					prev = prev.right;
				}
				if(prev.right == null) {
					prev.right = curr;
					ans.add(curr.data);
					curr=curr.left;
				}else {
					prev.right=null;
					curr=curr.right;
				}
			}
		}
		
		return ans;
	}
}
