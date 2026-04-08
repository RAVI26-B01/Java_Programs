package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

class treenode{
	treenode left;
	int data;
	treenode right;
}


class demoPair{
	treenode node;
	int index;
	public demoPair(treenode node, int index) {
		this.node = node;
		this.index = index;
	}
}

class demoTupple{
	treenode node;
	int index;
	int level;
	public demoTupple(treenode node, int index, int level) {
		this.node = node;
		this.index = index;
		this.level = level;
	}
}

public class Demo3 {
	
	static treenode root = null;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			
			System.out.println("press 1 to insert");
			System.out.println("press 2 to preorder");
			System.out.println("press 3 to morris in-order");
			System.out.println("press 4 to left view");
			System.out.println("press 5 to top view");
			System.out.println("press 6 to vertical view");
			System.out.println("press 7 to level order");
			System.out.println("press 8 to boundary travelrsal");
			System.out.println("press 9 to reverse odd level");
			System.out.println("press 10 to burn tree");
			System.out.println("press 100 to display");
			int n = scan.nextInt();
			
			switch (n) {
			case 1 : addElelemt(root);break;
			case 2 : preOrder(root);break;
			case 3 : morrisInOrder(root);break;
			case 4 : leftView(root);break;
			case 5 : topView(root);break;
			case 6 : verticalView(root);break;
			case 7 : levelOrder(root);break;
			case 8 : boundaryTraversal(root);break;
			case 9 : reverseOddLevel(root);break;
			case 10: burnTree(root);break;
			case 100 :printTree(root);break;
			default:System.exit(0);
			}
		}
		
	}


	private static void burnTree(treenode root) {
		System.out.println("enter node");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Map<treenode, treenode> parentNode = new HashMap<>();
		treenode ref = parentMapping(root, parentNode, n);
		timeToBurn(root, parentNode, ref);
	}


	private static void timeToBurn(treenode root, Map<treenode, treenode> parentNode, treenode ref) {
		
		Map<treenode, Boolean> visited = new HashMap<>();
		Queue<treenode> queue = new LinkedList<>();
		queue.add(ref);
		visited.put(ref, true);
		int time = 0;
		boolean flag;
		while(!queue.isEmpty()) {
			int size = queue.size();
			flag = false;
			for(int i = 0 ; i<size ; i++) {
				treenode treenode = queue.poll();
				
				if(treenode.left != null && visited.get(treenode.left) == null) {
					flag = true;
					queue.add(treenode.left);
					visited.put(treenode.left, true);
				}
				if(treenode.right != null && visited.get(treenode.right) == null) {
					flag = true;
					queue.add(treenode.right);
					visited.put(treenode.right, true);
				}
				
				if(parentNode.get(treenode)!= null && visited.get(parentNode.get(treenode)) == null) {
					flag = true;
					queue.add(parentNode.get(treenode));
					visited.put(parentNode.get(treenode), true);
				}
			}
			
			if(flag)
				time++;
			
		}
		
		System.out.println(time);
		
	}


	private static treenode parentMapping(treenode root, Map<treenode, treenode> parentNode, int n) {
		treenode ref = null;
		Queue<treenode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			treenode node = queue.poll();
			if(node.data == n)
				ref = node;
			
			if(node.left != null)
			{
				queue.add(node.left);
				parentNode.put(node.left, node);
			}
			if(node.right != null)
			{
				queue.add(node.right);
				parentNode.put(node.right, node);
			}
			
		}
		
		return ref;
		
	}


	private static void reverseOddLevel(treenode root) {
		
		int level = 0;
		Queue<treenode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<treenode> list = new ArrayList<>();
			for(int i = 0 ; i<size ; i++) {
				treenode poll = queue.poll();
				list.add(poll);
				if(poll.left != null)
				{
					queue.add(poll.left);
					
				}
				if(poll.right != null)
				{
					queue.add(poll.right);
				}
			}
			if(level % 2 == 1 ) {
				reverseLevel(list);
			}
			level++;
		}
		
	}


	private static void reverseLevel(List<treenode> list) {
		
		int size = list.size();
		for(int i = 0, j=size-1 ; i<j ; i++,j--) {
			int temp = list.get(i).data;
			list.get(i).data = list.get(j).data;
			list.get(j).data = temp;
		}
		
	}


	private static void boundaryTraversal(treenode root) {
		List<Integer> ans = new ArrayList<>();
		System.out.println(boundary(root, ans));;
	}


	private static List<Integer> boundary(treenode curr, List<Integer> ans) {
		
		if(curr!=null) {
			ans.add(curr.data);
		}
		leftBoundary(curr, ans);
		leaveBoundary(curr, ans);
		rightBoundary(curr, ans);
		
		return ans;
	}


	private static void leaveBoundary(treenode curr, List<Integer> ans) {
		if(leafNode(curr))
			ans.add(curr.data);
		if(curr.left != null)
			leaveBoundary(curr.left, ans);
		if(curr.right != null)
			leaveBoundary(curr.right, ans);
	}


	private static void rightBoundary(treenode curr, List<Integer> ans) {

		curr = curr.right;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		while(curr != null) {
			if(!leafNode(curr)) {
				temp.add(curr.data);
			}
			if(curr.right != null)
				curr= curr.right;
			else
				curr = curr.left;
		}
		
		Collections.reverse(temp);
	
		ans.addAll(temp);
	}


	private static void leftBoundary(treenode curr, List<Integer> ans) {
		curr = curr.left;
		while(curr != null) {
			if(!leafNode(curr)) {
				ans.add(curr.data);
			}
			if(curr.left != null)
				curr= curr.left;
			else
				curr = curr.right;
		}
	}


	private static boolean leafNode(treenode curr) {
		return (curr.left == null && curr.right == null);
	}


	private static void levelOrder(treenode root) {
		
		Queue<treenode> queue = new LinkedList<>();
		queue.add(root);
		List<List<Integer>> ans = new ArrayList<>();
		while(!queue.isEmpty()) {
			
			
			int size = queue.size();
		
			List<Integer> subList = new ArrayList<>();
			for(int i = 0 ; i<size ; i++) {
				treenode node = queue.poll();
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null){
					queue.offer(node.right);
				}
				subList.add(node.data);
			}
			ans.add(subList);
		}
		System.out.println(ans);
	}


	private static void verticalView(treenode root) {
		Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<demoTupple> queue = new LinkedList<>();
		
		queue.add(new demoTupple(root, 0, 0));
		
		while(!queue.isEmpty()) {
			demoTupple poll = queue.poll();
			treenode node = poll.node;
			int index = poll.index;
			int level = poll.level;
			if(!map.containsKey(index)) {
				map.put(index, new TreeMap<>());
			}
			
			if(!map.get(index).containsKey(level)) {
				map.get(index).put(level, new PriorityQueue<>());
			}
			
			map.get(index).get(level).add(node.data);
			
			if(node.left != null) {
				queue.add(new demoTupple(node.left, index-1, level+1));
			}
			if(node.right != null) {
				queue.add(new demoTupple(node.right, index+1, level+1));
			}
		}
		
		List<List<Integer>> ans = new ArrayList<>();
		
		for(Map<Integer, PriorityQueue<Integer>> v1: map.values()) {
			ans.add(new ArrayList<>());
			for(PriorityQueue<Integer> pq : v1.values()) {
				while(!pq.isEmpty()) {
					ans.get(ans.size()-1).add(pq.poll());
				}
			}
		}
		
		System.out.println(ans);
	}


	private static void topView(treenode root) {
		List<Integer> ans = new ArrayList<>();
		
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<demoPair> queue = new LinkedList<>();
		queue.add(new demoPair(root, 0));
		
		while(!queue.isEmpty()) {
			demoPair poll = queue.poll();
			
		//	if(!map.containsKey(poll.index))
				map.put(poll.index, poll.node.data);
			
			if(poll.node.left != null) {
				queue.add(new demoPair(poll.node.left, poll.index-1));
			}
			if(poll.node.right != null) {
				queue.add(new demoPair(poll.node.right, poll.index+1));
			}
		}
		
		map.entrySet().stream().forEach(x->ans.add(x.getValue()));
		System.out.println(ans);
		
		
	}


	private static void leftView(treenode root2) {
		int level =0;
		List<Integer> ans = new ArrayList<>();
		leftViewAns(root2, level, ans);
		System.out.println(ans);
	}


	private static void leftViewAns(treenode current, int level, List<Integer> ans) {
		if(current==null)
			return;
		if( level == ans.size()){
			ans.add(current.data);
		}
		leftViewAns(current.left, level+1, ans);
		leftViewAns(current.right, level+1, ans);
	}


	private static void morrisInOrder(treenode root) {
		treenode curr = root;
		List<Integer> ans = new ArrayList<>();
		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.data);
				curr=curr.right;
			}else {
				treenode prev = curr.left;
				
				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				
				if(prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				}else {
					prev.right = null;
					ans.add(curr.data);
					curr = curr.right;
				}
			}
		}
		
		System.out.println(ans);
	}


	private static void preOrder(treenode root2) {
		Stack<treenode> stack = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		treenode curr = root2;
		stack.add(curr);
		
		while(!stack.isEmpty()) {
			treenode pop = stack.pop();
			ans.add(pop.data);
			
			if(pop.right != null) {
				stack.add(pop.right);
			}
			if(pop.left != null) {
				stack.add(pop.left);
			}
		}
		System.out.println(ans);
	}


	private static void addElelemt(treenode root2) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter element to be added");
		int ele = scan.nextInt();
		treenode tn = new treenode();
		tn.data = ele;
		if(root == null)
		{
			root = tn;
		}else {
			treenode prev = null;
			treenode curr = root;
			
			while(curr != null) {
				
				if(curr.data > ele) {
					prev = curr;
					curr = curr.left;
				}else {
					prev = curr;
					curr = curr.right;
				}
			}
			
			if(prev.data > ele) {
				prev.left = tn;
			}
			else {
				prev.right = tn;
			}
		}
	}
	
	private static void printTree(treenode root2) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

	
	

	private static <T extends Comparable<?>> void printNodeInternal(List<treenode> nodes, int level, int maxLevel) {
	        if (nodes.isEmpty() || isAllElementsNull(nodes))
	            return;

	        int floor = maxLevel - level;
	        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
	        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
	        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

	        printWhitespaces(firstSpaces);

	        List<treenode> newNodes = new ArrayList<treenode>();
	        for (treenode node : nodes) {
	            if (node != null) {
	                System.out.print(node.data);
	                newNodes.add(node.left);
	                newNodes.add(node.right);
	            } else {
	                newNodes.add(null);
	                newNodes.add(null);
	                System.out.print(" ");
	            }

	            printWhitespaces(betweenSpaces);
	        }
	        System.out.println("");

	        for (int i = 1; i <= endgeLines; i++) {
	            for (int j = 0; j < nodes.size(); j++) {
	                printWhitespaces(firstSpaces - i);
	                if (nodes.get(j) == null) {
	                   printWhitespaces(endgeLines + endgeLines + i + 1);
	                    continue;
	                }

	                if (nodes.get(j).left != null)
	                    System.out.print("/");
	                else
	                    printWhitespaces(1);

	               printWhitespaces(i + i - 1);

	                if (nodes.get(j).right != null)
	                    System.out.print("\\");
	                else
	                    printWhitespaces(1);

	               printWhitespaces(endgeLines + endgeLines - i);
	            }

	            System.out.println("");
	        }

	        printNodeInternal(newNodes, level + 1, maxLevel);
	    }

	    private static void printWhitespaces(int count) {
	        for (int i = 0; i < count; i++)
	            System.out.print(" ");
	    }

	    private static <T extends Comparable<?>> int maxLevel(treenode root2) {
	        if (root2 == null)
	            return 0;

	        return Math.max(maxLevel(root2.left),maxLevel(root2.right)) + 1;
	    }

	    private static <T> boolean isAllElementsNull(List<T> list) {
	        for (Object object : list) {
	            if (object != null)
	                return false;
	        }

	        return true;
	    }

	}


