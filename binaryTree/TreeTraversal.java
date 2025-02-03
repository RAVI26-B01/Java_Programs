package binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Tuple{
	Node node;
	int index;
	int level;
	public Tuple(Node current, int index, int level) {
		this.node=current;
		this.index=index;
		this.level = level;
	}
}

public class TreeTraversal {
	
	class Pair{
		Node node;
		int hd;
		public Pair(Node current, int i) {
			this.node=current;
			this.hd=i;
		}
	}

	public static List<List<Integer>> levelOrderTraversal(Node current) {
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if(current == null){
			return ans;
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
		return ans;
	}
	
	public static List<List<Integer>> zigZagOrderTraversal(Node current) {
		Queue<Node> queue = new LinkedList<>();
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if(current == null){
			return ans;
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
		return ans;
	}

	public static List<List<Integer>> verticalOrderTraversal(Node current) {
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		if(current == null)
			return ans;
		
		Queue<Tuple> queue = new LinkedList<>();
		queue.offer(new Tuple(current, 0, 0));
		
		while(!queue.isEmpty()) {
			Tuple pair = queue.poll();
			Node node = pair.node;
			int index = pair.index;
			int level = pair.level;
			if(!map.containsKey(index)) {
				map.put(index, new TreeMap<>());
			}
			if(!map.get(index).containsKey(level)) {
				map.get(index).put(level, new PriorityQueue<>());
			}
			
			map.get(index).get(level).offer(node.data);
			
			if(node.left != null) {
				queue.offer(new Tuple(node.left, index-1, level+1));
			}
			if(node.right != null) {
				queue.offer(new Tuple(node.right, index+1, level+1));
			}
		}
		
		for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
			ans.add(new ArrayList<>());
			for(PriorityQueue<Integer> nodes: ys.values()) {
				while(!nodes.isEmpty()) {
					ans.get(ans.size()-1).add(nodes.poll());
				}
			}
		}
		return ans;
	}
	
	 public int widthOfBinaryTree(Node root) {
		 	int ans = 0;
	        if (root == null) {
	            return 0;
	        }

	        Queue<Pair> q = new LinkedList<>();
	        q.add(new Pair(root, 0));

	        while (!q.isEmpty()) {
	            int size = q.size();
	            int mmin = q.peek().hd;
	            int first =0, last = 0;

	            for (int i = 0; i < size; i++) {
	                int cur_id = q.peek().hd - mmin;
	                Node node = q.peek().node;
	                q.poll();

	                // If this is the first node in the level,
	                // update the 'first' variable
	                // starting node can start from any where
	                if (i == 0) {
	                    first = cur_id;
	                }

	                // If this is the last node in the level,
	                // update the 'last' variable
	                if (i == size - 1) {
	                    last = cur_id;
	                }

	                if (node.left != null) {
	                    q.add(new Pair(node.left, cur_id * 2 + 1));
	                }
	                if (node.right != null) {
	                    q.add(new Pair(node.right, cur_id * 2 + 2));
	                }
	            }
	            ans = Math.max(ans, last - first + 1);
	        }
	        return ans;
	    }
	
	
}
