package binaryTree;

public class SuccessorPredecessor {

	public Node inOrderSuccessor(Node root, Node p) {
		Node successor = null;
		while(root != null) {
			if(p.data >= root.data) {
				root = root.right;
			}else{
				successor = root;
				root = root.left;
			}
		}
		return successor;
	}
	
	public Node inOrderPredecessor(Node root, Node p) {
		Node predecessor = null;
		while(root != null) {
			if(p.data >= root.data) {
				predecessor = root;
				root = root.right;
			}else{
				root = root.left;
			}
		}
		return predecessor;
	}
}
