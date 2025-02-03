package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RootToNodePath {

	public List<Integer> rootToNodePath(Node root){
		System.out.println("Enter Node to find");
		Scanner scan = new Scanner(System.in);
		int nodeVal = scan.nextInt();
		List<Integer> ans = new ArrayList<>();
		findNodePath(root, nodeVal, ans);
		return ans;
	}

	private boolean findNodePath(Node root, int nodeVal,  List<Integer> ans) {
		if(root == null)
			return false;
		
		ans.add(root.data);
		if(nodeVal== root.data)
			return true;
		
		if( findNodePath(root.left , nodeVal, ans) || findNodePath(root.right, nodeVal, ans))
			return true;
		
		int size = ans.size();
		ans.remove(size-1);
		return false;
		
	}

	
	
	public List<String> rootToNodeAllPath(Node root) {
		List<String> ans = new ArrayList<>();
		findNodeAllPath(root, ans, new StringBuilder());
		return ans;
	}

	private void findNodeAllPath(Node root, List<String> ans, StringBuilder sb) {
		if(root==null)
			return;
		
		if(sb.length()!=0){
            sb.append("->");
        }
        sb.append(root.data);
		if(root.left == null && root.right == null)
		{
			ans.add(sb.toString());
		}
		
		findNodeAllPath(root.left, ans, new StringBuilder(sb)); // we have to use "new StringBuilder" on every stack call
		findNodeAllPath(root.right, ans, new StringBuilder(sb));// a current value should be available.
		
	}
}
