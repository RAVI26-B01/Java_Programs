package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> threeSum = threeSum(nums);
		System.out.println(threeSum);
		
	}
	
	 public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums); 
		List<List<Integer>> ans = new ArrayList<>();
		int n = nums.length;
		
		for(int i = 0 ; i<n-2 ; i++) {
			
			if (nums[i] > 0) break;
			 
			if(i>0 && nums[i]==nums[i-1]) continue;
			int j = i+1;
			int k = n-1;
			
			while(j<k) {
				int sum = nums[i]+nums[j]+nums[k];
				if(sum > 0) {
					k--;
				}
				else if(sum < 0) {
					j++;
				}
				else {
					ArrayList<Integer> subArr = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
					ans.add(subArr);
					k--;
					j++;
					
					while(j<k && nums[j]==nums[j-1]) j++;
					while(j<k && nums[k]==nums[k+1]) k--;
				}
			}
		}
		
		return ans;
	 }

}
