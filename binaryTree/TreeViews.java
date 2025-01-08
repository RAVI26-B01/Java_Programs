package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
	Node node;
	int hd;
	public Pair(Node current, int i) {
		this.node=current;
		this.hd=i;
	}
}

public class TreeViews {

	public List<Integer> topView(Node current) {
		List<Integer> ans = new ArrayList<>();
		if(current == null)
			return ans;
		Map<Integer,Integer> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(current,0));
		while(!queue.isEmpty()){
			Pair remove = queue.remove();
			int hd = remove.hd;
			Node temp = remove.node;
			if(!map.containsKey(hd))
				map.put(hd, temp.data);
			
			if(temp.left!=null){
				queue.add(new Pair(temp.left,hd-1));
			}
			if(temp.right!=null){
				queue.add(new Pair(temp.right,hd+1));
			}
		}
		map.entrySet().stream().forEach(x->ans.add(x.getValue()));
		return ans;
	}
	
	/*
	 * Left view starts
	 */
	public List<Integer> leftView(Node current) {
		ArrayList<Integer> ans = new ArrayList<>();
		leftViewOfTree(current,0,ans);
		return ans;
	}
	private static void leftViewOfTree(Node current, int level, ArrayList<Integer> ans) {
		if(current==null)
			return;
		if( level == ans.size()){
			ans.add(current.data);
		}
		leftViewOfTree(current.left, level+1, ans);
		leftViewOfTree(current.right, level+1, ans);
	}
	/*
	 * left view ends
	 */
	
	
	/*
	 * right view starts
	 */
	public List<Integer> rightView(Node current) {
		ArrayList<Integer> ans = new ArrayList<>();
		rightViewOfTree(current,0,ans);
		return ans;
	}
	
	private static void rightViewOfTree(Node current, int level, ArrayList<Integer> ans) {
		if(current==null)
			return;
		if( level == ans.size()){
			ans.add(current.data);
		}
		rightViewOfTree(current.right, level+1, ans);
		rightViewOfTree(current.left, level+1, ans);
	}
	/*
	 * right view ends
	 */
	
	
}
