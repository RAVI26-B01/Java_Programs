package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class PrintKDistanceNodes {

	public void findDistanceK(Node root) {
		System.out.println("Enter target Node");
		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();
		Node nodeRef = findNodeRef(root, val);
		Map<Node, Node> parentTrack = new HashMap<>();
		markParent(root,parentTrack, nodeRef);
		
		System.out.println("Enter distance K");
		int k = scan.nextInt();
		List<Integer> distanceK = distanceK(root, parentTrack, nodeRef, k);
		System.out.println(distanceK);
	}

	private Node findNodeRef(Node root, int val) {
		if(root == null)
			return null;
		if(root.data == val)
			return root;
	    Node leftResult = findNodeRef(root.left, val);
	    if (leftResult != null) {
	        return leftResult;
	    }
	    return findNodeRef(root.right, val);
	}
	
	private void markParent(Node root, Map<Node, Node> parentTrack, Node nodeRef){
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node parent = queue.poll();
			if(parent.left != null) {
				parentTrack.put(parent.left, parent);
				queue.offer(parent.left);
			}
			if(parent.right != null) {
				parentTrack.put(parent.right, parent);
				queue.offer(parent.right);
			}
		}
	}
	
	private List<Integer> distanceK(Node root, Map<Node, Node> parentTrack, Node target, int k) {
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		
		queue.offer(target);
		visited.put(target, true);
		int curr_level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			if(curr_level == k) break;
			curr_level++;
			
			for(int i = 0 ; i<size; i++) {
				Node current = queue.poll();
				if(current.left != null && visited.get(current.left) == null) {
					queue.offer(current.left);
					visited.put(current.left, true);
				}
				if(current.right != null && visited.get(current.right) == null) {
					queue.offer(current.right);
					visited.put(current.right, true);
				}
				if(parentTrack.get(current)!=null && visited.get(parentTrack.get(current)) == null) {
					queue.offer(parentTrack.get(current));
					visited.put(parentTrack.get(current), true);
				}
			}
			
		}
		
		List<Integer> ans = new ArrayList<>();
		while(!queue.isEmpty()) {
			Node poll = queue.poll();
			ans.add(poll.data);
		}
		return ans;
	}


}
