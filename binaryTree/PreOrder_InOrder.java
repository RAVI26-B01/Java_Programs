package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class PreOrder_InOrder {
	public static void main(String[] args) {
		int[] inOrder = {40, 20, 50, 10, 60, 30};
		int[] preOrder = {10, 20, 40, 50, 30, 60};
		
		Node tree = buildTree(inOrder, preOrder);
		TreePrinter.printNode(tree);
		
		int[] inOrder2 = {9, 3, 15, 20 ,7};
		int[] preOrder2 = {3, 9, 20, 15, 7};
		
		Node tree2 = buildTree(inOrder2, preOrder2);
		TreePrinter.printNode(tree2);
		
	}

	private static Node buildTree(int[] inOrder, int[] preOrder) {
		Map<Integer, Integer> inMap= new HashMap<>();
		for(int i = 0 ; i <inOrder.length; i++) {
			inMap.put(inOrder[i], i);
		}
		
		Node root = buildTree(preOrder, 0, preOrder.length-1,
				  inOrder, 0, inOrder.length-1, inMap);
		return root;
	}

	private static Node buildTree(int[] preOrder, int preStart, int preEnd,
								  int[] inOrder, int inStart, int inEnd,
								  Map<Integer, Integer> inMap) {
		if(preStart > preEnd || inStart > inEnd)
			return null;
		Node root = new Node(preOrder[preStart]);
		int rootIndex = inMap.get(root.data);
		int numLeft = rootIndex- inStart;
		
		root.left = buildTree(preOrder, preStart+1, preStart + numLeft,
								inOrder, inStart, rootIndex-1 , inMap);
		root.right = buildTree(preOrder, preStart+numLeft+1, preEnd,
							  inOrder, rootIndex+1, inEnd, inMap);
		
		return root;
		
	}
}
