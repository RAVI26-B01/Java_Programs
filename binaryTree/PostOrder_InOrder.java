package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class PostOrder_InOrder {

	public static void main(String[] args) {
		int[] inOrder = {40, 20, 50, 10, 60, 30};
		int[] postOrder = {40, 50, 20, 60, 30, 10};
		
		Node tree = buildTree(inOrder, postOrder);
		TreePrinter.printNode(tree);
		
//		int[] inOrder2 = {9, 3, 15, 20 ,7};
//		int[] preOrder2 = {3, 9, 20, 15, 7};
//		
//		Node tree2 = buildTree(inOrder2, preOrder2);
//		TreePrinter.printNode(tree2);
		
	}

	private static Node buildTree(int[] inOrder, int[] postOrder) {
		Map<Integer, Integer> inMap= new HashMap<>();
		for(int i = 0 ; i <inOrder.length; i++) {
			inMap.put(inOrder[i], i);
		}
		
		Node root = buildTree(postOrder, 0, postOrder.length-1,
				  inOrder, 0, inOrder.length-1, inMap);
		return root;
	}

	private static Node buildTree(int[] postOrder, int postStart, int postEnd,
								  int[] inOrder, int inStart, int inEnd,
								  Map<Integer, Integer> inMap) {

		if(postStart > postEnd || inStart > inEnd)
			return null;
		Node root = new Node(postOrder[postEnd]);
		int rootIndex = inMap.get(root.data);
		int numLeft = rootIndex- inStart;
		
		root.left = buildTree(postOrder, postStart, postStart + numLeft-1,
				inOrder, inStart, rootIndex-1 , inMap);
		root.right = buildTree(postOrder, postStart+numLeft, postEnd-1,
			  inOrder, rootIndex+1, inEnd, inMap);

		return root;

	}

}
