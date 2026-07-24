package leetcode;

import java.util.Arrays;

public class FirstAndLastPosition_34 {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}
	
	public static int[] searchRange(int[]nums,int target){
		  int first=findPosition(nums,target,true);
		  int last=findPosition(nums,target,false);
		  return new int[]{first,last};
		 }
	
	 public static int findPosition(int[] nums, int target, boolean findFirst) {
		 int left=0, right=nums.length-1, pos=-1;
		  while(left<=right){
			   int mid=left+(right-left)/2;
			   
			   if(nums[mid]==target){
				    pos=mid;
				    if(findFirst){
				    	right=mid-1;
				    }else{
				    	left=mid+1;
				    }
			   }else if(nums[mid]<target){
				   left=mid+1;
			   }else{
				   right=mid-1;
			   }
		}
		return pos;
	 }
}
