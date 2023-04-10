package binaryTree;

import java.util.Scanner;


class Node{
	int data;
	Node left,right;
}
public class BinaryTreeMainProgram {

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("press 1 to InsertFront");
			System.out.println("press 2 to Pre-Order");
			System.out.println("press 3 to In-Order");
			System.out.println("press 4 to Post-Order");
			
			System.out.println("enter your choice");
			int choice=scan.nextInt();
				switch(choice) {
					case 1:bt.insert();break;
					case 2:bt.pre_order();break;
					case 3:bt.in_order();break;
					case 4:bt.post_order();break;
				//	case 6:ll.search();break;
					default :System.out.println("program terminated :-((");System.exit(0);
				}
			}
		
	}

}

class BinaryTree{
	Node root;
	public void insert() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter item to insert :");
		int item=scan.nextInt();
		Node node=new Node();
		node.left=null;
		node.data=item;
		node.right=null;
		
		Node current,previous;
		if(root == null){
			root=node;
		}else{
			previous=null;
			current=root;
			while(current!=null){
				if(node.data<current.data){
					previous=current;
					current=current.left;
				}
				else{
					previous=current;
					current=current.right;
				}
			}
			if(node.data<previous.data){
				previous.left=node;
			}
			else{
				previous.right=node;
			}
		}
		
	}
	public void pre_order() {
		preorderTraversal(root);
	}
	private void preorderTraversal(Node current) {
		if(current!=null){
			System.out.print(current.data+" ");
			preorderTraversal(current.left);
			preorderTraversal(current.right);
		}
	}
	
	public void in_order() {
		inorderTraversal(root);
	}
	private void inorderTraversal(Node current) {
		if(current!=null){
			inorderTraversal(current.left);
			System.out.print(current.data+" ");
			inorderTraversal(current.right);
		}
	}
	public void post_order() {
		postorderTraversal(root);
	}
	private void postorderTraversal(Node current) {
		if(current!=null){
			postorderTraversal(current.left);
			postorderTraversal(current.right);
			System.out.print(current.data+" ");
		}
	}
	
}
