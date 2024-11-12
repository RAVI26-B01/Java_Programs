package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import binaryTree.Node;

public class Demo2 {
	static Node root;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("press 1 to Insert");
			System.out.println("press 2 to level order");
			System.out.println("press 3 to max depth");
			System.out.println("press 4 to left view");
			System.out.println("press 5 to top view");
			int choice=scan.nextInt();
			switch(choice) {
				case 1:insert();break;
				case 2:level_order();break;
				case 3:max_depth();break;
				case 4:leftView();break;
				case 5:topView();break;
				case 6:boundry();break;
				case 7:pathSum();break;
				default:break;
			}
		}
	}
	
	
	
	private static void pathSum() {
		Node temp = root;
		boolean hasPathSum = hasPathSum(temp, 25);
		System.out.println(hasPathSum);
		
	}
	
	public static boolean hasPathSum(Node root, int targetSum) {
        if(root == null)
            return false;
       
    	targetSum = targetSum - root.data;
        if( 0 == targetSum)
            return true;
       
        boolean hasPathSum = hasPathSum(root.left, targetSum);
        boolean hasPathSum2 = hasPathSum(root.right, targetSum);
		return hasPathSum || hasPathSum2;
    }



	private static void boundry() {
		ArrayList<Integer> ans = new ArrayList<>();
		if(!isLeaf(root))
			ans.add(root.data); // root node will be pushed first
		addLeftBoundary(root,ans);
		addleaves(root,ans);
		addRightBoundary(root,ans);
		System.out.println(ans);
	}

	private static void addleaves(Node node, ArrayList<Integer> ans) {
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

	private static void addRightBoundary(Node root, ArrayList<Integer> ans) {
		Node root2 = root.right;
		while(root2 !=null) {
			if(!isLeaf(root2)) {
				ans.add(root2.data);
			}
			if(root2.right!=null) {
				root2=root2.right;
			}else  {
				root2=root2.left;
			}
		}
	}



	private static void addLeftBoundary(Node root, ArrayList<Integer> ans) {
		Node root2 = root.left;
		while(root2 !=null) {
			if(!isLeaf(root2)) {
				ans.add(root2.data);
			}
			if(root2.left!=null) {
				root2=root2.left;
			}else  {
				root2=root2.right;
				
			}
		}
		
	}



	private static boolean isLeaf(Node root2) {
		if(root2.left == null && root2.right ==null)
			return true;
		return false;
	}



	private static void topView() {
		Queue<pair> queue = new LinkedList<>();
		
		if(root == null) {
			return;
		}
		else {
			Map<Integer,Integer> map = new TreeMap<>();
			queue.add(new pair(root,0));
			while(!queue.isEmpty()) {
				pair pair = queue.poll();
				Node node = pair.node;
				int i = pair.i;
				
				if(!map.containsKey(i)) {
					map.put(i, node.data);
				}
				
				if(pair.node.left!=null) {
					queue.offer(new pair(pair.node.left,i-1));
				}
				if(pair.node.right!=null) {
					queue.offer(new pair(pair.node.right,i+1));
				}
			}
			map.entrySet().stream().forEach(x->System.out.print(x.getValue() + " "));
		}
		
	}
	private static void leftView() {
		Node current = root;
		ArrayList<Integer> ans = new ArrayList<>();
		int level =0;
		left_view(current, level, ans);
	}
	
	private static void left_view(Node current, int level, ArrayList<Integer> ans) {
		
		if(current==null)
			return;
		if( level == ans.size()){
			ans.add(current.data);
		}
		left_view(current.left, level+1, ans);
		left_view(current.right, level+1, ans);
	}
	private static void max_depth() {
		Node current = root;

		int findDepth = findDepth(current);
		System.out.println(findDepth);
	}
	private static int findDepth(Node current) {

		while(current == null)
			return 0;
			int l = findDepth(current.left);
			int r = findDepth(current.right);
			
		return 1+Math.max(l, r);
		
	}
	private static void level_order() {
		List<List<Integer>> ans = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		if(root ==null) {
			return;
		}else {
			queue.offer(root);
			
			while(!queue.isEmpty()) {
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
		
	}
	private static void insert() {
		System.out.println("Enter Element :");
		Scanner scan=new Scanner(System.in);
		int ele=scan.nextInt();
		
		Node node = new Node();
		node.left=null;
		node.data=ele;
		node.right=null;
		
		if(root ==null) {
			root = node ;
		}
		else{
			Node pre = null;
			Node curr = root;
			while(curr != null) {
				if(curr.data > node.data) {
					pre = curr;
					curr=curr.left;
				}
				else {
					pre=curr;
					curr=curr.right;
				}
			}
			
			if(pre.data > node.data)
			{
				pre.left=node;
			}
			else {
				pre.right=node;
			}
		}
		
	}
	
}

class pair{
	Node node;
	int i;
	pair(Node node , int i){
		this.node = node;
		this.i = i;
	}
}
