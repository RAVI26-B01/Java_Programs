package leetcode;

import java.util.Arrays;

public class TwoSum_II_167 {
	public static void main(String[] args) {
		int[] nums = {2,3,5,6,7,11,15,19};
		int[] twoSum = twoSum(nums, 12); //3,5
		System.out.println(Arrays.toString(twoSum));
	}
	
	 public static int[] twoSum(int[] nums, int target) {
	        int start = 0, end = nums.length - 1;

	        while (start < end) {
	            int currentSum = nums[start] + nums[end];
	            if (currentSum == target) {
	                return new int[] {start + 1, end + 1}; 
	            } else if (currentSum > target) {
	                end--; 
	            } else {
	                start++; 
	            }
	        }

	        return new int[] {-1, -1};
	    }
}
