package binaryTree;

import java.util.ArrayList;
import java.util.Collections;


public class BoundaryTraversal {

	public ArrayList<Integer> PrintBoundary(Node node){
		ArrayList<Integer> ans = new ArrayList<>();
		if(!isLeaf(node))
			ans.add(node.data);
		addLeftBoundary(node,ans);
		addleaves(node,ans);
		addRightBoundary(node,ans);
		return ans;
		
	}

	private void addleaves(Node node, ArrayList<Integer> ans) {
		if(isLeaf(node)){
			ans.add(node.data);
		}
		if(node.left!=null){
			addleaves(node.left,ans);
		}
		if(node.right!=null){
			addleaves(node.right,ans);
		}
	}

	private void addRightBoundary(Node node, ArrayList<Integer> ans) {
		Node cur = node.right;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		while(cur!=null){
			if(!isLeaf(cur)){
				temp.add(cur.data);
			}
			if(cur.right!=null)
				cur=cur.right;
			else
				cur=cur.left;
		}
		Collections.reverse(temp);
		ans.addAll(temp);
	}	
	
	private void addLeftBoundary(Node node, ArrayList<Integer> ans) {
		Node cur = node.left;
		while(cur!=null){
			if(!isLeaf(cur)){
				ans.add(cur.data);
			}
			if(cur.left!=null)
				cur=cur.left;
			else
				cur=cur.right;
		}
	}	

	private boolean isLeaf(Node node) {
		return (node.left == null && node.right == null);
	}
}
