package leetcode;

import java.util.Arrays;

public class FirstAndLastPosition_34 {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}
	
	 public static int[] searchRange(int[] nums, int target) {
		 	int low = 0 ;
		 	int high = nums.length-1;
		 	
		 	while(low<=high) {
		 		int mid = (low+high)/2;
		 		
		 		if(nums[mid] == target) {
		 			if(mid+1<nums.length && nums[mid]==nums[mid+1])
		 				 return new int[] {mid ,mid+1};
		 			return new int[] {mid ,mid};
		 		}
		 		
		 		if(nums[mid]<target)
		 			low = mid+1;
		 		else
		 			high = mid -1;
		 	}
		 
	        return new int[] {-1,-1};
	    }
}
