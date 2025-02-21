package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {

	public String serialize(Node root) {
		StringBuffer s = new StringBuffer();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node == null) {
				s.append("# ");
				continue;
			}
			s.append(node.data+" ");
			queue.add(node.left);
			queue.add(node.right);
		}
		return s.toString();
	}
	
	
	public Node deSerialize(String s) {
		if(s.isEmpty())
			return null;
		Queue<Node> queue = new LinkedList<>();
		String[] ar = s.split(" ");
		Node root = new Node(Integer.parseInt(ar[0]));
		queue.add(root);
		for(int i = 1 ; i<ar.length ; i++) {
			Node node = queue.poll();
			if(!ar[i].equals("#")) {
				Node left = new Node(Integer.parseInt(ar[i]));
				node.left = left;
				queue.add(left);
			}
			if(!ar[++i].equals("#"))  {
				Node right = new Node(Integer.parseInt(ar[i]));
				node.right = right;
				queue.add(right);
			}
		}
		
		return root;
		
	}
}
