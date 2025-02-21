package binaryTree;

import java.util.Scanner;

public class DeleteNode {

	//approach - 1
	public Node delete1(Node root) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter element to delete : ");
		int del = scan.nextInt();
		System.out.println();
		if(root == null)
			return root;
		if(root.data ==del )
			return healper(root);
		Node curr = root;
		while(root != null) {
			if(root.data > del) {
				if(root.left.data == del) {
					root.left = healper(root.left);
					break;
				}else
				{
					root= root.left;
				}
			}else {
				if(root.right.data == del) {
					root.right = healper(root.right);
					break;
				}else {
					root= root.right;
				}
			}
		}
		return curr;
		
	}

	private Node healper(Node root) {
		if(root.left == null)
			return root.right;
		else if(root.right == null)
			return root.left;
		
		Node rootRight = root.right;
		Node lastRight = findLastNode(root.left);
		lastRight.right = rootRight;
		return root.left;
	}

	private Node findLastNode(Node node) {
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
}
