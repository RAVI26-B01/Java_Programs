package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import binaryTree.Node;

public class Practice {
	public List<Integer> inOrder(Node root){
		List<Integer> ans = new ArrayList<>();
		Node curr = root;
		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.data);
				curr= curr.right;
			}else {
				Node pre = curr.left;
				while(pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				if(pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				}else {
					pre.right = null;
					ans.add(curr.data);
					curr = curr.right;
				}
			}
		}
		return ans;
		
	}
}
