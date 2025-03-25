package binaryTree;

public class FlattenBTtoLinkedList {

	//approach-1
	Node prev = null;
	public void flatternTree1(Node root){
		if(root == null) return;
		flatternTree1(root.right);
		flatternTree1(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}
