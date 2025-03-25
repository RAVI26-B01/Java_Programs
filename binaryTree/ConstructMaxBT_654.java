package binaryTree;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ConstructMaxBT_654 {

	public static void main(String[] args) {
		int[] nums = {3,2,1,6,0,5};
		Node constructMaximumBinaryTree = constructMaximumBinaryTree(nums);
		TreePrinter.printNode(constructMaximumBinaryTree);
	}
	
	public static Node constructMaximumBinaryTree(int[] nums) {
		return constructTree(nums,0, nums.length-1);
    }

	private static Node constructTree(int[] nums, int si, int ei) {
		
		if(si>ei)
			return null;
		int maxIndex = findMaxIndex(nums, si, ei);
		Node root = new Node(nums[maxIndex]);

		root.left = constructTree(nums, si, maxIndex-1);
		root.right = constructTree(nums, maxIndex+1, ei);
		
		return root;
		
	}

	private static int findMaxIndex(int[] nums, int si, int ei) {
		int maxIndex = -1;
		int val = Integer.MIN_VALUE;
		for(int i = si ; i <=ei ; i++) {
			if(val < nums[i]) {
				val = nums[i];
				maxIndex = i;
			}
		}	
		return maxIndex;
	}
	
	/*
	 int idx = start;
        for(int i = start + 1;i<=end;i++){
            if(nums[i] > nums[idx]){
                idx = i;
            }
        }
	 */
}

