package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class MaxTimeToBurnTree {

	public void timeReqToBurnTree(Node root) {
		
		System.out.println("Enter target Node");
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		Map<Node, Node> parentTrack = new HashMap<>();
		Node nodeRef = markParent(root,parentTrack, val);
		int timeToBurn = timeToBurn(root, parentTrack, nodeRef);
		System.out.println(timeToBurn);
	}
	
	private Node markParent(Node root, Map<Node, Node> parentTrack, int val){
		Node res = null;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node parent = queue.poll();
			if(parent.data == val)
				res = parent;
			
			if(parent.left != null) {
				parentTrack.put(parent.left, parent);
				queue.offer(parent.left);
			}
			if(parent.right != null) {
				parentTrack.put(parent.right, parent);
				queue.offer(parent.right);
			}
		}
		
		return res;
	}
	
	public int timeToBurn(Node root, Map<Node, Node> parentTrack, Node target){
		int time = 0;
		boolean flag = false;
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(target);
		visited.put(target, true);
		while(!queue.isEmpty()) {
			flag = false;
			int size = queue.size();
			for(int i = 0 ; i<size; i++) {
				Node current = queue.poll();
				if(current.left != null && visited.get(current.left) == null) {
					flag = true;
					queue.offer(current.left);
					visited.put(current.left, true);
				}
				if(current.right != null && visited.get(current.right) == null) {
					flag = true;
					queue.offer(current.right);
					visited.put(current.right, true);
				}
				if(parentTrack.get(current)!=null && visited.get(parentTrack.get(current)) == null) {
					flag = true;
					queue.offer(parentTrack.get(current));
					visited.put(parentTrack.get(current), true);
				}
			}
			if(flag)
			{
				time++;
			}
		}
		
		return time;
		
	}

}
