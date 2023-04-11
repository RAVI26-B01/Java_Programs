package binaryTree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


class Node{
	int data;
	Node left,right;
}
public class BinaryTreeMainProgram {
	static int max_level=0;
	static Node root ;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("press 1 to InsertFront");
			System.out.println("press 2 to Pre-Order");
			System.out.println("press 3 to In-Order");
			System.out.println("press 4 to Post-Order");
			System.out.println("press 5 to Level-Order");
			System.out.println("press 6 to Zig_Zag-Order");
			System.out.println("press 7 to Maximun-Depth");
			System.out.println("press 10 to left view Elements");
			System.out.println();
			
			System.out.println("enter your choice");
			int choice=scan.nextInt();
				switch(choice) {
					case 1:insert();break;
					case 2:preorderTraversal(root);break;
					case 3:inorderTraversal(root);break;
					case 4:postorderTraversal(root);break;
					case 5:leverOrderTraversal(root);break;
					case 6:zigZagOrderTraversal(root);break;
					case 7:maximunDepth(root);break;
					case 10:leftView();break;
				//	case 6:ll.search();break;
					default :System.out.println("program terminated :-((");System.exit(0);
				}
			}
	}
		

		private static void insert() {
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
		
		
		private static  void leftView() {
			max_level=0;
			leftViewOfTree(root,1);
		}
		private static void leftViewOfTree(Node current, int level) {
			
			if(current==null)
				return;
			if(max_level < level){
				System.out.print(current.data+" ");
				max_level=level;
			}
			leftViewOfTree(current.left, level+1);
			leftViewOfTree(current.right, level+1);
		}
		
		private static void preorderTraversal(Node current) {
			if(current!=null){
				System.out.print(current.data+" ");
				preorderTraversal(current.left);
				preorderTraversal(current.right);
			}
		}
		
		
		private static void inorderTraversal(Node current) {
			if(current!=null){
				inorderTraversal(current.left);
				System.out.print(current.data+" ");
				inorderTraversal(current.right);
			}
		}
		
		private static void postorderTraversal(Node current) {
			if(current!=null){
				postorderTraversal(current.left);
				postorderTraversal(current.right);
				System.out.print(current.data+" ");
			}
		}
		
		private static void leverOrderTraversal(Node current) {
			Queue<Node> queue = new LinkedList<>();
			List<List<Integer>> ans = new LinkedList<List<Integer>>();
			if(current == null){
				return;
			}
			queue.offer(current);
			while(!queue.isEmpty()){
				int levelNums = queue.size();
				List<Integer> subList = new LinkedList<>();
				for( int i=0 ;i<levelNums ; i++){
					if(queue.peek().left!=null)
						queue.offer(queue.peek().left);
					if(queue.peek().right!=null)
						queue.offer(queue.peek().right);
					subList.add(queue.poll().data);
					
				}
				ans.add(subList);
			}
			System.out.println(ans);
			}
		
		private static void zigZagOrderTraversal(Node current) {
			Queue<Node> queue = new LinkedList<>();
			List<List<Integer>> ans = new LinkedList<List<Integer>>();
			if(current == null){
				return;
			}
			queue.offer(current);
			boolean leftToRight = true;
			while(!queue.isEmpty()){
				int levelNums = queue.size();
				List<Integer> subList = new LinkedList<>();
				for( int i=0 ;i<levelNums ; i++){
					if(queue.peek().left!=null)
						queue.offer(queue.peek().left);
					if(queue.peek().right!=null)
						queue.offer(queue.peek().right);
					subList.add(queue.poll().data);
					
				}
				if(!leftToRight)
					Collections.reverse(subList);
				ans.add(subList);
				leftToRight=!leftToRight;
			}
			System.out.println(ans);
			}
		

		private static void maximunDepth(Node current) {
			int max_depth = max_depth(current);
			System.out.println(max_depth);
		}


		private static int max_depth(Node current) {
			if(current==null)
				return 0;
			int l= max_depth(current.left);
			int r=max_depth(current.right);
			return 1+Math.max(l, r);
		}
}
