package leetcode;

import java.util.ArrayList;
import java.util.List;

import binaryTree.Node;

public class PathSum_113 {
	List<List<Integer>> ans = new ArrayList<>();
	public List<List<Integer>> pathSum(Node root, int targetSum) {
		
		 List<List<Integer>> ans = new ArrayList<>();
	        int sum = 0;
	        pathSum(root, targetSum, sum, ans, new ArrayList<>() );
	        return ans;
	    }

	    public void pathSum(Node root, int targetSum, int sum, 
	                        List<List<Integer>> ans , List<Integer> currentList){
	        if(root == null)
	            return;
	        currentList.add(root.data);
	        sum += root.data;

	        if(root.left == null && root.right == null && sum==targetSum){
	            ans.add(new ArrayList<>(currentList));
	        }

	        pathSum(root.left, targetSum, sum, ans, currentList);
	        pathSum(root.right, targetSum, sum, ans, currentList);
	        currentList.remove(currentList.size()-1);
	    }
	
}
